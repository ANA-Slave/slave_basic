import java.util.*;

public class RacingCar {
    private final List<Car> cars = new ArrayList<>();
    private final int numberOfAttempts;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String carName = scanner.nextLine();
            System.out.println("시도할 횟수는 몇회인가요?");
            int attempt = Integer.parseInt(scanner.nextLine());
            RacingCar race = new RacingCar(carName, attempt);
            System.out.println("실행 결과");
            race.startRace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public RacingCar(String carNames, int numberOfAttempts) {
        validateInput(carNames, numberOfAttempts);
        createCars(carNames.split(","));
        this.numberOfAttempts = numberOfAttempts;
    }

    public void startRace() {
        for (int i = 0; i < numberOfAttempts; i++) {
            moveCars();
            printRaceStatus();
        }
        printWinners();
    }

    private void validateInput(String carNames, int attempts) {
        if (carNames.isEmpty() || attempts <= 0) {
            throw new IllegalArgumentException("자동차 이름 또는 시도 횟수가 잘못됨.");
        }
        for (String name : carNames.split(",")) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 함.");
            }
        }
    }

    private void createCars(String[] names) {
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(new Random().nextInt(10));
        }
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = findWinners(maxPosition);
        System.out.println(String.join(",", winners) + "가 최종 우승했습니다.");
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getDistance());
        }
        return maxPosition;
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxPosition) {
                winner.add(car.getName());
            }
        }
        return winner;
    }
}