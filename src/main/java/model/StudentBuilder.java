package model;

public class StudentBuilder {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private double avgExmScore;

    public StudentBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public StudentBuilder setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public StudentBuilder setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public StudentBuilder setAvgExmScore(double avgExmScore) {
        this.avgExmScore = avgExmScore;
        return this;
    }

    public Student createStudent() {
        return new Student(fullName, universityId, currentCourseNumber, avgExmScore);
    }
}