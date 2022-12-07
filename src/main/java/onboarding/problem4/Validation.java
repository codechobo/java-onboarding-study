package onboarding.problem4;

public class Validation {

    public void isValid(String word) {
        if (!(word.length() >= 1 && word.length() <= 1000)) {
            throw new IllegalArgumentException("문자열 길이의 범위에 벗어났습니다.");
        }

        if (!word.chars().allMatch(Character::isAlphabetic)) {
            throw new IllegalArgumentException("알파벳이 아닙니다.");
        }
    }
}
