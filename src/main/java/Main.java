import enums.StudyProfile;
import model.Student;
import model.StudentBuilder;
import model.University;
import model.UniversityBuilder;

public class Main {
public static void main(String[] args) {
    Student student = new StudentBuilder()
            .setFullName("Bawman Yosuf")
            .setAvgExmScore(3.2)
            .setUniversityId("msu")
            .setCurrentCourseNumber(2)
            .createStudent();
    University university = new UniversityBuilder()
            .setMainProfile(StudyProfile.APPLIED_MATH)
            .setId("msu").setShortName("MSU")
            .setFullName("Moscow State University")
            .setYearOfFoundation(1755)
            .createUniversity();
    System.out.println(student);
    System.out.println(university);
}
}
