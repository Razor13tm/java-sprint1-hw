public class Converter {

    int oneStep = 75;
    int oneStepPerCalory = 50;

    public Double convertDistance(double step) {
        step = (step * oneStep)/100000;
        return step;
    }

    public Double convertKcal(double step) {
        step = (oneStepPerCalory * step) / 1000;
        return step;
    }
}
