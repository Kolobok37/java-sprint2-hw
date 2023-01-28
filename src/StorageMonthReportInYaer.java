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
    public void getReport(int year, ArrayList<MonthlyReport> a,AllMonthReport allMonth) {
        System.out.println("Месячные отчёты за " + year +" год:");
        Transaction b = new Transaction();
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i).numberMonth+ " месяц:");
            b=a.get(i).getMax(a.get(i).monthIncome);
            System.out.println("Самый прибыльний товар: "+b.itemName+" на сумму "+b.getAmount(b));
            b=a.get(i).getMax(a.get(i).monthExpenses);
            System.out.println("Cамые большие траты на: "+b.itemName+" на сумму "+b.getAmount(b));
        }
    }

}

