import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MyRacingCar {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). :");

        StringTokenizer st = new StringTokenizer(br.readLine(), ",");
        CarFactory carFactory = new CarFactory(st);

        System.out.println("시도할 횟수는 몇회인가요?");
        String line = br.readLine();
        int tryCount;
        checkLineIsDisit(line);
        tryCount = Integer.parseInt(line);

        System.out.println("실행결과");
        PlayRacing playRacing = new PlayRacing(tryCount, carFactory.getCarList());
        System.out.println(playRacing.playRace());
    }
    static void checkLineIsDisit(String line) {
        for (int i = 0; i < line.length(); i++) {
            checkDisit(line.charAt(i));
        }
    }
    static void checkDisit(char c) {
        if (!Character.isDigit(c)) throw new IllegalArgumentException("숫자를 입력해주세요");
    }
}