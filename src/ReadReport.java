import java.io.File;
import java.io.IOException;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class ReadReport {

    static List<String> readFileContents(String path) {
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории.");
            return Collections.emptyList();
        }
    }

    public void readAllMonthReport(AllMonthReport allMonthReport) {
        File myFolder = new File("resources\\");
        String[] nameFiles = myFolder.list();
        if (nameFiles.length == 0) {
            System.out.println("Нет месячных отчётов для сканирования. Проверьте файлы и повторите попытку.");
            return;
        }
        int j = 0;
        for (int i = 0; i < nameFiles.length; i++) {
            if (nameFiles[i].startsWith("m.")) {
                List<String> lines = readFileContents("resources\\" + nameFiles[i]);
                Integer yearNumber = Integer.parseInt(nameFiles[i].substring(2, 6));
                allMonthReport.saveMonthReport(lines, yearNumber, getNumberMonth(nameFiles[i]));
                j++;
            }
            }
        System.out.println("Отчётов считано: " + j);

    }


    public void readAllYearReport(YearlyReport year) {
        File myFolder = new File("resources\\");
        String[] nameFiles = myFolder.list();
        if (nameFiles.length == 0) {
            System.out.println("Нет годовых отчётов для сканирования. Проверьте файлы и повторите попытку.");
            return;
        }
        int j = 0;
        for (int i = 0; i < nameFiles.length; i++) {

            if (nameFiles[i].startsWith("y.")) {
                List<String> lines = readFileContents("resources\\" + nameFiles[i]);
                Integer yearNumber = Integer.parseInt(nameFiles[i].substring(2, 6));
                year.saveReportYear(lines, yearNumber);
                j++;
            }
        }
        System.out.println("Считано годовых отчётов: " + j);
    }


    public int getNumberMonth(String path) {
        int month;
        if (Integer.parseInt(path.substring(6, 7))==0)
            month = Integer.parseInt(path.substring(7, 8));
        else {
            month = Integer.parseInt(path.substring(6, 8));
        }
        return month;
    }
}