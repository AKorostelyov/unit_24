package model.xmlFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlFormat {
    @XmlElement(name = "studentsInfo")
    XmlFormatStudents students;
    @XmlElement(name = "universitiesInfo")
    XmlFormatUniversities universities;
    @XmlElement(name = "statisticalInfo")
    XmlFormatStatistics statistics;

    public XmlFormat(XmlFormatStudents students, XmlFormatUniversities universities, XmlFormatStatistics statistics) {
        this.students = students;
        this.universities = universities;
        this.statistics = statistics;
    }
    public XmlFormat(){}
}
