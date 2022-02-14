package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlType(propOrder = {"profile", "avgScore"})
@XmlRootElement(name = "statisticEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {

    @XmlElement(name = "universityProfile")
    @SerializedName("study_profile")
    StudyProfile profile;

    @SerializedName("avg_score")
    @XmlElement(name = "avgScore")
    double avgScore;

    @SerializedName("profile_students_number")
    @XmlTransient
    int profileStudentNumber;

    @SerializedName("profile_universities_number")
    @XmlTransient
    int profileUniversityNumber;

    @XmlTransient
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

    public Statistics setUniversityNameList(String universityNameList) {
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
