import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateTwo {
    public static void main(String[] args) {
        //Intermediate streams transform one stream to another stream.
        //They are lazy, they don't execute until a terminal operation is invoked.

        List<String> names = Arrays.asList("Akshit","Aman","Lagan","Shyam");
        //1. Filter
        Stream<String> filteredNames = names.stream().filter(x -> x.startsWith("A")); // no filtering at this point
        long countA = names.stream().filter(x -> x.startsWith("A")).count();
        System.out.println(countA);

        //2.Map
        // If I want to make changes in each element of the list and return the new list
        Stream<String> upperCase = names.stream().map(String::toUpperCase);

        //3. Sorted
        System.out.println(names.stream().sorted().collect(Collectors.toList()));;
        System.out.println(names.stream().sorted((a,b) -> a.length() - b.length()).collect(Collectors.toList()));
        System.out.println("Reverse Order "+names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //4.distinct
        System.out.println(names.stream().filter(x -> x.startsWith("A")).distinct().count());

        //5.limit
        //limit uses to decrease the count of an infinite or finite array to a certain value
        System.out.println(Stream.iterate(1,x -> x+1).limit(100).count());

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        numbers.stream().limit(5).forEach(x -> System.out.print(x+" "));

        //6.Skip
        //for below example, it will skip first 10 element
        System.out.println(Stream.iterate(1,x -> x+1).skip(10).limit(100).count());

        //7. peek - perform operation on each element as it consume
        Stream.iterate(1,x -> x+1).skip(10).limit(100).peek(System.out::print).count();
        System.out.println();

        //9. flatmap
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("apple","banana"),
                Arrays.asList("Kiwi","pear"),
                Arrays.asList("pineapple","dragonfruit")
        );

        System.out.println(listOfList.stream().flatMap(x -> x.stream()).map(String::toUpperCase).toList());

        List<String> wordList = Arrays.asList(
                "Hello World",
                "Java Streams are powerful",
                "flatMap is useful"
        );
        System.out.println( wordList.stream().flatMap(sen -> Arrays.stream(sen.split(" ")))
                .map(String::toUpperCase).toList());
    }
}
