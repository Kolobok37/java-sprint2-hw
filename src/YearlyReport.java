import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class YearlyReport {
    HashMap<Integer, ArrayList<YearReportByMonth>> yearReportExpenses = new HashMap<>();
    HashMap<Integer, ArrayList<YearReportByMonth>> yearReportIncome = new HashMap<>();

    public void getReportYear(int year,ArrayList<YearReportByMonth> allExpenses, ArrayList<YearReportByMonth> allIncome){
        if(!getIsEmptyYearReport(year)){
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
        System.out.printf("Средний расход за меcяц: %.2f\n", averageExpenses/allExpenses.size());
        System.out.printf("Средний доход за меcяц: %.2f\n", averageIncome/allExpenses.size());
    }

    public boolean getIsEmptyYearReport(int year) {
        if(yearReportExpenses.containsKey(year)){
            return true;
        }
        else {
            return false;
        }
    }

    public void saveReportYear(List<String> lines, int year) {


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
        yearReportExpenses.put(year, oneMonthExpense);
        yearReportIncome.put(year, oneMonthIncome);
    }
}