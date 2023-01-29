import java.util.ArrayList;
import java.util.HashMap;

public class StorageMonthReportInYaer {
    ArrayList<MonthlyReport> allMonthReportInYear = new ArrayList<>();
    public double[] getSum( ArrayList<MonthlyReport> b, int i){
            double sumExpenses =b.get(i).getSum(b.get(i).monthExpenses);
            double sumIncome=b.get(i).getSum(b.get(i).monthIncome);
        double[] sum=new double[]{sumExpenses,sumIncome};
        return sum;
    }
    public void getReport(int year,AllMonthReport allMonth) {
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

