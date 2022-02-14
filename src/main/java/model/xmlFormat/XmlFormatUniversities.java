package model.xmlFormat;

import model.University;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "universitiesInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlFormatUniversities {
    @XmlElement(name = "universityEntry")
    List<University> universities;

    public XmlFormatUniversities(List<University> universities) {
        this.universities = universities;
    }

    public XmlFormatUniversities() {
    }
}
