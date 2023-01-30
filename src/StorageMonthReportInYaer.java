import java.util.ArrayList;
import java.util.HashMap;

public class StorageMonthReportInYaer {
    ArrayList<MonthlyReport> allMonthReportInYear = new ArrayList<>();
    public double getSumExpenses(int numberMonth){
        double sumExpenses=allMonthReportInYear.get(numberMonth).getSum(allMonthReportInYear.get(numberMonth).monthExpenses);
        return sumExpenses;
    }

    public double getSumIncome(int numberMonth){
        double sumIncome=allMonthReportInYear.get(numberMonth).getSum(allMonthReportInYear.get(numberMonth).monthIncome);
        return sumIncome;
    }
    public void getReport(int year) {
        System.out.println("Месячные отчёты за " + year +" год:");
        Transaction b = new Transaction();
        for(int i=0;i<allMonthReportInYear.size();i++){
            System.out.println(allMonthReportInYear.get(i).numberMonth+ " месяц:");
            b=allMonthReportInYear.get(i).getMax(allMonthReportInYear.get(i).monthIncome);
            System.out.println("Самый прибыльний товар: "+b.itemName+" на сумму "+b.getAmount(b));
            b=allMonthReportInYear.get(i).getMax(allMonthReportInYear.get(i).monthExpenses);
            System.out.println("Cамые большие траты на: "+b.itemName+" на сумму "+b.getAmount(b));
        }
    }



}

