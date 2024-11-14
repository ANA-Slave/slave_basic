package racing_car;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class IO {
    static Scanner sc = new Scanner(System.in);
    public static String InputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input_data = sc.nextLine();
        return input_data;
    }

    public static int InputTrial() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int trial;

        try {
            trial = sc.nextInt();
        } catch (InputMismatchException e) {
            sc.close();
            throw new IllegalArgumentException("이동 횟수는 자연수를 입력하시오.");
        }
        sc.close();
        return trial;
    }

    public static void Output(ArrayList<String> winner_list) {
        for (int i=0; i<winner_list.size()-1; i++) {
            System.out.print(winner_list.get(i) + ", ");
        }
        System.out.println(winner_list.get(winner_list.size()-1) + "가 최종 우승했습니다.");
    }
}
