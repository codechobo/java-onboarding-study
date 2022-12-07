package onboarding;

import onboarding.problem3.RuleValue;

public class Problem3 {
    public static int solution(int number) {
        if (!isLength(number)) {
            throw new IllegalArgumentException();
        }

        int count = 0;
        for (int gameTurn = 1; gameTurn <= number; gameTurn++) {
            count += RuleValue.clapCount(gameTurn);
        }

        return count;
    }

    private static boolean isLength(int number) {
        if (number >= 1 && number <= 10000) {
            return true;
        }
        return false;
    }
}