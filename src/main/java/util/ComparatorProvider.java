package util;

import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparators;
import enums.UniversityComparators;

public class ComparatorProvider {

    private ComparatorProvider() {

    }

    public static StudentComparator getStudentComparator(StudentComparators comparators) {
        return comparators.getComparator();
    }

    public static UniversityComparator getUniversityComparator(UniversityComparators comparators) {
        return comparators.getComparator();
    }
}
