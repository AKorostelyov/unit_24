package comparator;

import model.University;

import java.util.Comparator;

public interface UniversityComparator extends Comparator<University> {
    @Override
    int compare(University o1, University o2);
}
