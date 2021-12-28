package comparator;

import model.Student;

public class StudentAvgExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        return (-1) * Double.compare(o1.getAvgExmScore(), o2.getAvgExmScore());
    }
}
