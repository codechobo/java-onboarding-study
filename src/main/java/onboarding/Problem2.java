package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>(); // 문자를 저장할 stack

        String result = cryptogram;
        while (true) {
            Arrays.stream(result.split("")).forEach(data -> {
                if (!stack.isEmpty() && stack.peek().equals(data)) {
                    stack.pop();
                    return;
                }
                stack.push(data);
            });

            result = stack.stream().collect(Collectors.joining());
        }


        return result;
    }
}

