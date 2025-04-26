import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InternediateOps {
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

        //4.distinct
        System.out.println(names.stream().filter(x -> x.startsWith("A")).distinct().count());

        //5.limit
        System.out.println(Stream.iterate(1,x -> x+1).limit(100).count());

        //6.Skip
        System.out.println(Stream.iterate(1,x -> x+1).skip(10).limit(100).count());
    }
}
