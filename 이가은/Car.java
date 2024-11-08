class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getPosition() {
        return "—".repeat(distance);
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
            distance++;
        }
    }
}