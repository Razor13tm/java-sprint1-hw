import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        ArrayList<String> monthList = new ArrayList<>();
        monthList.add("январь");
        monthList.add("февраль");
        monthList.add("март");
        monthList.add("апрель");
        monthList.add("май");
        monthList.add("июнь");
        monthList.add("июль");
        monthList.add("август");
        monthList.add("сентябрь");
        monthList.add("октябрь");
        monthList.add("ноябрь");
        monthList.add("декабрь");

        while (true) {
            printMenu();
            String command = scanner.next();

            if (command.equals("1")) {
                System.out.println("Введите месяц");
                String month = scanner.next();
                if (monthList.contains(month.toLowerCase())) {
                    System.out.println("Введите номер дня");
                    int day = scanner.nextInt();
                    System.out.println("Введите количество шагов");
                    int step = scanner.nextInt();
                    stepTracker.saveData(month, day, step);
                    System.out.println("Данные сохранены!");
                } else {
                    System.out.println("Такого месяца не существует");
                }

            } else if (command.equals("2")) {
                System.out.println("Введите месяц");
                String month = scanner.next();
                if (monthList.contains(month.toLowerCase())) {
                    stepTracker.getStat(month);
                } else {
                    System.out.println("Такого месяца не существует");
                }
            } else if (command.equals("3")) {
                System.out.println("Введите желаемую цель");
                try {
                    int inputGoal = scanner.nextInt();
                    if (inputGoal >= 0) {
                        stepTracker.changeGoal(inputGoal);
                        System.out.println("Сохранено!");
                    } else {
                        System.out.println("Введите корректное значение");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Введите корректное значение");
                }
            } else if (command.equals("0")) {
                System.out.println("Пока!");
                break;
            } else {
                System.out.println("Такой команды не существует.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выйти из приложения.");
    }
}

