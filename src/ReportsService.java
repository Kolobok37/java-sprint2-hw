public class ReportsService {
    ReadReport reader = new ReadReport();
    AllMonthReport allMonth = new AllMonthReport();
    YearlyReport allYear = new YearlyReport();
    public void readReport(int command){
        if (command==1){
            reader.readAllMonthReport(allMonth);
        }
        if (command==2)
        {
            reader.readAllYearReport(allYear);
        }
    }
    public void getReport(int command,int year){
        if (!allMonth.storageAllMonthReport.containsKey(year)) {
            System.out.println("Статистики за этот год нет. Проверьте файлы и повторите попытку.\n");
            return;
        }
        if(command==4){
            allMonth.storageAllMonthReport.get(year).getReport(year,allMonth);
        }
        else{
            allYear.getReportYear(year,allYear.yearReportExpenses.get(year),allYear.yearReportIncome.get(year));
        }
    }
    public void verificationReport(int year){
        Verification.verificationMonth(year, allYear,allMonth.storageAllMonthReport.get(year));
    }
}
