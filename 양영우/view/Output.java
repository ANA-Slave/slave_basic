package view;

import java.util.List;

public class Output {

    public static void printResult(List<String> carNames) {
        System.out.println("실행결과");

        for(String carName : carNames) {

            System.out.print(carName + " : ");


        }



    }
}
