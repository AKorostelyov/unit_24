import comparator.ComparatorProvider;
import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparators;
import enums.UniversityComparators;
import input.ExcelManager;

import java.io.IOException;

public class Main {
    private static final String PATH_TO_DATA = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) {
        try {
            ExcelManager.readStudents(PATH_TO_DATA);
            ExcelManager.readUniversities(PATH_TO_DATA);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StudentComparator studentComparator = ComparatorProvider.getStudentComparator(StudentComparators.AVG_SCORE);
        UniversityComparator universityComparator = ComparatorProvider.getUniversityComparator(UniversityComparators.FULL_NAME);

        ExcelManager.getStudentCollection().stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
        ExcelManager.getUniversitiesCollection().stream()
                .sorted(universityComparator)
                .forEach(System.out::println);
    }

}
