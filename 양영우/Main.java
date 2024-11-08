import java.util.List;
import java.util.stream.Collectors;
import view.Input;


public class Main {

    public static void main(String[] args) {

        List<String> carNames = Input.getCarNames();
        int chance = Input.getChance();

        CarService carService = new CarService(carNames);

        System.out.println("실행결과");

        for (int i = 0; i < chance; i++) {
            carService.moveCars();
            carService.getCars().forEach(car -> System.out.println(car));
            System.out.println();
        }


        List<Car> winners = carService.getWinners();
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");

    }

}

