public class WorkArray<T extends Number> {
    T[] arrNums;

    WorkArray(T[] numP) {
        arrNums = numP;
    }

    double sum() {
        double doubleWork = 0;
        for (T num : arrNums) {
            doubleWork += num.doubleValue();
        }
        return doubleWork;
    }
}
