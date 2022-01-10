import java.util.*;

public class StepTracker {
    Scanner scanner = new Scanner(System.in);
    int goal = 10000;
    HashMap<String, HashMap<Integer, Integer>> monthToData = new HashMap<>();
    List<String> monthList = new ArrayList<>(Arrays.asList("январь", "февраль", "март", "апрель", "май", "июнь",
            "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"));
    Converter converter = new Converter();

    public StepTracker() {
        for (String s : monthList) {
            monthToData.put(s, new HashMap<>());
        }
    }

    public void changeGoal() {
        int inputGoal;
        System.out.println("Введите желаемую цель");
        try {
            inputGoal = scanner.nextInt();
            if (inputGoal >= 0) {
                this.goal = inputGoal;
                System.out.println("Сохранено!");
            } else {
                System.out.println("Введите корректное значение");
            }
        }catch (InputMismatchException e){
            System.out.println("Введите корректное значение");
        }
    }

    public void handleStepsInput() {
        int dayNumber;
        int step;
        System.out.println("Введите месяц");
        String monthName = scanner.next();
        if (monthList.contains(monthName.toLowerCase())) {
            System.out.println("Введите номер дня");
            dayNumber = scanner.nextInt();
            System.out.println("Введите количество шагов");
            step = scanner.nextInt();
            if (dayNumber <= 30 && step >= 0) {
                HashMap<Integer, Integer> daysSteps = monthToData.get(monthName);
                daysSteps.put(dayNumber, step);
                monthToData.put(monthName, daysSteps);
            } else {
                System.out.println("Введите верные данные");
            }
            System.out.println("Данные сохранены!");
        } else {
            System.out.println("Такого месяца не существует");
        }
    }

    public void getStat() {
        System.out.println("Введите месяц");
        String month = scanner.next();
        if (monthList.contains(month.toLowerCase())) {
            double sum = 0;
            int maxValue = 0;
            double medSum = 0;
            double distanceKm = 0;
            int currentSeries = 0;
            int maxSeries = 0;

            HashMap<Integer, Integer> data = monthToData.get(month);
            for (Integer element : data.keySet()) {
                System.out.print(element + " день: " + data.get(element) + ", ");
            }
            System.out.println(" ");
            for (Integer element : data.values()) {
                sum = sum + element;
            }
            System.out.println("Общее количество шагов за месяц: " + sum);
            for (Integer numOfSteps : data.values()) {
                if (numOfSteps > maxValue) {
                    maxValue = numOfSteps;
                }
            }
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxValue);
            for (Integer numOfSteps : data.values()) {
                medSum = medSum + numOfSteps;
            }
            if (data.size() != 0) {
                medSum = medSum / data.size();
                System.out.println("Среднее количество шагов: " + medSum);
            } else {
                System.out.println("Среднее количество шагов: 0");
            }

            for (Integer element : data.values()) {
                distanceKm = element + distanceKm;
            }
            System.out.println("Пройденная дистанция: " + converter.convertDistance(distanceKm) + " км.");

            System.out.println("Количество сожжённых килокалорий: " + converter.convertKcal(sum));

            for (Integer element : data.values()) {
                if (element > goal) {
                    currentSeries ++;
                }else {
                    if(currentSeries > maxSeries) {
                        maxSeries = currentSeries;
                    }
                    currentSeries = 0;
                }
            }
            System.out.println("Максимальное количество подряд идущих дней, " +
                    "в течение которых количество шагов за день было выше целевого: " + maxSeries);
        } else {
            System.out.println("Такого месяца не существует");
        }
    }
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выйти из приложения.");
    }
}
