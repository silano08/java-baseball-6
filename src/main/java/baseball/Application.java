package baseball;

import facade.GameFacade;

import java.util.Scanner;

public class Application {

    private static final Scanner scanner = new Scanner(System.in); // 전역 Scanner 객체 생성

    public static void main(String[] args) {
        // TODO: 프로그램 구현
//        start();
//        scanner.close(); // 프로그램 종료 시 Scanner 객체 닫기

        GameFacade gameFacade = GameFacade.getInstance();
        gameFacade.startGame();
    }
}
