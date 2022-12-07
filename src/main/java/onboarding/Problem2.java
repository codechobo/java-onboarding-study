package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>(); // 문자를 저장할 stack

        String result = cryptogram;
            Arrays.stream(result.split("")).forEach(data -> {
                if (!stack.isEmpty() && stack.peek().equals(data)) {
                    stack.pop();
                    return;
                }
                stack.push(data);
            });


        return result;
    }
}

