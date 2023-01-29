import java.util.HashMap;
import java.util.List;
public class AllMonthReport {

    HashMap<Integer, StorageMonthReportInYaer> storageAllMonthReport = new HashMap<>();

    public void saveMonthReport(List<String> lines,int yearNumber, int numberMonth) {
        if (checkYear(yearNumber)) {
            MonthlyReport a = new MonthlyReport(lines, numberMonth);
            storageAllMonthReport.get(yearNumber).allMonthReportInYear.add(a);
        } else {
            StorageMonthReportInYaer b = new StorageMonthReportInYaer();
            MonthlyReport a = new MonthlyReport(lines, numberMonth);
            b.allMonthReportInYear.add(a);
            storageAllMonthReport.put(yearNumber, b);
        }
    }
    public boolean checkYear(int year) {
        if (storageAllMonthReport.containsKey(year)) {
            return true;
        }
        else{
            return false;
        }
    }
}