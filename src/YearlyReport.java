import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    HashMap<Integer, ArrayList<YearReportByMonth>> yearReportExpenses = new HashMap<>();
    HashMap<Integer, ArrayList<YearReportByMonth>> yearReportIncome = new HashMap<>();

    public void getReportYear(int year,ArrayList<YearReportByMonth> allExpenses, ArrayList<YearReportByMonth> allIncome,YearlyReport allYear){
        if(!getIsEmptyYearReport(allYear,year)){
            System.out.println("Данные за год не найдены. Проверьте файлы и повторите попытку.\n");
            return;
        }
        double averageExpenses = 0;
        double averageIncome = 0;
        for(int i=0;i<allExpenses.size();i++){
            System.out.println("Прибыль за "+ allExpenses.get(i).month+" месяц =" +(allIncome.get(i).amount-allExpenses.get(i).amount));
            averageIncome+=allIncome.get(i).amount;
            averageExpenses+=allExpenses.get(i).amount;
        }
        System.out.println("Средний расход за меяц: "+ averageExpenses/allExpenses.size());
        System.out.println("Средний доход за меяц: "+ averageIncome/allExpenses.size());
    }

    public boolean getIsEmptyYearReport(YearlyReport yearlyReport, int year) {
        if(yearlyReport.yearReportExpenses.containsKey(year)){
            return true;
        }
        else {
            return false;
        }
    }
}