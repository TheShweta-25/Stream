package EPAMStreamPractice;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOneNumbers {
    public static void main(String[] args) {
        //filter even and find their squares
        int[] arr = {4,3,5,6,9,11,13,114,24,65,80};
        List<Integer> res = Arrays.stream(arr).filter(x -> x%2 == 0)
                .map(a -> a*a).boxed().toList();

        System.out.println(res);

        //find the 2nd highest number in the string
        List<Integer> numbers = Arrays.asList(4,3,5,6,9,11,13,114,24,65,80,6,4,11);
        Optional<Integer> secondHighest = numbers.stream()
                .distinct()
                .sorted((a, b) -> b - a)  // descending order
                .skip(1)
                .findFirst();
        System.out.println(secondHighest.orElseGet(()->-1));

        //Remove duplicates and sort a list of integers in descending order.
       List<Integer> sorted = numbers.stream().distinct().sorted(Comparator.reverseOrder()).toList();
        System.out.println(sorted);

        //Group numbers by even and odd into a Map<Boolean, List<Integer>>.
        Map<Boolean,List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(x -> x%2 == 0));
        System.out.println(result);

        //Find the average of all numbers in a list using mapToInt() and average()
        System.out.println(numbers.stream().collect(Collectors.averagingInt(x -> x)));
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println(stats.getAverage());

        System.out.println("Average using maptoInt and average() "+ numbers.stream().mapToInt(Integer::intValue).average());

    }
}
