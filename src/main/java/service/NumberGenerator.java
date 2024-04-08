package service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public static String computerNum(){
        List<Integer> computer = new ArrayList<>();
        String ballNum = ""; // 컴퓨터의 제안 숫자
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                ballNum += Integer.toString(randomNumber);
            }
        }

        return ballNum;
    }
}
