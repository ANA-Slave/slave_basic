import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Program {
    public static void main(String[] args) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        var input = new BufferedReader(new InputStreamReader(System.in));

        var cars = Arrays.stream(input.readLine().split(",")).map(RacingCar::new).toList();

        System.out.println("시도할 회수는 몇 회인가요?");
        var line = input.readLine();
        if (!line.chars().allMatch(Character::isDigit) || line.isBlank() || line.startsWith("-") || line.length() > 9) {
            throw new IllegalArgumentException("올바른 숫자를 입력해주세요.");
        }
        var tries = Integer.parseInt(line);

        System.out.println("실행 결과");
        for (int i = 0; i < tries; i++) {
            cars.forEach(RacingCar::move);
            cars.forEach(System.out::println);
            System.out.println();
        }

        var maxPosition = cars.stream().reduce(0, (max, car) -> Math.max(max, car.getPosition()), Math::max);
        var winners = cars.stream().filter(car -> car.getPosition() == maxPosition).map(RacingCar::getName).toList();
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
