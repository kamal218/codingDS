import java.util.*;
import java.util.Collections;

public class ClientSort {
    public static void main(String[] args) {
        List<Student> list = new ArrayList();
        list.add(new Student("kamal", 2, 56));
        list.add(new Student("rahul", 3, 6));
        list.add(new Student("gaurav", 6, 46));
        list.add(new Student("himanshu", 4, 96));
        list.add(new Student("rakesh", 9, 10));
        // inbuilt collections has written sort for all in built functions but not for
        // user defined class (bubble sort)
        /*
         * // using comparable Collections.sort(list); System.out.println(list);
         */

        // using comparator
        // Method 1
        // Comparator<Student> com = new comp();
        // Collections.sort(list, com);
        // System.out.println(list);

        // Method 2 Anonoymous function
        // Comparator<Student> com = new Comparator<Student>() {
        // @Override
        // public int compare(Student a, Student b) {
        // return a.getRollNo() - b.getRollNo();
        // }
        // };

        // Method 3 Lambda function
        // Comparator<Student> com = (a, b) -> {
        // return a.getRollNo() - b.getRollNo();
        // };
        // Collections.sort(list, com);
        // System.out.println(list);
    }
}