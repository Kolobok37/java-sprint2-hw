import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReadReport rader = new ReadReport();
        AllMonthReport allMonth = new AllMonthReport();
        YearlyReport allYear = new YearlyReport();
        Verification check = new Verification();
        printMenu(scanner, rader,allMonth,allYear,check);
    }


    public static void printMenu(Scanner scanner, ReadReport reader, AllMonthReport allMonth,YearlyReport allYear,Verification check) {
        while (true) {
            System.out.println("Выберите действие:\n1. Считать все месячные отчёты\n2. Считать годовой отчёт\n3. Сверить отчёты\n4. Вывести информацию о всех месячных отчётах\n5. Вывести информацию о годовом отчёте\n0. Выйти");
            int command = scanner.nextInt();
            if (command == 1) {
                reader.saveAllMonthReport(allMonth);//Метод класса IN который считывает данные
                       }
             else if (command == 2) {
                //Метод класса IN который считывает данные за год
                reader.saveAllYearReport(allYear);
                    //month.readYearReport(yearReport,year);
            } else if (command == 3) {
                System.out.println("За какой год провести сверку?");
                int year=scanner.nextInt();
                if (!allMonth.storageAllMonthReport.containsKey(year)) {
                    System.out.println("Cтатистики за этот год нет. Проверьте файлы и повторите попытку.");
                    continue;
                }
                check.verificationMonth(year,allYear,allMonth.storageAllMonthReport.get(year));
            }
            else if (command == 4) {
                System.out.println("За какой год вывести статистику?");//Метод класса OUT который выводит мес отчёт
                int year = scanner.nextInt();
                if (!allMonth.storageAllMonthReport.containsKey(year)) {
                    System.out.println("Cтатистики за этот год нет. Проверьте файлы и повторите попытку.\n");
                    continue;
                }
                allMonth.storageAllMonthReport.get(year).getReport(year, allMonth.storageAllMonthReport.get(year).allMonthReportInYear,allMonth);
            }
            else if (command == 5) {
                System.out.println("За какой год вывести статистику?");//Метод класса OUT который выводит мес отчёт
                int year = scanner.nextInt();
                allYear.getReportYear(year,allYear.yearReportExpenses.get(year),allYear.yearReportIncome.get(year),allYear);
            } else if (command == 0) {
                System.out.println("Хорошего дня!");
                break;
            } else {
                System.out.println("Такой команды нет, повторите ввод.\n");
            }
            System.out.println();
        }
    }
}

