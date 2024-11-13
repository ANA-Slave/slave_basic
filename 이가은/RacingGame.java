import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<Car> cars = new ArrayList<>();
    private final int numberOfAttempts;
    private final RaceView view;

    public RacingGame(String carNames, int numberOfAttempts, RaceView view) {
        validateInput(carNames, numberOfAttempts);
        createCars(carNames.split(","));
        this.numberOfAttempts = numberOfAttempts;
        this.view = view;
    }

    public void startRace() {
        for (int i = 0; i < numberOfAttempts; i++) {
            moveCars();
            view.printRaceStatus(cars);
        }
        view.printWinners(findWinners());
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
        Random random = new Random();
        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
    }

    private List<String> findWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getDistance).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}