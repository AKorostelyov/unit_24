package model.xmlFormat;

import model.Student;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "studentsInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlFormatStudents {
    @XmlElement(name = "studentsEntry")
    List<Student> students;

    public XmlFormatStudents(List<Student> students) {
        this.students = students;
    }

    public XmlFormatStudents() {
    }

}
