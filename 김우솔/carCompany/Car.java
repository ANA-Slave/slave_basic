package carCompany;

public class Car {

    private final String name;
    private int position;

    Car(String name) {
        if (nameCheck(name)) {
            throw new IllegalArgumentException("차 이름이 5글자 이상입니다");
        }
        this.name = name;
        position = 0;
    }

    boolean nameCheck(String name) {
        return name.length() > 5;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getCarName() {
        return name;
    }

}
