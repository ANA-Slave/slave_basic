import java.util.List;

public class PlayRacing {
    private List<Carr> carList;
    private int tryCount;
    private StringBuffer sb;
    PlayRacing(int num, List<Carr> carList) {
        this.carList = carList;
        tryCount = num;
        sb = new StringBuffer();
    }
    public String playRace() {
        for (int i = 1; i <= tryCount; i++) {
            decisionForOneStepToList();
            printListPosition();
            sb.append("\n");
        }
        checkWinner();
        return sb.toString();
    }
    void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        sb.append("\n");
    }
    void decisionForOneStepToList() {
        for (int j = 0; j < carList.size(); j++) {
            decisionForOneStep(carList.get(j), j);
        }
    }
    void goOneStep(Carr car, int index) {
        car.setPosition(car.getPosition() + 1);
        carList.set(index, car);
    }
    void decisionForOneStep(Carr car, int index) {
        double result = Math.random() * 10;
        if (result >= 4.0) goOneStep(car, index);
    }
    void checkWinner() {
        int max = 0;
        for (int i = 0; i < carList.size(); i++) {
            max = passBigger(i, max);
        }
        for (int i = 0; i < carList.size(); i++) {
            isMaxMeter(max, carList.get(i));
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("가 최종 우승했습니다.");
    }
    int passBigger(int i, int max) {
        if (carList.get(i).getPosition() > max) {
            max = carList.get(i).getPosition();
        }
        return max;
    }
    void printListPosition() {
        for (int j = 0; j < carList.size(); j++) {
            sb.append(carList.get(j).getCarName());
            sb.append(":");
            printPosition(carList.get(j).getPosition());
        }
    }
    void isMaxMeter(int max, Carr car) {
        if (max == car.getPosition()) sb.append(car.getCarName()).append(",");
    }
}