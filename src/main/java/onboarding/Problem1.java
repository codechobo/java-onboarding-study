package onboarding;

import onboarding.problem1.infra.PageNumberAndSizeValidation;
import onboarding.problem1.serivce.PageService;
import onboarding.problem1.type.ResultValue;

import java.util.Arrays;
import java.util.List;

public class Problem1 {

    private static final int LEFT_PAGE = 0;
    private static final int RIGHT_PAGE = 1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외 처리
        // 리스트의 길이는 2이다.
        if (isLength(pobi, crong)) {
            return -1;
        }

        // 페이지 번호가 순서대로 들어있다. 에를 들어 왼쪽 페이지번호가 1이면 오른쪽 페이지 번호는 2 여야 한다.
        if (isPageNumberInOrder(pobi, crong)) {
            return -1;
        }


        int pobiLeftValue = Math.max(sum(pageOpen(pobi, LEFT_PAGE)), multiply(pageOpen(pobi, LEFT_PAGE))); // 포비의 왼쪽 페이지 번호
        int pobiRightValue = Math.max(sum(pageOpen(pobi, RIGHT_PAGE)), multiply(pageOpen(pobi, RIGHT_PAGE))); // 포비의 오른쪽 페이지 번호

        int crongLeftValue = Math.max(sum(pageOpen(crong, LEFT_PAGE)), multiply(pageOpen(crong, LEFT_PAGE))); // 크롱의 왼쪽 페이지 번호
        int crongRightValue = Math.max(sum(pageOpen(crong, RIGHT_PAGE)), multiply(pageOpen(crong, RIGHT_PAGE))); // 크롱의 오른쪽 페이지 번호

        // 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
        int pobiValue = Math.max(pobiLeftValue, pobiRightValue);
        int crongValue = Math.max(crongLeftValue, crongRightValue);

        // 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
        return compareTo(pobiValue, crongValue);
    }

    private static boolean isPageNumberInOrder(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(LEFT_PAGE) + 1 == pobi.get(RIGHT_PAGE) && crong.get(LEFT_PAGE) + 1 == crong.get(RIGHT_PAGE)) {
            return false;
        }

        return true;
    }

    private static boolean isLength(List<Integer> pobi, List<Integer> crong) {
        if (pobi.size() == 2 && crong.size() == 2) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int solution = solution(List.of(99, 132), List.of(211, 212));
        System.out.println(solution);
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
        return Integer.compare(pobiValue, crongValue);
    }
}