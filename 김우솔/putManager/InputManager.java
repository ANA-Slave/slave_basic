package putManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {

    private BufferedReader input;

    public InputManager() {}

    public String inputCarList() throws IOException {
        input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분). :");
        return input.readLine();
    }

    public int inputTryCount() throws IOException {
        System.out.println("시도할 횟수는 몇회인가요?");
        String line = input.readLine();
        checkLineIsDigit(line);
        return Integer.parseInt(line);
    }

    private void checkLineIsDigit(String line) {
        for (char ch : line.toCharArray()) {
            checkDigit(ch);
        }
    }

    private void checkDigit(char c) {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

}
