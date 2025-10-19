package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AddRequest request = new AddRequest(Console.readLine());

        AddCalculator calculator = new AddCalculator();

        int result = calculator.calc(request.getNumbers());

        System.out.println("결과 : " + result);
    }
}
