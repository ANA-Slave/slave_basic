import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            String carNames = scanner.nextLine();
            System.out.println("시도할 횟수는 몇회인가요?");
            int attempts = Integer.parseInt(scanner.nextLine());

            RaceView view = new RaceView();
            RacingGame game = new RacingGame(carNames, attempts, view);
            view.printMessage("실행 결과");
            game.startRace();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}