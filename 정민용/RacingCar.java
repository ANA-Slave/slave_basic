package racing_car;

import java.util.*;

class Car {
    private String car_name;
    private int pos;

    public Car(String name) {
        car_name = name;
    }

    public String GetName() {
        return car_name;
    }

    public int GetPos() {
        return pos;
    }

    public void Move() {
        int prob = (int) (Math.random() * 10);

        if (prob >= 4) {
            pos += 1;
        }
    }

    public void PrintPos() {
        System.out.print(car_name + " : ");
        for (int i=0; i<pos; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public boolean IsWinner(int winner_pos) {
        if (pos < winner_pos) return false;
        return true;
    }

    public boolean IsHigherPos(int winner_pos) {
        if (pos > winner_pos) return true;
        return false;
    }
}

public class RacingCar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input_data = sc.nextLine();
        String[] data = input_data.split(",");

        Car[] car_list = new Car[data.length];
        for (int i=0; i<data.length; i++) {
            car_list[i] = new Car(data[i]);
        }

        System.out.println("시도할 횟수는 몇회인가요?");
        int trial;
        try {
            trial = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.close();
            throw new IllegalArgumentException("Invalid argument");
        }

        System.out.println("실행 결과");
        for (int i=0; i<trial; i++) {
            for (Car c : car_list) {
                c.Move();
                c.PrintPos();
            }
            System.out.println();
        }

        String[] winner = new String[data.length];
        int winner_pos = 0;
        int winner_number = 0;

        for (Car c : car_list) {
            if (!c.IsWinner(winner_pos)) continue;
            if (c.IsHigherPos(winner_pos)) {
                winner_pos = c.GetPos();
                winner = new String[data.length];
                winner[0] = c.GetName();
                winner_number = 1;
                continue;
            }
            winner[winner_number++] = c.GetName();
        }

        for (int i=0; i<winner_number-1; i++) {
            System.out.print(winner[i] + ", ");
        }
        System.out.println(winner[winner_number-1] + "가 최종 우승했습니다.");

        sc.close();
    }
}
