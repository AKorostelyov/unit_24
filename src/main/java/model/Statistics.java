package model;

import enums.StudyProfile;

import java.util.List;

public class Statistics {
    StudyProfile profile;
    double avgScore;
    int profileStudentNumber;
    int profileUniversityNumber;
    String universityNameList;

    public Statistics() {
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public Statistics setAvgScore(double avgScore) {
        this.avgScore = avgScore;
        return this;
    }

    public int getProfileStudentNumber() {
        return profileStudentNumber;
    }

    public Statistics setProfileStudentNumber(int profileStudentNumber) {
        this.profileStudentNumber = profileStudentNumber;
        return this;
    }

    public int getProfileUniversityNumber() {
        return profileUniversityNumber;
    }

    public Statistics setProfileUniversityNumber(int profileUniversityNumber) {
        this.profileUniversityNumber = profileUniversityNumber;
        return this;
    }

    public String getUniversityNameList() {
        return universityNameList;
    }

    public Statistics setUniversityNameList(String  universityNameList) {
        this.universityNameList = universityNameList;
        return this;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "profile=" + profile +
                ", avgScore=" + avgScore +
                ", profileStudentNumber=" + profileStudentNumber +
                ", profileUniversityNumber=" + profileUniversityNumber +
                ", universityNameList='" + universityNameList + '\'' +
                '}';
    }
}
