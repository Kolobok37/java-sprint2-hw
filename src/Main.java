import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ReadReport reader = new ReadReport();
        ReportsService service= new ReportsService();
        //Verification check = new Verification();
        printMenu(scanner, service);
    }


    public static void printMenu(Scanner scanner, ReportsService service) {
        while (true) {
            System.out.println("Выберите действие:\n1. Считать все месячные отчёты\n2. Считать годовой отчёт\n3. Сверить отчёты\n4. Вывести информацию о всех месячных отчётах\n5. Вывести информацию о годовом отчёте\n0. Выйти");
            int command = scanner.nextInt();
            if (command == 1) {
                service.readReport(1);
                       }
             else if (command == 2) {
                service.readReport(2);
            } else if (command == 3) {
                System.out.println("За какой год провести сверку?");
                int year=scanner.nextInt();
                service.verificationReport(year);
            }
            else if (command == 4) {
                System.out.println("За какой год вывести статистику?");
                int year = scanner.nextInt();
                service.getReport(command,year);
            }
            else if (command == 5) {
                System.out.println("За какой год вывести статистику?");//Метод класса OUT который выводит мес отчёт
                int year = scanner.nextInt();
                service.getReport(command,year);;
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

