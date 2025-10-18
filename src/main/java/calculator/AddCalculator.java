package calculator;

public class AddCalculator {
    /**
     * 숫자들의 합을 리턴
     *
     * @param inputNumbers 입력받은 숫자들
     * @return 합
     */
    public int calc(int[] inputNumbers) {
        int sum = 0;
        for (int num : inputNumbers) {
            sum += num;
        }
        return sum;
    }


}
