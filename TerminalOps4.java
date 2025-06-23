import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps4 {
    public static void main(String[] args) {
        //Terminal Operations
        List<Integer> intList = Arrays.asList(1,2,3,4,5,6);

        //1.collect
        System.out.println(intList.stream().map(x -> 2*x).collect(Collectors.toList()));
        System.out.println(intList.stream().skip(1).toList());

        //2. forEach
        intList.stream().forEach(x -> System.out.print(x +" "));
        intList.forEach(System.out::println);

        //3. reduce returns Optional
        //combine elements to produce a single result
        Optional<Integer> res = intList.stream().reduce((x, y) -> x+y);
        System.out.println(intList.stream().reduce((x,y) -> x+y).get());

        //4. count returns long
        System.out.println(intList.stream().filter(x -> x%2 == 0).count());

        //5. allMatch, anyMatch, noneMatch ---- all returns boolean value
        System.out.println(intList.stream().allMatch(x-> x>0));
        System.out.println(intList.stream().anyMatch(x -> x%2 == 0));
        System.out.println(intList.stream().noneMatch(x -> x <0));

        //6. findFirst, findAny
        System.out.println(intList.stream().findFirst().orElse(0));
        System.out.println(intList.stream().findAny().get());

        //Above examples(5,6) are of short-circuiting in streams -> As once the element is found, it will not iterate further

        //7. toArray
        Object[] arr = Stream.of(1,2,3,4,6,2,5).toArray();

        //8.min/max  - min means it will pick first element after sorting and vice versa for max
        System.out.println( Stream.of(2,45,12,13,67).max(Comparator.naturalOrder()).get());
        System.out.println( Stream.of(2,45,12,13,67).min(Comparator.naturalOrder()).get());
        System.out.println( Stream.of(2,45,12,13,67).max((o1,o2) -> o2-o1).get());
        System.out.println( Stream.of(2,45,12,13,67).min((o1,o2) -> o2-o1).get());

        //counting occurance of character l
        String sentence = "Hello World";
        System.out.println(sentence.chars().filter(x -> x == 'l').count());


        //stateful(distinct, sorted) and stateless(map,filter)
        List<String> name = Arrays.asList("Shyam","koyal","Ghanshyam","Piku");
        Stream<String> stream = name.stream();
        stream.forEach(System.out::println);
//        List<String> names = stream.map(String::toUpperCase).toList(); //Exception as stream has already been consumed




    }

}
