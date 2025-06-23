import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream6 {
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1,x-> x+1).limit(20000).toList();
        long startTime = System.currentTimeMillis();
        List<Long> resList = list.stream().map(ParallelStream6::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
         resList = list.parallelStream().map(ParallelStream6::factorial).toList();
         endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        //Parallel Streams are most effective for CPU intensive or large datasets where tasks are independent
        //They may add overhead for simple tasks or small dataset

        //Cumulative sum [1,2,3,4,5] -- > [1,3,6,10,15]
        AtomicInteger sum = new AtomicInteger(0);
        List<Integer> sumA = Arrays.asList(1,2,3,4,5);
        System.out.println(sumA.stream().map(x -> sum.addAndGet(x)).toList());




    }

    public static long factorial(int n){
        long res= 1;
        for(int i =2;i<n;i++){
            res*= i;
        }
        return res;
    }
}
