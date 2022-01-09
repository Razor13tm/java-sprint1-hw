import java.util.ArrayList;
import java.util.HashMap;

public class StepTracker {
    int goal = 10000;
    HashMap<String, HashMap<Integer, Integer>> monthToData = new HashMap<>();
    Converter converter = new Converter();

    public StepTracker() {
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

        for (String s : monthList) {
            monthToData.put(s, new HashMap<>());
        }
    }

    public void changeGoal(int goal) {
        this.goal = goal;
    }

    public void saveData(String month, int day, int steps) {

        if (day <= 30 && steps >= 0) {
            HashMap<Integer, Integer> daysSteps = monthToData.get(month);
            daysSteps.put(day, steps);
            monthToData.put(month, daysSteps);
        } else {
            System.out.println("Введите верные данные");
        }
    }

    public void getStat(String month) {
        int sum = 0;
        int maxValue = 0;
        int medSum = 0;
        int counter = 0;
        double distanceKm = 0;
        int counterBest = 0;

        HashMap<Integer, Integer> data = monthToData.get(month);
        for (Integer s : data.keySet()) {
            System.out.print(s + " день: " + data.get(s) + ", ");
        }
        System.out.println(" ");
        for (Integer summ : data.values()) {
            sum = sum + summ;
        }
        System.out.println("Общее количество шагов за месяц: " + sum);
        for (Integer max : data.values()) {
            if (max > maxValue) {
                maxValue = max;
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxValue);
        for (Integer med : data.values()) {
            medSum = medSum + med;
            counter++;
        }
        if (counter != 0) {
            medSum = medSum / counter;
            System.out.println("Среднее количество шагов: " + medSum);
        } else {
            System.out.println("Среднее количество шагов: 0");
        }

        for (Integer sumDis : data.values()) {
            distanceKm = sumDis + distanceKm;
        }
        System.out.println("Пройденная дистанция: " + (converter.convertDistance(distanceKm)) / 100000 + " км.");

        System.out.println("Количество сожжённых килокалорий: " + converter.convertKcal(sum));
        for (Integer max : data.values()) {
            if (max > goal) {
                counterBest++;
            }
        }
        System.out.println("Максимальное количество подряд идущих дней, " +
                "в течение которых количество шагов за день было выше целевого: " + counterBest);
    }
}
