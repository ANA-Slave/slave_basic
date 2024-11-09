import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public static void main(String[] args) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        String[] carNames = input.split(",");
        CarCheck(carNames);

        List<Carrr> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Carrr(name.trim()));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int gamecount = CountCheck(bf);

        System.out.println("실행 결과");
        for (int i = 0; i < gamecount; i++) {
            for (Carrr car : cars) {
                if (car.race()) {
                    car.increasDistance();
                }
                car.showDistance();
            }
            System.out.println();
        }

        List<Carrr> winners = Winners(cars);
        ShowWinners(winners);
    }

    private static void CarCheck(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
        }
    }

    private static int CountCheck(BufferedReader reader) {
        while (true) {
            String input;
            try {
                input = reader.readLine();
            } catch (IOException e) {
                System.out.println("입력 오류가 발생했습니다.");
                return 0;
            }
            if (!input.chars().allMatch(Character::isDigit)) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }
            int count = Integer.parseInt(input);

            if (count < 1) {
                System.out.println("양수를 입력해주세요.");
                continue;
            }
            return count;
        }
    }

    private static List<Carrr> Winners(List<Carrr> cars) {
        int longest = 0;
        for (Carrr car : cars) {
            if (car.getDistance() > longest) {
                longest = car.getDistance();
            }
        }
        List<Carrr> winners = new ArrayList<>();
        for (Carrr car : cars) {
            if (car.getDistance() == longest) {
                winners.add(car);
            }
        }
        return winners;
    }

    private static void ShowWinners(List<Carrr> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Carrr winner : winners) {
            winnerNames.add(winner.getname());
        }
        String result = String.join(", ", winnerNames);
        System.out.println(result + "가 최종 우승했습니다.");
    }

}
