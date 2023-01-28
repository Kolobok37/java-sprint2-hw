import java.util.ArrayList;

public class MonthlyReport {
    MonthlyReport(int number){
        numberMonth=number;
    }
    int numberMonth;
    ArrayList<Transaction> monthExpenses = new ArrayList<>();
    ArrayList<Transaction> monthIncome = new ArrayList<>();
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
