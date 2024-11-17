import java.util.ArrayList;

public class Race {
    public static Auto determineWinner(ArrayList<Auto> cars) {
        Auto winner = cars.get(0);
        int theBiggestDistance = 0;
        for (Auto car : cars) {
            int distance = car.getCarSpeed() * 24;
            if (distance > theBiggestDistance) {
                theBiggestDistance = distance;
                winner = car;
            }
        }
        return winner;
    }
}
