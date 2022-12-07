package onboarding;

import onboarding.problem4.Dictionary;
import onboarding.problem4.Validation;

public class Problem4 {
    public static String solution(String word) {
        Dictionary dictionary = new Dictionary();
        Validation validation = new Validation();
        validation.isValid(word);

        for (int index = 0; index < word.length(); index++) {
            dictionary.refer(word.charAt(index));
        }

        return dictionary.translate();
    }
}
