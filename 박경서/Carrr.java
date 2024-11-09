import java.util.Random;

class Carrr {
    private String name;
    private int distance;
    private Random random;

    public Carrr(String name) {
        this.name = name;
        this.distance = 0;
        this.random = new Random();
    }

    public boolean race() {
        return random.nextInt(10) >= 4;
    }

    public void increasDistance() {
        distance++;
    }

    public int getDistance() {
        return distance;
    }

    public String getname() {
        return name;
    }

    public void showDistance() {
        System.out.print(name + " : " + "-".repeat(distance) + "\n");
    }
}