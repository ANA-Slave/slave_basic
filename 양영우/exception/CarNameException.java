package exception;

import java.util.List;

public class CarNameException {

    public static void validate(List<String> carNames) {
        if(isExist(carNames)) {
            throw new IllegalArgumentException("이미 존재하는 차의 이름을 입력하였습니다.");
        }

        if(isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름을 입력할 때 공백을 확인하세요.");
        }




    }



    private static boolean isExist(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }

    private static boolean isBlank(List<String> carNames) {
        for(String name : carNames) {
            if(name == null || name.isEmpty()) {
                return true;
            }

            boolean onlySpace = true;
            for(int i=0; i<name.length(); i++) {
                if(name.charAt(i) != ' ') {
                    onlySpace = false;
                    break;
                }
            }
            if(onlySpace) return true;
        }
        return false;
    }

}
