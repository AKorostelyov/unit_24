package input;

import enums.StudyProfile;
import model.Student;
import model.StudentBuilder;
import model.University;
import model.UniversityBuilder;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelManager {
    private static List<Student> studentCollection = new ArrayList<>();
    private static List<University> universitiesCollection = new ArrayList<>();

    private ExcelManager() {
    }

    private static Sheet readSheet(String filePath, int sheetIndex) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        return workbook.getSheetAt(sheetIndex);
    }

    public static void readStudents(String filePath) throws IOException {
        Sheet studentsData = readSheet(filePath, 0);
        if (studentCollection.isEmpty())
            studentCollection = new ArrayList<Student>();

        for (Row row : studentsData) {
            if (row.getRowNum() != 0)
                studentCollection.add(
                        new StudentBuilder()
                                .setUniversityId(row.getCell(0).getStringCellValue())
                                .setFullName(row.getCell(1).getStringCellValue())
                                .setCurrentCourseNumber((int)Math.round(row.getCell(2).getNumericCellValue()))
                                .setAvgExmScore(row.getCell(3).getNumericCellValue())
                                .createStudent()
                );
        }


    }

    public static void readUniversities(String filePath) throws IOException {
        Sheet universitiesData = readSheet(filePath, 1);

        if (universitiesCollection.isEmpty())
            universitiesCollection = new ArrayList<>();

        for (Row row : universitiesData) {
            if (row.getRowNum() != 0)
                universitiesCollection.add(new UniversityBuilder()
                        .setId(row.getCell(0).getStringCellValue())
                        .setFullName(row.getCell(1).getStringCellValue())
                        .setShortName(row.getCell(2).getStringCellValue())
                        .setYearOfFoundation((int)Math.round(row.getCell(3).getNumericCellValue()))
                        .setMainProfile(StudyProfile.valueOf(row.getCell(4).getStringCellValue()))
                        .createUniversity());
        }
    }

    public static List<Student> getStudentCollection() {
        return studentCollection;
    }

    public static List<University> getUniversitiesCollection() {
        return universitiesCollection;
    }
}
