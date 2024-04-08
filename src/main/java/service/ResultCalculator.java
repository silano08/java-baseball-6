package service;

public class ResultCalculator {

    public static boolean correct(String userNum, String computerNum){
        // 유저가 작성한 숫자와 컴퓨터가 제안한 숫자가 같은지?
        boolean isCorrect = false;

        int strike = 0;
        int ball = 0;
        for(int i=0; i<3; i++){
            String temp = userNum.substring(i,i+1);
            if(computerNum.substring(i,i+1).equals(temp)){
                strike+= 1;
            }else{
                if(computerNum.contains(temp)) ball+= 1;
            }
        }

        if(userNum.equals(computerNum)) isCorrect = true;
        printResult(strike,ball,isCorrect); // 해당 판에 유저가 입력한 숫자가 컴퓨터 숫자와 맞는지 출력

        return isCorrect;
    }

    public static void printResult(int strike,int ball,boolean isCorrect){
        // 결과값을 출력(종료인지 아닌지)
        if((strike + ball) > 3) throw new RuntimeException("잘못된 요청입니다.");

        if(isCorrect){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }else if(strike>0 && ball>0){
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }else if(strike == 0 && ball>0){
            System.out.println(ball + "볼 ");
        }else if(strike>0 && ball==0){
            System.out.println(strike + "스트라이크 ");
        }
    }
}
