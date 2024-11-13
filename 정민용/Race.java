package racing_car;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static ArrayList<Car> car_list;
    private static ArrayList<String> winner_list;
    private static int winner_pos;

    public static List<Car> GetCarList() {
        return car_list;
    }

    public static ArrayList<String> GetWinnerList() {
        return winner_list;
    }
    
    public static void Init(String input_data) {
        car_list = new ArrayList<Car>();
        for(String data : input_data.split(",")) {
            if (data.length() > 5) {
                throw new IllegalArgumentException("사용자 이름은 5자 이하만 가능합니다.");
            }
            car_list.add(new Car(data));
        }

        winner_list = new ArrayList<String>();
        winner_pos = 0;
    }

    public static void Play() {
        for(Car c : car_list) {
            c.Move();
            c.PrintPos();
        }
        System.out.println();
    }

    public static void Finish(Car c) {
        if (!c.IsWinner(winner_pos)) return;
        if (c.IsHigherPos(winner_pos)) {
            winner_pos = c.GetPos();
            winner_list.clear();
            winner_list.add(c.GetName());
            return;
        }
        winner_list.add(c.GetName());
    }
}
