package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticUtil {

    private StatisticUtil(){}

    public static List<Statistics> getStatistics(List<Student> students, List<University> universities) {
        List<Statistics> statistics = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream().map(University::getMainProfile).collect(Collectors.toSet());

        profiles.forEach(
                profile -> {
                    Statistics statRow = new Statistics();
                    statRow.setProfile(profile);
                    statistics.add(statRow);

                    List<String> profileUniversityIds = universities.stream()
                            .filter(university -> university.getMainProfile().equals(profile))
                            .map(University::getId)
                            .collect(Collectors.toList());
                    statRow.setProfileUniversityNumber(profileUniversityIds.size());

                    statRow.setUniversityNameList("");

                    universities.stream()
                            .filter(university -> profileUniversityIds.contains(university.getId()))
                            .map(University::getFullName)
                            .forEach(fullName -> statRow.setUniversityNameList(
                                    statRow.getUniversityNameList() + fullName + "; "));

                    List<Student> profileStudents = students.stream()
                            .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                            .collect(Collectors.toList());

                    statRow.setProfileStudentNumber(profileStudents.size());

                    OptionalDouble avgExamScore = profileStudents.stream()
                            .mapToDouble(Student::getAvgExmScore)
                            .average();

                    statRow.setAvgScore(0);
                    avgExamScore.ifPresent(value -> statRow.setAvgScore(
                            BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
                }
        );
        return statistics;
    }
}
