import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringPractice {
    public static void main(String[] args) {
        //find the frequency of most frequent character and if the frequency is even return true else false
        String s = "hello world";
        boolean res = s.chars().filter(c -> !Character.isWhitespace(c)).mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .values()
                .stream().max(Comparator.naturalOrder()).map(count -> count%2 == 0)
                .orElse(false);


        System.out.println(res);

        //filter out valid integers from a list of Strings and store it in an integer list
        List<String> input = Arrays.asList("as","123","32","2as");
        List<Integer> output = input.stream().filter(q -> q.matches("\\d+")).map(Integer::parseInt).toList();
        System.out.println(output);

    }
}
