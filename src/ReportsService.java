public class ReportsService {
    ReadReport reader = new ReadReport();
    AllMonthReport allMonth = new AllMonthReport();
    YearlyReport allYear = new YearlyReport();
    public void readReportMonth(){
        reader.readAllMonthReport(allMonth);

    }
    public void readReportYear(){
        reader.readAllYearReport(allYear);
    }
    public void getReportMonth(int year){
        if (!allMonth.storageAllMonthReport.containsKey(year)) {
            System.out.println("Статистики за этот год нет. Проверьте файлы и повторите попытку.\n");
            return;
        }
            allMonth.storageAllMonthReport.get(year).getReport(year);
    }
    public void getReportYear(int year){
            allYear.getReportYear(year,allYear.yearReportExpenses.get(year),allYear.yearReportIncome.get(year));
    }
    public void verificationReport(int year){
        if(!allMonth.checkYear(year)){
            System.out.println("Нет месячных отчётов за данный год. Загрузите отчёты и повторите попытку.");
            return;
        }
        if(!allYear.getIsEmptyYearReport(year))
        {
            System.out.println("Нет загруженных годовых отчётов. Загрузите отчёт и повторите попытку.");
            return;
        }
        Verification.verificationMonth(year, allYear,allMonth.storageAllMonthReport.get(year));
    }
}
