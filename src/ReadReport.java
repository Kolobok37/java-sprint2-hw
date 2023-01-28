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


    public static MonthlyReport processingReportMont(String path) {
        MonthlyReport month = new MonthlyReport(getNumberMonth(path));
        List<String> lines = readFileContents("resources\\" + path);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            Transaction a = new Transaction(lineContents[0], Boolean.parseBoolean(lineContents[1]), Double.parseDouble(lineContents[2]), Double.parseDouble(lineContents[3]));
            if (Boolean.parseBoolean(lineContents[1])) {
                month.monthExpenses.add(a);
            } else {
                month.monthIncome.add(a);
            }
        }
        return month;
    }


    public void saveAllMonthReport(AllMonthReport allMonthReport) {
        File myFolder = new File("resources\\");
        String[] nameFiles = myFolder.list();
        if (nameFiles.length == 0) {
            System.out.println("Нет месячных отчётов для сканирования. Проверьте файлы и повторите попытку.");
            return;
        }
        int j = 0;
        for (int i = 0; i < nameFiles.length; i++) {
            if (nameFiles[i].startsWith("m.")) {
                Integer yearNumber = Integer.parseInt(nameFiles[i].substring(2, 6));
                int monthNumber;
                if (Integer.parseInt(nameFiles[i].substring(6, 7)) == 0) {
                    monthNumber = Integer.parseInt(nameFiles[i].substring(7, 8));
                } else {
                    monthNumber = Integer.parseInt(nameFiles[i].substring(6, 8));
                }
                if (allMonthReport.storageAllMonthReport.containsKey(yearNumber)) {
                    StorageMonthReportInYaer a = allMonthReport.storageAllMonthReport.get(yearNumber);
                    a.allMonthReportInYear.add(processingReportMont(nameFiles[i]));
                } else {
                    MonthlyReport a = processingReportMont(nameFiles[i]);
                    StorageMonthReportInYaer b = new StorageMonthReportInYaer();
                    b.allMonthReportInYear.add(a);
                    allMonthReport.storageAllMonthReport.put(yearNumber, b);
                }
                j++;
            }
        }
        System.out.println("Отчётов считано: " + j);

    }


    public void saveAllYearReport(YearlyReport year) {
        File myFolder = new File("resources\\");
        String[] nameFiles = myFolder.list();
        if (nameFiles.length == 0) {
            System.out.println("Нет годовых отчётов для сканирования. Проверьте файлы и повторите попытку.");
            return;
        }
        int j = 0;
        for (int i = 0; i < nameFiles.length; i++) {
            if (nameFiles[i].startsWith("y.")) {
                processingReportYear(nameFiles[i], year);
                j++;
            }
        }
        System.out.println("Считано годовых отчётов: " + j);
    }

    public static void processingReportYear(String path, YearlyReport year) {
        List<String> lines = readFileContents("resources\\" + path);
        Integer yearNumber = Integer.parseInt(path.substring(2, 6));
        ArrayList<YearReportByMonth> oneMonthExpense = new ArrayList<>();
        ArrayList<YearReportByMonth> oneMonthIncome = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            int monthNumber;
            if (lineContents[0].startsWith("0")) {
                monthNumber = Integer.parseInt(lineContents[0].substring(1));
            } else {
                monthNumber = Integer.parseInt(lineContents[0]);
            }
            YearReportByMonth a = new YearReportByMonth(monthNumber, Double.parseDouble(lineContents[1]), Boolean.parseBoolean(lineContents[2]));

            if (Boolean.parseBoolean(lineContents[2])) {
                oneMonthExpense.add(a);
            } else {
                oneMonthIncome.add(a);
            }
        }
        year.yearReportExpenses.put(yearNumber, oneMonthExpense);
        year.yearReportIncome.put(yearNumber, oneMonthIncome);
    }


    static public int getNumberMonth(String path) {
        int month;
        if (Integer.parseInt(path.substring(6, 7))==0)
            month = Integer.parseInt(path.substring(7, 8));
        else {
            month = Integer.parseInt(path.substring(6, 8));
        }
        return month;
    }
}