package onboarding;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem2 {

    public static String solution(String cryptogram) {
        Stack<String> stack = new Stack<>();

        if (!isLength(cryptogram) || isContainsUppercase(cryptogram)) {
            throw new IllegalArgumentException();
        }

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

            if (count(makeStream(result).distinct()) == count(makeStream(result))) {
                break;
            }
        }

        return result;
    }

    private static boolean isContainsUppercase(String cryptogram) {
        return cryptogram.chars().anyMatch(Character::isUpperCase);
    }

    public static void main(String[] args) {
        System.out.println(solution("a"));
    }

    private static boolean isLength(String cryptogram) {
        return cryptogram.length() >= 1 && cryptogram.length() <= 1000;
    }

    private static Stream<String> makeStream(String result) {
        return Arrays.stream(result.split(""));
    }

    private static int count(Stream<String> result) {
        return (int) result.count();
    }
}

