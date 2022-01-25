package output;

import model.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class XlsWriter {

    private XlsWriter() {

    }

    public static void writeXlsStatistics(List<Statistics> statistics, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Статистика");

        Font headerFont = new XSSFFont();

        headerFont.setBold(true);
        headerFont.setFontHeight((short) 18);

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);
        int rowCount = 0;
        Row header = sheet.createRow(rowCount++);

        Cell studyProfileHeader = header.createCell(0);
        studyProfileHeader.setCellValue("Профиль обучения");
        studyProfileHeader.setCellStyle(headerCellStyle);

        Cell studentsNumberHeader = header.createCell(1);
        studentsNumberHeader.setCellValue("Количество студентов по направлению");
        studentsNumberHeader.setCellStyle(headerCellStyle);

        Cell avgScoreHeader = header.createCell(2);
        avgScoreHeader.setCellValue("Средний балл студентов");
        avgScoreHeader.setCellStyle(headerCellStyle);

        Cell universitiesNumberHeader = header.createCell(3);
        universitiesNumberHeader.setCellValue("Количество университетов по направлению");
        universitiesNumberHeader.setCellStyle(headerCellStyle);

        Cell universitiesNames = header.createCell(4);
        universitiesNames.setCellValue("Названия университетов");
        universitiesNames.setCellStyle(headerCellStyle);

        for (Statistics statRow : statistics) {
            Row row = sheet.createRow(rowCount++);
            Cell studyProfile = row.createCell(0);
            studyProfile.setCellValue(statRow.getProfile().name());

            Cell studentsNum = row.createCell(1);
            studentsNum.setCellValue(statRow.getProfileStudentNumber());

            Cell avg = row.createCell(2);
            avg.setCellValue(statRow.getAvgScore());

            Cell universityNum = row.createCell(3);
            universityNum.setCellValue(statRow.getProfileUniversityNumber());

            Cell names = row.createCell(4);
            names.setCellValue(statRow.getUniversityNameList());
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            workbook.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
