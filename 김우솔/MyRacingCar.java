import carCompany.CarFactory;
import putManager.InputManager;

import java.io.IOException;

public class MyRacingCar {
    public static void main(String[] args) throws IOException {

        InputManager inputManager = new InputManager();
        CarFactory carFactory = new CarFactory(inputManager.inputCarList());

        int tryCount = inputManager.inputTryCount();

        PlayRacing playRacing = new PlayRacing(tryCount, carFactory.getCarList());
        playRacing.playRace();
        System.out.println(playRacing.whoIsWinner());

    }

}
