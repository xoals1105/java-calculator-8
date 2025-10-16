package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    // 커스텀 구분자 패턴: //{구분자}\n{숫자}
    private static final Pattern CUSTOM = Pattern.compile("//(.)\n(.*)");
    /**
     * 주어진 문자열의 숫자들을 더한 값을 반환한다.
     * - 빈/공백/NULL이면 0 반환
     */
    public int add(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        text = text.replace("\\n", "\n");
        String[] tokens = splitTokens(text);

        int total = 0;
        for(String token : tokens) {
            int number = toInteger(token);
            validateNonNegative(number);
            total += number;
        }
        return total;
    }

    private String[] splitTokens(String text) {
        Matcher matcher = CUSTOM.matcher(text);
        if (matcher.matches()) {
            String custom = Pattern.quote(matcher.group(1));
            String numbers = matcher.group(2);
            return numbers.split(custom);
        }
        return text.split(",|:");
    }

    private  int toInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함됐습니다.");
        }
    }

    private void validateNonNegative(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
