package onboarding;

import onboarding.problem3.RuleValue;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for (int gameTurn = 1; gameTurn <= number; gameTurn++) {
            count += RuleValue.clapCount(gameTurn);
        }

        return count;
    }
}