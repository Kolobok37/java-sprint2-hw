import java.util.ArrayList;

public class Verification {

    static public void verificationMonth(int year, YearlyReport yearReport,StorageMonthReportInYaer monthReport){
        ArrayList<YearReportByMonth> expensesForYear = yearReport.yearReportExpenses.get(year);
        ArrayList<Integer> monthMistake = new ArrayList<>();
        for(int i=0;i<expensesForYear.size();i++){
                if (!(expensesForYear.get(i).amount==monthReport.getSumExpenses(i))){
                    monthMistake.add(i+1);
                    continue;
                }
                if (!(expensesForYear.get(i).amount==monthReport.getSumIncome(i))){
                    monthMistake.add(i+1);
                }

        }
        if(monthMistake.isEmpty()){
            System.out.println("Проверка прошла успешно, расхождений нет.");
        }
        else {
            System.out.println("Найдена ошибка, проверьте данные по месяцу: ");
            for (Integer a:monthMistake){
                System.out.println(a);
            }
        }
    }

}
