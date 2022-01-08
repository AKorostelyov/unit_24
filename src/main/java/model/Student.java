package model;

import com.google.gson.annotations.SerializedName;

public class Student {

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("university_id")
    private String universityId;

    @SerializedName("current_course")
    private int currentCourseNumber;

    @SerializedName("avg_score")
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
