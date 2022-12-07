package onboarding;

import onboarding.problem1.infra.PageNumberAndSizeValidation;
import onboarding.problem1.serivce.PageService;
import onboarding.problem1.type.ResultValue;

import java.util.Arrays;
import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. 책을 임의로 펼친다.
        //2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        //3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        //4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
        //5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
        //6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.

        return 0;
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
            result += result * Integer.parseInt(splitData);
        }

        return result;
    }

    // 더한 값과 곱한 값 중 가장 큰 수를 비교하라
    public static int compareTo(int sumValue, int multiplyValue) {
        return Math.max(sumValue, multiplyValue);
    }
}