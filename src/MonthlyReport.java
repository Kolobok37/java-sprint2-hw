import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    int numberMonth;
    ArrayList<TransactionMonth> monthExpenses = new ArrayList<>();
    ArrayList<TransactionMonth> monthIncome = new ArrayList<>();
    MonthlyReport(List<String> lines, int month) {
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            TransactionMonth a = new TransactionMonth(lineContents[0], Boolean.parseBoolean(lineContents[1]), Double.parseDouble(lineContents[2]), Double.parseDouble(lineContents[3]));
            if (Boolean.parseBoolean(lineContents[1])) {
                monthExpenses.add(a);
            } else {
                monthIncome.add(a);
            }
            numberMonth= month;
        }
    }


    public int getSumExpenses(){
        int sumExpenses=0;
        for(int i=0;i<monthExpenses.size();i++){
            sumExpenses+=monthExpenses.get(i).quantity*monthExpenses.get(i).sumOfOne;
        }
        return sumExpenses;
    }
    public int getSumIncome(){
        int sum=0;
        for(int i=0;i<monthIncome.size();i++){
            sum+=monthIncome.get(i).quantity*monthIncome.get(i).sumOfOne;
        }
        return sum;
    }

    public TransactionMonth getMaxExpenses(){
        double max=0;
        int j=0;
        for(int i=0;i<monthExpenses.size();i++){
            if(max<monthExpenses.get(i).getAmount()){
                max = monthExpenses.get(i).getAmount();
                j=i;
            }
        }
        return monthExpenses.get(j);
    }
    public TransactionMonth getMaxIncome(){
        double max=0;
        int j=0;
        for(int i=0;i<monthIncome.size();i++){
            if(max<monthIncome.get(i).getAmount()){
                max = monthIncome.get(i).getAmount();
                j=i;
            }
        }
        return monthIncome.get(j);
    }
}
