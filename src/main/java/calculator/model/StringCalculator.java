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

        Numbers numbers = Numbers.from(tokens);
        return numbers.sum();
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
}
