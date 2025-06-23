import entity.Employee;
import entity.People;
import entity.Project;

import java.util.*;
import java.util.stream.Collectors;


public class PracticeStreamProblems8 extends Object{
    public static void main(String[] args) {
        //How do you convert a list of strings to a comma-separated string using streams?
        List<String> names = Arrays.asList("July","Pushpa","Shama","Karishma");
        String name = names.stream().collect(Collectors.joining(", "));
        System.out.println(name);
        Objects.hash(name);

        /*
        Abstraction Overhead:
        Streams provide a high-level abstraction and may introduce some overhead due to lambda expressions, method chaining, and internal iteration.
        Traditional for or while loops are usually faster in tight performance-critical code, especially when dealing with primitive types.
        Autoboxing/Unboxing:
        Stream operations may cause autoboxing, especially when using Stream<Integer> instead of IntStream. This adds to memory and CPU cost.
        Parallelism:
        Streams make it easier to achieve parallelism using .parallelStream(), which can lead to significant performance gains for CPU-intensive tasks on large datasets.
        However, parallel streams can also be slower if misused (e.g., small datasets, I/O operations, shared mutable state), due to the cost of thread management and splitting work.
         Lazy Evaluation:
        Stream pipelines are lazily evaluated, meaning operations are only performed when a terminal operation is invoked. This can optimize performance by avoiding unnecessary operations.
        Traditional loops evaluate eagerly — they do everything step by step, regardless of whether it's ultimately needed.
         */

        /*
       Q.  How would you handle exceptions inside a stream pipeline?
        Streams don't have built-in exception handling, especially for checked exceptions, so you need to handle
        them manually or use workarounds
         */

        //Q. Given a list of integers, return a list of squares of only even numbers.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        System.out.println(numbers.stream().filter(x -> x%2 ==0).map( x -> x*x).toList());

        //Q2: From a list of people, return the names of all people older than 18, sorted by age.
        List<People> people = Arrays.asList(
                new People("Shubham",22),
                new People("Sara",27),
                new People("Sanaya",26),
                new People("Akshay",19),
                new People("Rishu",13)
        );

        System.out.println(people.stream().filter(x -> x.getAge() > 18).sorted(Comparator.comparingInt(People::getAge)).map(People::getName).toList());

        //Q3: Count the frequency of each word in a given list using streams
        List<String> words = Arrays.asList("hello","world","java","world","stream","collection","stream");
        System.out.println(words.stream().collect(Collectors.toMap(x -> x,v -> 1,(x,y) -> x+y)));
        System.out.println(words.stream().collect(Collectors.groupingBy(x->x,Collectors.counting())));

        //Q4: Remove duplicate elements from a list and return a sorted version.
        System.out.println(words.stream().distinct().sorted().toList());

        //Q5: Group a list of employees by their department name using streams.
        List<Employee> employee = Arrays.asList(
                new Employee("Shubham","IT",23682),
                new Employee("Sara","Sales",13681),
                new Employee("Sanaya","IT",12378),
                new Employee("Akshay","Finance",37198),
                new Employee("Rishu","Sales",39289)
        );
        System.out.println(employee.stream().collect(Collectors.groupingBy(x -> x.getDepartment(),Collectors.counting())));
        System.out.println(employee.stream().collect(Collectors.groupingBy(x -> x.getDepartment(),Collectors.mapping(x -> x.getName(),Collectors.toList()))));
        System.out.println(employee.stream().collect(Collectors.groupingBy(x -> x.getDepartment(),Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))));


        /*
        Employee<Id,name,department,Lis<Project<name,role of person>>>

        1,Javob, IT, [Postpaid,SSE]
        2,Jain, Business, [Digital, LEAD]

        List<Employee>, in which project how many employee working

        o/p: Map key project name , count of person working in that project
         */
        List<Employee> employees = Arrays.asList(
                new Employee(Arrays.asList(new Project("Shubham", "Postpaid"), new Project("Shubham", "SSE"),new Project("Shubham", "Postpaid")),"Shubham"),
                new Employee(Arrays.asList(new Project("Sara", "Digital"), new Project("Sara", "Lead")),"Sara"),
                new Employee(Arrays.asList(new Project("Sanaya", "Postpaid"), new Project("Sanaya", "Lead")),"Sanaya"),
                new Employee(Arrays.asList(new Project("Akshay", "Postpaid"), new Project("Akshay", "Marketing")),"Akshay")
        );
        System.out.println("Employee data presentation");
        Map<String, Long> res = employees.stream().flatMap(emp -> emp.getList().stream().map(x -> x.getRole()).distinct())
                .collect(Collectors.groupingBy(x->x,Collectors.counting()));
        System.out.println(res);
        System.out.println(employees.stream().flatMap(emp -> emp.getList().stream().map(x -> x.getRole()).distinct()).toList());

       // Group all employees by their department and count how many employees are in each department.
        List<Employee> employeesList = Arrays.asList(
                new Employee("Alice", "HR", 50000, 30),
                new Employee("Bob", "Engineering", 70000, 28),
                new Employee("Charlie", "Engineering", 80000, 32),
                new Employee("David", "HR", 55000, 26),
                new Employee("Eva", "Sales", 60000, 29),
                new Employee("Frank", "Engineering", 72000, 27),
                new Employee("Grace", "Sales", 65000, 31)
        );

        System.out.println(employeesList.stream()
                .collect(Collectors.groupingBy(employee2 -> employee2.getDepartment(),Collectors.counting())));

        //Find the oldest person from a list of people
        Optional<Employee> maxAge = employeesList.stream().max(Comparator.comparing((Employee::getAge)));
        maxAge.ifPresent(p -> System.out.println("Oldest Person "+p.getName()));

        //Sort a list of objects based on multiple fields --> first by department then by salary desc
        System.out.println(employeesList.stream()
                .sorted(Comparator
                        .comparing(Employee::getDepartment)
                        .thenComparing(Comparator
                                .comparing(Employee::getSalary).reversed())).toList());

        //Find duplicate elements in a list


    }
}


