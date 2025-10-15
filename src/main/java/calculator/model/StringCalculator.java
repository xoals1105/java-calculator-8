package calculator.model;

public class StringCalculator {

    /**
     * 주어진 문자열의 숫자들을 더한 값을 반환한다.
     * - 빈/공백/NULL이면 0 반환
     */
    public int add(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        // 기본 구문자/ 커스텀 구문자 로직 추후 추가
        throw new IllegalArgumentException("");
    }
}
