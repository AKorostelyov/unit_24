import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparators;
import enums.UniversityComparators;
import io.ExcelManager;
import io.JsonFormatter;
import io.XlsWriter;
import io.XmlFormatter;
import model.Statistics;
import model.Student;
import model.University;
import util.ComparatorProvider;
import util.StatisticUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final String PATH_TO_DATA = "src/main/resources/universityInfo.xlsx";
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    static {
        try {
            LOGGER.addHandler(new FileHandler("app.log", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ExcelManager.readStudents(PATH_TO_DATA);
        LOGGER.log(Level.INFO, "Students are read from " + PATH_TO_DATA);
        ExcelManager.readUniversities(PATH_TO_DATA);
        LOGGER.log(Level.INFO, "Universities are read from " + PATH_TO_DATA);

        StudentComparator studentComparator = ComparatorProvider
                .getStudentComparator(StudentComparators.AVG_SCORE);
        UniversityComparator universityComparator = ComparatorProvider
                .getUniversityComparator(UniversityComparators.FULL_NAME);

        List<Student> studentCollection = ExcelManager.getStudentCollection();
        studentCollection.sort(studentComparator);
        LOGGER.log(Level.SEVERE, "Student collection are sorted");


        List<University> universityCollection = ExcelManager.getUniversitiesCollection();
        universityCollection.sort(universityComparator);
        LOGGER.log(Level.SEVERE, "University collection are sorted");

        List<Statistics> statisticsCollection = StatisticUtil.getStatistics(studentCollection, universityCollection);

        JsonFormatter.convertToJson(studentCollection,universityCollection,statisticsCollection);

        XmlFormatter.convertToXml(studentCollection, universityCollection, statisticsCollection);
        

    }

}
