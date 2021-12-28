package enums;

import comparator.*;

public enum UniversityComparators {
    FULL_NAME(new UniversityFullNameComparator()),
    SHORT_NAME(new UniversityShortNameComparator()),
    ID(new UniversityIdComparator()),
    MAIN_PROFILE(new UniversityMainProfileComparator()),
    FOUNDATION_YEAR(new UniversityYearOfFoundationComparator());

    private final UniversityComparator comparator;
    
    UniversityComparators (UniversityComparator comparator) {
        this.comparator = comparator;
    }

    public UniversityComparator getComparator() {
        return comparator;
    }
}
