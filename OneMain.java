import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class OneMain {
    public static void main(String[] args) {
        //basic implementation of functional interface using lambda expression
        //Functional interface will have only one abstract class
        MathOperation sumOperation = ((a, b) -> a + b);
        MathOperation subtractOperation = ((a, b) -> a - b);
        System.out.println(sumOperation.operate(2, 4));
        System.out.println(subtractOperation.operate(8, 3));

        //Predicate is a functional interface that has an abstract method test returns boolean
        Predicate<Integer> isEven = x -> (x & 1) == 0;
        System.out.println(isEven.test(4));
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> endsWithT = s -> s.toLowerCase().endsWith("t");
        Predicate<String> and = startsWithA.and(endsWithT);
        System.out.println(and.test("Akshay"));

        //Function works for you Function<Input Type, Output Type>
        Function<String, String> doubleIt = x -> x + "a";
        Function<String, String> tripleIt = x -> x + "b";
        System.out.println(doubleIt.andThen(tripleIt).apply("xyz"));
        System.out.println(tripleIt.andThen(doubleIt).apply("xyz"));
        System.out.println(doubleIt.compose(tripleIt).apply("xyz"));

        //Consumer don't return anything
        List<Integer> list = Arrays.asList(1, 2, 3);
        Consumer<List<Integer>> printList = x -> {
            for (int i : x)
                System.out.println(i);
        };

        printList.accept(list);

        //Supplier don't take anything in input but return something
        Supplier<String> hello = () -> "Hello World";
        System.out.println(hello.get());
        ;

//        Ways to generate streams
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5); //1st way
        Stream<Integer> stream = intList.stream();

        String[] strArr = {"a","v","j","c"};
        Stream<String> stream1 = Arrays.stream(strArr); //2nd way

        Stream<Integer> stream3 = Stream.of(1,2,3,4,5); //3rd way

        //generate infinite stream
        Stream<Integer> stream4 = Stream.generate(() -> 1);

        Stream<Integer> stream6 = Stream.iterate(0,x -> x+1);

        //convert above stream to finite stream
        Stream<Integer> stream5 = Stream.generate(() -> 1).limit(100);


    }
}

interface MathOperation {
    abstract int operate(int a, int b);
}