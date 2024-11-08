package exception;

public class ChanceException {

    public static void validate(String inputChance) {

        int chance;

        try {
            chance = Integer.parseInt(inputChance);
        } catch(NumberFormatException e) {
            throw new NumberFormatException("양의 정수를 입력하세요.");
        }

        if(chance <= 0) {
            throw new NumberFormatException("양의 정수를 입력하세요.");
        }
    }
}
