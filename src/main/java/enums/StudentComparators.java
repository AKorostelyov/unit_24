package enums;

import comparator.*;
import org.apache.poi.ss.formula.functions.T;

public enum StudentComparators {
    AVG_SCORE(new StudentAvgExamScoreComparator()),
    UNIVERSITY_ID(new StudentUniversityIdComparator()),
    COURSE_NUMBER(new StudentCourseNumberComparator()),
    FULL_NAME(new StudentFullNameComparator())
    ;

    private final StudentComparator comparator;

    StudentComparators(StudentComparator comparator) {
        this.comparator = comparator;
    }

    public StudentComparator getComparator() {
        return comparator;
    }
}
