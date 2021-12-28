package comparator;

import model.Student;

import java.util.Comparator;

public interface StudentComparator extends Comparator<Student> {
    @Override
     int compare(Student o1, Student o2);
}
