import java.util.ArrayList;

public class Verification {
    static public void verificationMonth(int year, YearlyReport yearReport,StorageMonthReportInYaer monthReport){
        boolean variableCheck=false;
        if(!yearReport.getIsEmptyYearReport(yearReport,year))
        {
            System.out.println("Нет загруженных годовых отчётов. Загрузите отчёт и повторите попытку");
            variableCheck=true;
        }
        if(variableCheck){
            return;
        }

        ArrayList<Integer> monthMistake = new ArrayList<>();
        for(int i=0;i<yearReport.yearReportExpenses.get(year).size();i++){
                if (!(yearReport.yearReportExpenses.get(year).get(i).amount==monthReport.getSum(monthReport.allMonthReportInYear, i)[0])){
                    monthMistake.add(monthReport.allMonthReportInYear.get(i).numberMonth);
                    continue;
                }
                if (!(yearReport.yearReportIncome.get(year).get(i).amount==monthReport.getSum(monthReport.allMonthReportInYear, i)[1])){
                    monthMistake.add(monthReport.allMonthReportInYear.get(i).numberMonth);
                }

        }
        if(monthMistake.isEmpty()){
            System.out.println("Проверка прошла успешно, расхождений нет.");
        }
        else {
            System.out.println("Найдена ошибка, проверьте данные по месяцу: ");
            for (Integer a:monthMistake){
                System.out.print(a);
            }
        }
    }
}
