package racing_car;

public class RacingCar {
    public static void main(String[] args) {
        String input_data = IO.InputCarName();
        int trial = IO.InputTrial();

        Race.Init(input_data);

        System.out.println("실행 결과");
        for (int i=0; i<trial; i++) {
            Race.Play();
        }

        for (Car c : Race.GetCarList()) {
            Race.Finish(c);
        }

        IO.Output(Race.GetWinnerList());
    }
}
