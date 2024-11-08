package view;

import exception.ChanceException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력해주세요(이름은 쉼표(,)를 기준으로 구분).");
        String input_cars = scanner.nextLine();

        List<String> car_names = Arrays.asList(input_cars.split(","));

        return car_names;
    }

    public static int getChance() {
        System.out.println("시도할 횟수는 몇회인가요?");
        String chance = scanner.nextLine();

        ChanceException.validate(chance);
        return Integer.parseInt(chance);
    }
}
