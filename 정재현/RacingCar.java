import java.util.*;

class Car {
    private String carName;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
        }
        this.carName = name;
        this.position = 0;
    }

    public String getName() {
        return this.carName;
    }

    public int getPosition() {
        return this.position;
    }

    public void move() {
        if ((int) (Math.random() * 10) >= 4) {
            position++;
        }
    }

    public void printResult() {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}

public class RacingCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = sc.nextLine().split(",");
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int n = sc.nextInt();
        if (n <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\n실행 결과");
            moveCars(cars);
            printCarPosition(cars);
            System.out.println();
        }

        printWinners(cars);
    }

    public static void moveCars(Car[] cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    public static void printCarPosition(Car[] cars) {
        for (Car car : cars) {
            car.printResult();
        }
    }

    public static void printWinners(Car[] cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winnerNames = filterWinners(cars, maxPosition);
        displayWinners(winnerNames);
    }

    public static List<String> filterWinners(Car[] cars, int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinner(car, maxPosition, winners);
        }
        return winners;
    }

    public static void addWinner(Car car, int maxPosition, List<String> winners) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    public static void displayWinners(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + "가 최종 우승했습니다.");
    }

    public static int findMaxPosition(Car[] cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = getNewMaxPosition(car, maxPosition);
        }
        return maxPosition;
    }

    public static int getNewMaxPosition(Car car, int currentMax) {
        return car.getPosition() > currentMax ? car.getPosition() : currentMax;
    }
}