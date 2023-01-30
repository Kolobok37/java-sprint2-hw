public class TransactionMonth {
    String itemName;
    boolean isExpense;
    double quantity;
    double sumOfOne;


    TransactionMonth(String name,boolean expense,double quan,double price)
    {
        itemName = name;
        isExpense = expense;
        quantity = quan;
        sumOfOne = price;
    }
    double getAmount(){
        double sum=0;
        sum+= quantity*sumOfOne;
        return sum;
    }
}