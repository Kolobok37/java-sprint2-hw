import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    int numberMonth;
    ArrayList<Transaction> monthExpenses = new ArrayList<>();
    ArrayList<Transaction> monthIncome = new ArrayList<>();
    MonthlyReport(List<String> lines, int month) {
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] lineContents = line.split(",");
            Transaction a = new Transaction(lineContents[0], Boolean.parseBoolean(lineContents[1]), Double.parseDouble(lineContents[2]), Double.parseDouble(lineContents[3]));
            if (Boolean.parseBoolean(lineContents[1])) {
                monthExpenses.add(a);
            } else {
                monthIncome.add(a);
            }
            numberMonth= month;
        }
    }


    public int getSum(ArrayList<Transaction> a){
        int sum=0;
        for(int i=0;i<a.size();i++){
            sum+=a.get(i).quantity*a.get(i).sumOfOne;
        }
        return sum;
    }

    public Transaction getMax(ArrayList<Transaction> expenses){
        double max=0;
        Transaction a = new Transaction();
        for(int i=0;i<expenses.size();i++){
            if(max<expenses.get(i).getAmount(expenses.get(i))){
                max = expenses.get(i).getAmount(expenses.get(i));
                a = expenses.get(i);
            }
        }
        return a;
    }
}
