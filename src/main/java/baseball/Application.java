package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    public static  void start(){
        // 게임을 시작하고
        System.out.println("숫자 야구 게임을 시작합니다.\n");

        onGame();


        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if(input == 1){
            onGame();
        }else if(input == 2){

        }else{
            System.out.println("잘못된 입력입니다.");
        }

    }

    private static void onGame(){
        // 게임을 진행(랜덤한 수를 뽑고 유저가 맞출때까지 시도)
        
        List<Integer> computer = new ArrayList<>();
        String ballNum = ""; // 컴퓨터의 제안 숫자
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                ballNum+= Integer.toString(randomNumber);
            }
        }

        System.out.println("디버깅을 위한" + ballNum);

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("숫자를 입력해주세요 :");
            // 사용자 입력을 문자열로 받습니다.
            String input = checkNumberBall(scanner.nextLine());
            if(correct(ballNum,input)) break;
        }
        scanner.close();
    }

    private static boolean correct(String userNum, String computerNum){
        // 유저가 작성한 숫자와 컴퓨터가 제안한 숫자가 같은지?
        boolean isCorrect = false;

        int strike = 0;
        int ball = 0;
        for(int i=0; i<3; i++){
            String temp = userNum.substring(i,i+1);
            if(computerNum.substring(i,i+1).equals(temp)){
                ball+= 1;
            }else{
                if(computerNum.contains(temp)) ball+= 1;
            }
        }

        if(userNum.equals(computerNum)) isCorrect = true;
        printResult(strike,ball,isCorrect); // 해당 판에 유저가 입력한 숫자가 컴퓨터 숫자와 맞는지 출력

        return isCorrect;
    }

    private static String checkNumberBall(String input){
        // 유저가 입력한 값이 제대로된 값인지 검사
        if (input.length() < 3) {
            throw new RuntimeException("숫자가 너무 짧습니다.");
        }
        try {
            Integer.parseInt(input); // 문자열을 정수로 변환
        }catch (NumberFormatException e){
            throw new RuntimeException("정수가 아닌 입력입니다. 다시 시도해주세요.");
        }

        return input;
    }

    private static void printResult(int strike,int ball,boolean isCorrect){
        // 결과값을 출력(종료인지 아닌지)
        if(isCorrect){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else if(strike>0 && ball>0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if(strike == 0 && ball>0){
            System.out.println(ball + "볼 ");
        }else if(strike>0 && ball==0){
            System.out.println(ball + "스트라이크 ");
        }
    }


    // 상태패턴 적용해보기??
    public void play(int[] numList){
        // 숫자를 맞출때까지 제한은없음
        // 숫자중복은있으면안됨
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        Scanner scanner = new Scanner(System.in);

        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        boolean correct = false;

        while (true) { // 무한 루프
            System.out.println("숫자를 입력해주세요 :");
            String input = scanner.nextLine(); // 사용자 입력을 문자열로 받습니다.

            try {
                int number = Integer.parseInt(input); // 문자열을 정수로 변환
            } catch (NumberFormatException e) {
                if (input.length() < 3) {
                    System.out.println("숫자가 너무 짧습니다.");
                }
                System.out.println("정수가 아닌 입력입니다. 다시 시도해주세요.");

                continue;
            }


        }
    }
}
