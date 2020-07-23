import java.util.Comparator;

public class comp implements Comparator<Student> {

    @Override
    public int compare(Student a, Student b) {
        return a.getRollNo() - b.getRollNo();
    }

}