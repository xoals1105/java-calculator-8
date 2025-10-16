package calculator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Numbers {
    private final List<PositiveNumber> values;

    private Numbers(List<PositiveNumber> values) {
        this.values = Collections.unmodifiableList(values);
    }

    static Numbers from(String[] tokens) {
        List<PositiveNumber> list = new ArrayList<>(tokens.length);
        for (String t : tokens) {
            list.add(PositiveNumber.of(t)); // 숫자 아님/음수 검증을 여기서 처리
        }
        return new Numbers(list);
    }

    int sum() {
        int total = 0;
        for (PositiveNumber n : values) {
            total += n.value();
        }
        return total;
    }
}
