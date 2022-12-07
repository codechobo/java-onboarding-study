package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public enum RuleValue {

    THREE("3"),
    SIX("6"),
    NINE("9");

    private final String value;

    RuleValue(String value) {
        this.value = value;
    }

    // 번호를 받아 카우느 처리 한다.
    public static int clapCount(int number) {
        return (int) Arrays.stream(String.valueOf(number).split(""))
                .flatMap(data ->
                        Stream.of(values())
                                .filter(ruleValue -> ruleValue.value.equals(data)))
                .count();
    }
}
