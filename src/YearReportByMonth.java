public class YearReportByMonth {
    double amount;
    boolean isExpense;
    int month;
    YearReportByMonth(int monthNumber, double sum,boolean expense){
        amount=sum;
        isExpense=expense;
        month=monthNumber;
    }
}
