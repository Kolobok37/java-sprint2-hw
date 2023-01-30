import java.util.ArrayList;
import java.util.HashMap;

public class StorageMonthReportInYaer {
    ArrayList<MonthlyReport> allMonthReportInYear = new ArrayList<>();
    public double getSumExpenses(int numberMonth){
        double sumExpenses=allMonthReportInYear.get(numberMonth).getSumExpenses();
        return sumExpenses;
    }

    public double getSumIncome(int numberMonth){
        double sumIncome=allMonthReportInYear.get(numberMonth).getSumExpenses();
        return sumIncome;
    }
    public void getReport() {
        for(int i=0;i<allMonthReportInYear.size();i++){
            System.out.println(allMonthReportInYear.get(i).numberMonth+ " месяц:");
            TransactionMonth b=allMonthReportInYear.get(i).getMaxIncome();
            System.out.println("Самый прибыльний товар: "+b.itemName+" на сумму "+b.getAmount());
            b=allMonthReportInYear.get(i).getMaxExpenses();
            System.out.println("Cамые большие траты на: "+b.itemName+" на сумму "+b.getAmount());
        }
    }



}

