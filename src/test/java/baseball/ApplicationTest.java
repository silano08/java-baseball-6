package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    // 우테코에서 제공하는 테스트코드말고.. 그냥 따로 작성하는 테스트코드

    @ParameterizedTest
    @CsvSource({
            "'123', true, ''", // 정상 케이스
            "'12', false, '숫자가 너무 짧습니다.'", // 짧은 입력
            "'1234', false, '숫자가 너무 깁니다.'", // 긴 입력
            "'abc', false, '정수가 아닌 입력입니다. 다시 시도해주세요.'", // 비숫자 입력
            "'', false, '숫자를 입력해주세요'", // 빈 문자열 입력
            "null, false, '숫자를 입력해주세요'" // null 입력
    })
    @DisplayName("checkNumberBall 메서드의 경곗값 테스트")
    void testCheckNumberBall(String input, boolean isValid, String expectedMessage) {
        // 사용자가 입력하는 값에 대한 경곗값 테스트
        if (isValid) {
            // 정상 케이스
            Assertions.assertEquals(input, Application.checkNumberBall(input));
        } else {
            // 예외 케이스
            Exception exception = Assertions.assertThrows(RuntimeException.class, () -> Application.checkNumberBall(input));
            Assertions.assertEquals(expectedMessage, exception.getMessage());
        }
    }

    @Test
    void testPrintResultWithInvalidInput() {
        // 프린트문으로 결과값을 출력하는 경우 반환값이 없어 검증이 어려움...
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Application.printResult(2, 2, false); // 스트라이크와 볼의 합이 3을 초과
        });
        assertEquals("잘못된 요청입니다.", exception.getMessage());

        // 사실 아래와같은 경우를 검증해야함
//        스트라이크와 볼의 합이 3을 초과하는 경우 (예외 발생)
//        정확히 3개의 숫자를 맞혔을 때 (게임 종료 메시지 출력)
//        스트라이크와 볼이 모두 있는 경우
//        오직 볼만 있는 경우
//        오직 스트라이크만 있는 경우
    }
}
