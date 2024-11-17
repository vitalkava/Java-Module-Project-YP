import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("""
                Добро пожаловать на Гонку «24 часа Ле-Мана»!
                Пожалуйста, введите название и скорость для каждого автомобиля, участвующего в Гонке.
                Программа вычислит и выведет победителя гонки.""");

        ArrayList<Auto> cars = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название автомобиля № " + i);
            String carName = getName();
            System.out.println("Введите скорость автомобиля № " + i);
            int carSpeed = getSpeed();

            cars.add(new Auto(carName, carSpeed));
        }

        Auto winner = Race.determineWinner(cars);
        System.out.printf("Победителем Гонки «24 часа Ле-Мана» становится автомобиль марки \"%s\".", winner.getName());

    }

    public static String getName() {
        Scanner scanName = new Scanner(System.in);
        boolean validInput = false;
        String name = "";
        while (!validInput) {
            name = scanName.nextLine();
            if (name.isEmpty()) {
                System.out.println("Ошибка: название автомобиля не может быть пустым, пожалуйста, введите корректное название.");
            } else {
                validInput = true;
            }
        }
        return name;
    }


    public static int getSpeed() {
        Scanner scanCar = new Scanner(System.in);
        int speed = 0;
        boolean validInput = false;


        while (!validInput) {
            try {
                speed = Integer.parseInt(scanCar.nextLine());
                if (speed <= 250 && speed >= 0) {
                    validInput = true;
                } else if (speed < 0) {
                    System.out.println("Ошибка: cкорость автомобиля не может принимать отрицательное значение, введите корректное число.");
                } else {
                    System.out.println("Ошибка: скорость автомобиля по условиям Гонки «24 часа Ле-Мана» не может превышать 250 км/ч, введите корректное число.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено некорректное значение. Пожалуйста, введите целое число от 0 до 250.");
            }
        }
        return speed;
    }
}