public class Transaction {
    String itemName;
    boolean isExpense;
    double quantity;
    double sumOfOne;


    Transaction(String name,boolean expense,double quan,double price)
    {
        itemName = name;
        isExpense = expense;
        quantity = quan;
        sumOfOne = price;
    }
    Transaction(){}
    double getAmount(Transaction a){
        double sum=0;
        sum+= a.quantity*a.sumOfOne;
        return sum;
    }
}