package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 구분자로_끝나는_경우_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,2,")) // 검증하려는 입력값
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연속_구분자_예외_쉼표() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 연속_구분자_예외_콜론() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1::2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 엔터만_입력하면_0_반환() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 기본_구분자_혼용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_구분자_말미_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;\\n1;2;"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 커스텀_한글자() {
        assertSimpleTest(() -> {
            run("//;\\n1;2;3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_여러글자() {
        assertSimpleTest(() -> {
            run("//***\\n1***2***3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 커스텀_특수문자() {
        assertSimpleTest(() -> {
            run("//.\\n1.2.3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 영_하나면_0() {
        assertSimpleTest(() -> {
            run("0");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 공백포함_토큰은_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1, 2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자아님_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a,2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 음수_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-1,2,3"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
