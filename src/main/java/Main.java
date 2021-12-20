import input.ExcelManager;
import model.Student;
import model.University;

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
        for(Student student : ExcelManager.getStudentCollection()) {
            System.out.println(student);
        }
        for(University university:ExcelManager.getUniversitiesCollection()){
            System.out.println(university);
        }
    }

}
