import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

class Car {
    public int move_;
    public String name_;

    Random random = new Random();

    Car(String name) {
        name_ = name;
        move_ = 0;
    }

    public void PrintMove() {
        System.out.print(name_ + " : ");
        //move_수만큼 "-"개수 출력하는 부분
        for(int i = 0; i < move_; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
    public void RandomMove() {
        if (random.nextInt(10) >= 4) {
            move_ += 1;
        }
    }
    public static void Victory(Car[] carList) {
        //car의 move 횟수 비교한 후에 제일 큰 거 출력
        int maxMove = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.move_ > maxMove) {
                maxMove = car.move_;
            }
        }
        for (Car car : carList) {
            if (car.move_ == maxMove) {
                winners.add(car.name_);
            }
        }
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

}

public class Main {
    public static void main(String[] args) {
        String str;
        String[] tempList;
        int counter;

        Scanner sc = new Scanner(System.in);
        
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        str = sc.next();
        System.out.println("시도할 횟수는 몇회인가요?");
        counter = sc.nextInt();
        //쉼표를 기준으로 문자열 분리
        tempList = str.split(",");
        //배열로 객체생성
        Car[] carList = new Car[tempList.length];//100 대신에 변수로 바꿔야함
        for (int i = 0; i < tempList.length; i++) {
            carList[i] = new Car(tempList[i]);
        }

        //실행

        System.out.println("실행결과");
        for(int i=0; i<counter; i++) {
            for(Car car : carList) {
                car.RandomMove();
                car.PrintMove();
            }
            System.out.println();
        }
        Car.Victory(carList);

        sc.close();
    }
}