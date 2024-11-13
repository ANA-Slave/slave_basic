import carCompany.Car;
import putManager.OutputManager;

import java.util.List;

public class PlayRacing {

    private final List<Car> carList;
    private final int tryCount;
    private final OutputManager outputManager;
    private int winnerPosition;

    public PlayRacing(int tryCount, List<Car> carList) {
        this.carList = carList;
        this.tryCount = tryCount;
        outputManager = new OutputManager();
        winnerPosition = 0;
    }

    public void playRace() {
        for (int i = 1; i <= tryCount; i++) {
            carList.forEach(this::decisionMovement);
            outputManager.printPositionOfList(carList);
        }
        checkWinners();
        outputManager.printResult(winnerPosition, carList);
    }

    void decisionMovement(Car car) {
        if (shouldMove()) {
            car.setPosition(car.getPosition() + 1);
        }
    }

    boolean shouldMove() {
        return Math.random() * 10 >= 4.0;
    }

    void checkWinners() {
        for (Car car : carList) {
            winnerPosition = Math.max(car.getPosition(), winnerPosition);
        }
    }

    String whoIsWinner() {
        return outputManager.getOutput();
    }

}
