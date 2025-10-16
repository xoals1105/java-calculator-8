package calculator.model;

final public class PositiveNumber {
    private final int value;

    private PositiveNumber(int value) {
        if(value < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        this.value = value;
    }

    static PositiveNumber of (String token) {
        try {
            return new PositiveNumber(Integer.parseInt(token));
        } catch (NumberFormatException error) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함됐습니다.");
        }
    }

    int value() {
        return value;
    }
}
