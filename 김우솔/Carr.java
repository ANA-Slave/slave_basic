public class Carr {
    private String carName;
    public Position position;
    Carr(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("차 이름이 5글자 이상입니다");
        carName = name;
        position = new Position(0);
    }
    public int getPosition() {
        return position.getPosition();
    }
    public void setPosition(int num) {
        position.setPosition(num);
    }
    public String getCarName() {
        return carName;
    }
}
