import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Practice{
    public static void main(String[] args) {
        String name = "Sheetal";
        name.chars().collect(Collectors.groupingBy(a -> a,Collectors.counting()));
    }
}