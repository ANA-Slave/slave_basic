package racing_car;

class Car {
    private String car_name;
    private int pos;

    public Car(String name) {
        car_name = name;
    }

    public String GetName() {
        return car_name;
    }

    public int GetPos() {
        return pos;
    }

    public void Move() {
        int prob = (int) (Math.random() * 10);

        if (prob >= 4) {
            pos += 1;
        }
    }

    public void PrintPos() {
        System.out.print(car_name + " : ");
        for (int i=0; i<pos; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public boolean IsWinner(int winner_pos) {
        if (pos < winner_pos) return false;
        return true;
    }

    public boolean IsHigherPos(int winner_pos) {
        if (pos > winner_pos) return true;
        return false;
    }
}
