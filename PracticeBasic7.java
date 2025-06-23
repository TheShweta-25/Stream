import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeBasic7 {
    public static void main(String[] args) {
        String name = "sheetal";
        Map<String,Long> map = Arrays.stream(name.split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println(map);

        List<Integer> list = Arrays.asList(1,2,3,3,4,4,5,6,6,6);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::print);
        System.out.println();
        //below line will throw java.lang.IllegalStateException as stream has already been closed above.(we have used terminate
        // operation forEach above )
//        System.out.println(stream.filter(x -> x%2 == 0).toList());

        String defaultValue = getDefault();

        Optional<String> optional = Optional.of("Sheetal");

        // orElse: getDefault() is called whether or not it's needed
        String value1 = optional.orElse(getDefault());

        // orElseGet: getDefault() is only called if optional is empty
        String value2 = optional.orElseGet(() -> getDefault());

        System.out.println("value1 = " + value1);
        System.out.println("value2 = " + value2);

        //Prime numbers
        List<Integer> primeList = Stream.iterate(2,x -> x+1).limit(50).toList();
        List<Integer> res = primeList.stream().filter(x -> {
            for(int i = 2;i<=Math.sqrt(x);i++){
                if(x%i == 0)
                    return false;
            }
            return true;
        }).toList();
        System.out.println(res);

        System.out.println(primeList.stream().filter(x -> IntStream.rangeClosed(2,(int)Math.sqrt(x)).allMatch( y -> x%y != 0)).toList());
        List<Integer> intList = Stream.iterate(1,x -> x+1).limit(50).toList();
        System.out.println( intList.stream().filter(x -> x%2 == 0).toList());
        System.out.println(intList.stream().filter(x -> x > 10).count());
        System.out.println(intList.stream().sorted((x,y) -> y-x).toList());
        System.out.println(list.stream().distinct().toList());
        System.out.println(intList.stream().min(Comparator.naturalOrder()).get());
        System.out.println(intList.stream().max(Comparator.naturalOrder()).get());
        System.out.println(intList.stream().reduce((Integer::sum)));
        System.out.println((Integer) intList.stream().mapToInt(x -> x).sum());
        System.out.println(intList.stream().collect(Collectors.averagingInt(x -> x)));

        //covert String array to character array by flatting each stream of character to a single character array
        //chars return IntStream
        List<String> words = Arrays.asList("Java","Stream","Hello","World","collect2","Operations");
        System.out.println(words.stream().flatMap(word -> word.chars().mapToObj(c -> (char)c)).distinct().toList());
        String[] names = {"Shweta","Shreya","Vanshali","Nawomita","Riya","Priya"};
        List<String> namesV = Stream.of(names).toList();
        System.out.println(namesV.stream().collect(Collectors.groupingBy(x -> x.charAt(0))));
        System.out.println(intList.stream().collect(Collectors.partitioningBy(x -> x%2==0)));
        System.out.println(namesV.stream().collect(Collectors.joining(",")));
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("apple","banana"),
                Arrays.asList("Kiwi","pear"),
                Arrays.asList("pineapple","dragonfruit"),
                Arrays.asList("custordApple","dragonfruit")
        );
        System.out.println(listOfList.stream().flatMap(x -> x.stream()).distinct().collect(Collectors.toList()));
        System.out.println(namesV.stream().filter(x -> x.length() > 5).sorted().toList());
        //Find the second highest number in a list
        System.out.println(list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
        //Find frequency of each element in a list
        System.out.println(list.stream().collect(Collectors.groupingBy(x -> x,Collectors.counting())));
        //Check if any string in a list contains a digit
        System.out.println(words.stream().flatMap(word -> word.chars().mapToObj(c -> (char) c)).anyMatch(Character::isDigit));
        //find String that contains digit
        System.out.println(words.stream().filter(x -> x.chars().anyMatch(Character::isDigit)).findAny().get());

    }

    static String getDefault() {
        System.out.println("getDefault() called");
        return "Default";
    }
}
