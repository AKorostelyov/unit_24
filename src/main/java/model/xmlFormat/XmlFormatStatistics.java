package model.xmlFormat;

import model.Statistics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "statisticsInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlFormatStatistics {
    @XmlElement(name = "statisticsEntry")
    List<Statistics> statistics;

    public XmlFormatStatistics(List<Statistics> statistics) {
        this.statistics = statistics ;
    }

    public XmlFormatStatistics() {
    }

}
