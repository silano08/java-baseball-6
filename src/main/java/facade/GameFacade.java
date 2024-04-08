package facade;

import camp.nextstep.edu.missionutils.Randoms;
import service.InputValidator;
import service.NumberGenerator;
import service.ResultCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameFacade {

    private static final Scanner scanner = new Scanner(System.in); // 전역 Scanner 객체 생성
    private static final NumberGenerator generator = new NumberGenerator();
    private static final InputValidator validator = new InputValidator();
    private static  final ResultCalculator calculator = new ResultCalculator();


    // 싱글톤 인스턴스를 저장할 private static 변수
    private static GameFacade instance;

    // Private 생성자
    private GameFacade() {}

    // 인스턴스에 접근하기 위한 public static 메소드
    public static GameFacade getInstance() {
        if (instance == null) {
            instance = new GameFacade();
        }
        return instance;
    }


    public static void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.\n");
        while (true) {
            // 게임을 시작합니다.
            onGame();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            int input = scanner.nextInt();
            scanner.nextLine(); // 숫자 입력 후 남은 줄바꿈 문자 소비

            if (input == 1) {
                // 게임 재시작
                System.out.println("게임을 재시작합니다.");
            } else if (input == 2) {
                // 게임 종료
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                break;
            }
        }
    }

    public static void onGame(){
        String ballNum = generator.computerNum(); // 컴퓨터의 제안 숫자

        while (true){
            System.out.println("숫자를 입력해주세요 :");
            // 사용자 입력을 문자열로 받습니다.
            String temp = scanner.nextLine();
            String input = validator.checkNumberBall(temp);
            if(calculator.correct(ballNum,input)) break;
        }
    }
}
