package service;

public class InputValidator {

    public static String checkNumberBall(String input){
        try {
            if (input == null || input.isBlank()) {
                throw new RuntimeException("숫자를 입력해주세요");
            }

            Integer.parseInt(input); // 문자열을 정수로 변환

            // 유저가 입력한 값이 제대로된 값인지 검사
            if (input.length() < 3) {
                throw new RuntimeException("숫자가 너무 짧습니다.");
            }else if(input.length() > 3){
                throw new RuntimeException("숫자가 너무 깁니다.");
            }
            return input;
        }catch (NumberFormatException e){
            throw new RuntimeException("정수가 아닌 입력입니다. 다시 시도해주세요.");
        }
    }
}
