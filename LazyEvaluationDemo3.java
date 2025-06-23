import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo3 {
    public static void main(String[] args) {
        //Intermediate Stream operations are lazy, they don't execute until a terminal operation is invoked.
        List<String> name = Arrays.asList("Alice","Bob","David","Jack","Katy");
        Stream<String> stream = name.stream().filter(x -> {
            System.out.println("Filtering "+x);
            return x.length()>3;
        });

        System.out.println("Befor Termination");
        System.out.println(stream.collect(Collectors.toList()));;
        System.out.println("After Termination");
    }
}
