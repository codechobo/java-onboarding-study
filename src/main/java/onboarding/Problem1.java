package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem1 {

    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isLength(pobi, crong)) {
            return -1;
        }

        if (!isPageNumberInOrder(pobi, crong)) {
            return -1;
        }

        if (!isStartPageOrLastPage(pobi, crong)) {
            return -1;
        }

        int pobiValue = Math.max(
                Math.max(sum(pageOpen(pobi, LEFT_PAGE)), multiply(pageOpen(pobi, LEFT_PAGE))),
                Math.max(sum(pageOpen(pobi, RIGHT_PAGE)), multiply(pageOpen(pobi, RIGHT_PAGE)))
        );

        int crongValue = Math.max(
                Math.max(sum(pageOpen(crong, LEFT_PAGE)), multiply(pageOpen(crong, LEFT_PAGE))),
                Math.max(sum(pageOpen(crong, RIGHT_PAGE)), multiply(pageOpen(crong, RIGHT_PAGE)))
        );

        return compareTo(pobiValue, crongValue);
    }

    private static boolean isStartPageOrLastPage(List<Integer> pobi, List<Integer> crong) {
        if (isOpenPageValid(pobi) && isOpenPageValid(crong)) {
            return true;
        }

        return false;
    }

    private static boolean isOpenPageValid(List<Integer> person) {
        return !(pageOpen(person, LEFT_PAGE) == 1 || pageOpen(person, RIGHT_PAGE) == 400);
    }

    private static boolean isPageNumberInOrder(List<Integer> pobi, List<Integer> crong) {
        if (pageOpen(pobi, LEFT_PAGE) + 1 == pageOpen(pobi, RIGHT_PAGE) && pageOpen(crong, LEFT_PAGE) + 1 == pageOpen(crong, RIGHT_PAGE)) {
            return true;
        }

        return false;
    }

    private static boolean isLength(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() == 2 && crong.size() == 2) {
            return true;
        }

        return false;
    }

    // 1. 책을 임의로 펼친다.
    public static Integer pageOpen(List<Integer> person, int position) {
        return person.get(position);
    }

    // 각 페이지 번호의 각 자리 숫자를 모두 더한다.
    public static int sum(Integer pageNumber) {
        String[] split = String.valueOf(pageNumber).split("");
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }

    // 모두 곱한다.
    public static int multiply(Integer pageNumber) {
        String[] split = String.valueOf(pageNumber).split("");

        int result = 1;
        for (String splitData : split) {
            result *= Integer.parseInt(splitData);
        }

        return result;
    }

    // 더한 값과 곱한 값 중 가장 큰 수를 비교하라
    public static int compareTo(int pobiValue, int crongValue) {
        return Integer.compare(pobiValue, crongValue) == -1 ? 1 : 2;
    }
}