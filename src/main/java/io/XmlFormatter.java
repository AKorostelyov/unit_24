package io;

import model.*;
import model.xmlFormat.XmlFormat;
import model.xmlFormat.XmlFormatStatistics;
import model.xmlFormat.XmlFormatStudents;
import model.xmlFormat.XmlFormatUniversities;
import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlFormatter {
    private static final Logger LOGGER = Logger.getLogger(XmlFormatter.class.getSimpleName());

    public static void convertToXml(List<Student> students, List<University> universities, List<Statistics> statistics) {
        try{
            JAXBContext contextObj = JAXBContext.newInstance(XmlFormat.class);

            Marshaller marshallerObj = contextObj.createMarshaller();
            marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            XmlFormat xmlFormat = new XmlFormat(new XmlFormatStudents(students), new XmlFormatUniversities(universities), new XmlFormatStatistics(statistics));
            String fileName = "data_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".xml";
            marshallerObj.marshal(xmlFormat, FileUtils.openOutputStream(new File("xml/"+fileName)));
            LOGGER.log(Level.INFO, "File " + fileName + " successfully recorded");

        } catch (JAXBException | IOException e) {
            LOGGER.log(Level.WARNING, "Something went wrong.\n" + e.getMessage());
        }

    }
}
