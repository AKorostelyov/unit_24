import comparator.ComparatorProvider;
import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparators;
import enums.UniversityComparators;
import input.ExcelManager;
import json.JsonUtil;
import model.Student;
import model.University;

import java.io.IOException;
import java.util.List;

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

        List<Student> studentCollection = ExcelManager.getStudentCollection();
        studentCollection.sort(studentComparator);

        String jsonStudentsCollection = JsonUtil.serializeCollection(studentCollection);
        System.out.println(jsonStudentsCollection);
        System.out.println(JsonUtil.deserializeCollection(jsonStudentsCollection,Student.class));

        studentCollection.forEach(student -> {
            System.out.println(student);
            String json = JsonUtil.serialize(student);
            System.out.println(json);
            System.out.println(JsonUtil.deserialize(json,Student.class));
        });

        List<University> universityCollection = ExcelManager.getUniversitiesCollection();
        universityCollection.sort(universityComparator);

        String jsonUniversityCollection = JsonUtil.serializeCollection(universityCollection);
        System.out.println(jsonUniversityCollection);
        System.out.println(JsonUtil.deserializeCollection(jsonUniversityCollection,University.class));

        universityCollection.forEach(university -> {
            System.out.println(university);
            String json = JsonUtil.serialize(university);
            System.out.println(json);
            System.out.println(JsonUtil.deserialize(json,University.class));
        });

    }

}
