package EPAMStreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("word","java","hello","javelling","hi","coding","cat","java","word");
        //Group a list of words by their first character
        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x.charAt(0))));

        //Count number of occurrences of each word in a sentence.
        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));


        //Find most frequent word in a list using streams.
        String word = words.stream().collect(Collectors.groupingBy(x -> x,Collectors.counting())).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("NA");

        System.out.println(word);

        //Find duplicate elements in a list of strings using grouping.
        System.out.println(words.stream().collect(Collectors.groupingBy(x -> x,Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue() >= 2).map(Map.Entry::getKey).toList());

        //Partition a list of strings by length > 5 into two groups.
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

    }
}
