import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        while (true) {
            stepTracker.printMenu();
            String userInput = scanner.next();

            if (userInput.equals("1")) {
                stepTracker.handleStepsInput();
            } else if (userInput.equals("2")) {
                stepTracker.getStat();
            } else if (userInput.equals("3")) {
                stepTracker.changeGoal();
            } else if (userInput.equals("0")) {
                System.out.println("Пока!");
                break;
            } else {
                System.out.println("Такой команды не существует.");
            }
        }
    }
}

