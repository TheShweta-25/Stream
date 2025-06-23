package EPAMStreamPractice;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAndCharacter {
    public static void main(String[] args) {
        String hello = "hello world";

        //Count frequency of each character in a string.
       Map<Character,Long> result = hello.chars().filter(s -> !Character.isWhitespace(s))
                                     .mapToObj(c -> (char)c)
                                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);

        //Remove all non-digit characters from a string using streams.
        String nonD = "abc123!@#45def";
        String dig = nonD.chars().filter(Character::isDigit).mapToObj(x -> String.valueOf((char)x)).collect(Collectors.joining());
        System.out.println(dig);

        //Find first non-repeating character in a string.
        String str = "swiss";
        Map<Character,Long> charNonRepeat = str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        char c = charNonRepeat.entrySet().stream().filter(entry -> entry.getValue() == 1).map(ent -> ent.getKey()).findFirst().orElse('0');
        System.out.println("First Non repeating character is "+c);

        //Check if a string is a palindrome using streams.
        String temp = "madam";
        String pal = temp.replaceAll("\\s+","").toLowerCase();

        boolean b = IntStream.range(0,pal.length()/2).allMatch(i -> pal.charAt(i) == pal.charAt(pal.length()-i-1));
        System.out.println(temp+" is pallindrome "+b);

        //Filter valid decimal numbers from a list of strings.
        List<String> input = List.of("123", "45.67", "-3.14", "abc", "12.34.56", "", "0.001", "1e10");
        List<String> output = input.stream().filter(StreamAndCharacter::isValidDecimal).toList();
        System.out.println("valid decimal numbers are "+output);



    }

    public static boolean isValidDecimal(String s){
        try{
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
