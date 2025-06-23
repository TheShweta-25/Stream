import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo5 {
    public static void main(String[] args) {

        //1. Collectors to toList
        List<String> names = Arrays.asList("Alice","Bob","Charlie","David");
        System.out.println(names.stream().filter(x -> x.startsWith("A")).collect(Collectors.toList()));

        //2. Collectors to toSet
        List<Integer> numbers = Arrays.asList(1,2,2,3,4,5,5,6);
        System.out.println(numbers.stream().collect(Collectors.toSet()));

        //3. Collecting to a specific collection
        LinkedList<String> res = names.stream().map(String::toUpperCase).collect(Collectors.toCollection(LinkedList::new));

        //4. Joining Stream
        //Concatenate Streams into a single string
        String name = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(name);

        //5. Summarizing data  ---- generates statistical summary(sum, min, max, average, count)
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("max "+ stats.getMax());
        System.out.println("average "+stats.getAverage());
        System.out.println("count "+stats.getCount());
        System.out.println("min "+stats.getMin());
        System.out.println("sum "+stats.getSum());

        //6. calculating average
        System.out.println("Average is "+numbers.stream().collect(Collectors.averagingInt(x -> x)));

        //7. counting
        System.out.println(numbers.stream().collect(Collectors.counting()));

        //8. Grouping Element
        List<String> words = Arrays.asList("Java","Stream","Hello","World","collect","Operations");
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length,Collectors.joining(" "))));
        System.out.println(words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting())));

        //9. Partioning element --- partition elements based on prediactes
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)).get(true));

        //Examples
        String sentence = "hello world hello java world"; // group ny words
        Map<String,Long> groupW = Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println(groupW);

        List<Integer> list = Arrays.asList(1,2,3,4,5,6); //partioning even and odd numbers
        System.out.println(list.stream().collect(Collectors.partitioningBy(x -> x%2 == 0)));

        Map<String,Integer> fruits = new HashMap<>();
        fruits.put("apple", 10);
        fruits.put("banana",30);
        fruits.put("kiwi",32);

        System.out.println(fruits.values().stream().collect(Collectors.summingInt(x->x)));
        System.out.println(fruits.values().stream().reduce(Integer::sum).get());

        //creating group from stream element
        List<String> items = Arrays.asList("Apple","Banana","Cherry");
        System.out.println(items.stream().collect(Collectors.toMap(String::toUpperCase, String::length)));

        List<String> itemsList = Arrays.asList("Apple","Banana","Cherry","Apple","Orange","Apple","Banana");
        //both will return same result. create a map of element and find their occurances
        System.out.println(itemsList.stream().collect(Collectors.toMap(k->k,v->1,(x,y) -> x+y)));
        System.out.println(itemsList.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())));




    }
}
