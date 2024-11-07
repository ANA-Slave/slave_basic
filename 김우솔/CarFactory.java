import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarFactory {

    private List<Carr> carList;
    CarFactory(StringTokenizer st) {
        carList = new ArrayList<>();
        int instancesize = st.countTokens();
        for (int i = 0; i < instancesize; i++) {
            Carr car = new Carr(st.nextToken());
            carList.add(car);
        }
    }
    public List<Carr> getCarList() {
        return carList;
    }
}

