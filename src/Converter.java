public class Converter {

    int oneStep = 75;
    int oneStepCalory = 50;

    public Double convertDistance(double step) {
        step = step * oneStep;
        return step;
    }

    public int convertKcal(int stepKl) {
        stepKl = (oneStepCalory * stepKl) / 1000;
        return stepKl;
    }
}
