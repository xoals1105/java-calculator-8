package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class Delimiter {
    private static final String DEFAULT = ",|:";
    private static final Pattern CUSTOM = Pattern.compile("//(.)\n(.*)");

    private Delimiter() { }

    static String[] split(String input) {
        Matcher matcher = CUSTOM.matcher(input);
        if (matcher.matches()) {
            String custom = Pattern.quote(matcher.group(1)); // 특수문자 안전 처리
            String numbers = matcher.group(2);
            return numbers.split(custom);
        }
        return input.split(DEFAULT);
    }
}
