public class Car {
    private final String name;

    private int location;

    public Car(final String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하로 작성해주세요.");
        }
        this.name = name;
    }

    public void move(RandomGenerator randomGenerator) {
        if(randomGenerator.generate() >= 4) {
            location++;
        }
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public String toString() {
        return name + " : " + "-".repeat(location);
    }
}
