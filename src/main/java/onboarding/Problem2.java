package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>(); // 문자를 저장할 stack

        String result = cryptogram;
        while (true) {
            makeStream(result).forEach(data -> {
                if (!stack.isEmpty() && stack.peek().equals(data)) {
                    stack.pop();
                    return;
                }
                stack.push(data);
            });

            result = stack.stream().collect(Collectors.joining());

            // 중복되지 않는 숫자가 없을 시 반복문 탈출
            if (count(makeStream(result).distinct()) == count(makeStream(result))) {
                break;
            }
        }

        return result;
    }

    private static Stream<String> makeStream(String result) {
        return Arrays.stream(result.split(""));
    }

    private static int count(Stream<String> result) {
        return (int) result.count();
    }
}

