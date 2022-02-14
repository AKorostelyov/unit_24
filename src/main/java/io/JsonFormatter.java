package io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.io.FileUtils;
import util.JsonUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonFormatter {

    private static final Logger LOGGER = Logger.getLogger(JsonFormatter.class.getSimpleName());
    public static void convertToJson(List<Student> students, List<University> universities, List<Statistics> statistics){
        String fileName = "data_" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date()) + ".json";
        try {
            FileOutputStream outputStream = FileUtils.openOutputStream(new File("json/"+fileName));
            outputStream.write(getJsonString(students, universities, statistics).getBytes(StandardCharsets.UTF_8));
            LOGGER.log(Level.INFO, "File " + fileName + " successfully recorded");
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "Something went wrong.\n" + e.getMessage());
        }
    }

    private static String getJsonString(List<Student> students, List<University> universities, List<Statistics> statistics) {
        String result = "";
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonObject studentsJson = gson.fromJson(JsonUtil.serializeCollection(students), JsonObject.class);
        JsonObject universitiesJson = gson.fromJson(JsonUtil.serializeCollection(universities), JsonObject.class);
        JsonObject statisticsJson = gson.fromJson(JsonUtil.serializeCollection(statistics), JsonObject.class);
        JsonObject common = new JsonObject();
        common.add("students_info", studentsJson);
        common.add("universities_info", universitiesJson);
        common.add("statistics_info", statisticsJson);
        JsonObject fullInfo =new JsonObject();
        fullInfo.add("root", common);
        result = fullInfo.toString();
        return result;
    }
}
