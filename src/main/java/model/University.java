package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "universityEntry")
@XmlType(propOrder = {"id", "fullName", "mainProfile"})
@XmlAccessorType(XmlAccessType.FIELD)
public class University {

    private String id;

    @SerializedName("full_name")
    private String fullName;

    @XmlTransient
    @SerializedName("short_name")
    private String shortName;

    @XmlTransient
    @SerializedName("foundation_year")
    private int yearOfFoundation;

    @SerializedName("main_profile")
    private StudyProfile mainProfile;

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public University() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}