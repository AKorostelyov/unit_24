package model;

public class Student {
    private String fullName;
    private String universityId;
    private int currentCourseNumber;
    private double avgExmScore;

    public Student(String fullName, String universityId, int currentCourseNumber, double avgExmScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExmScore = avgExmScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public double getAvgExmScore() {
        return avgExmScore;
    }

    public void setAvgExmScore(double avgExmScore) {
        this.avgExmScore = avgExmScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName='" + fullName + '\'' +
                ", universityId='" + universityId + '\'' +
                ", currentCourseNumber=" + currentCourseNumber +
                ", avgExmScore=" + avgExmScore +
                '}';
    }
}
