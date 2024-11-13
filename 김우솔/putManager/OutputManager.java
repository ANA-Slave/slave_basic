package putManager;

import carCompany.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputManager {

    private final StringBuffer output;

    public OutputManager() {
        output = new StringBuffer();
        output.append("실행결과").append("\n");
    }

    public void printPositionOfList(List<Car> carList) {
        for (Car car : carList) {
            output.append(car.getCarName());
            output.append(":");
            output.append("-".repeat(car.getPosition()));
            output.append("\n");
        }
        output.append("\n");
    }

    public void printResult(int winnerPosition, List<Car> carList) {
        String result = carList.stream()
                .filter(car -> winnerPosition == car.getPosition())
                .map(Car::getCarName)
                .collect(Collectors.joining(","));
        output.append(result).append("가 최종 우승했습니다.");
    }

    public String getOutput() {
        return output.toString();
    }

}
