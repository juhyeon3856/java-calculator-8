package calculator;

import java.util.Arrays;

public class AddRequest {

    /**
     * 커스텀 구분자 시작위치 신호와 끝 신호
     */
    private final String START_SEPARATOR = "//";
    private final String END_SEPARATOR = "\\n";

    /**
     * 입력값
     */
    private String input;
    /**
     * 계산해야하는 숫자값. 즉, 입력의 결과값
     */
    private int[] numbers;
    /**
     * 커스텀구분자, 계산할 숫자 문자열의 위치를 나타내는 index
     */
    private DivisionIndexDto divisionIndex;

    AddRequest(String input) {
        this.input = input;
    }

    public int[] getNumbers() throws IllegalArgumentException {
        if (numbers == null) {
            inputNumbers();
        }
        return numbers;
    }

    /**
     * 문자열을 입력 받고, 구분자로 구분하여 숫자만 numbers에 저장한다.
     */
    public void inputNumbers() throws IllegalArgumentException {
        customValidation(input);
        String inputNumbers = input.substring(divisionIndex.inputStartIndex, divisionIndex.inputEndIndex);
        String inputSeparators =
                ":," + input.substring(divisionIndex.separatorStartIndex, divisionIndex.separatorEndIndex);

        validate(inputNumbers, inputSeparators);

        this.numbers = Arrays.stream(inputNumbers.split("[" + inputSeparators + "]"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    /**
     * 커스텀 구분자가 양쪽 다 있으면 시작, 끝 인덱스 반환 아니면 예외 던지기
     *
     * @param input 입력값
     * @return (separator 시작 인덱스, separator 끝나는 인덱스, input 시작 인덱스, input 끝 인덱스)
     * @throws IllegalArgumentException 입력 잘못 들어온 예외
     */
    private void customValidation(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Input is null");
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input is empty");
        }

        int startIndex = input.indexOf(START_SEPARATOR);
        int endIndex = input.indexOf(END_SEPARATOR);

        // 커스텀 구분자가 양쪽 다 있지 않으면
        if (startIndex != -1 && endIndex == -1) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (startIndex == -1 && endIndex != -1) {
            throw new IllegalArgumentException("Invalid input");
        }

        if (startIndex == -1 && endIndex == -1) {
            divisionIndex = new DivisionIndexDto(0, 0, 0, input.length());
            return;
        }

        divisionIndex = new DivisionIndexDto(startIndex + START_SEPARATOR.length(), endIndex,
                endIndex + END_SEPARATOR.length(),
                input.length());

    }

    /**
     * 더할 숫자 구문에 구분자와 숫자 이외의 값이 있거나, 구분자에 숫자가 있으면 예외 던지기
     *
     * @param numbers    더할 숫자구만
     * @param separators 구분자
     */
    private void validate(String numbers, String separators) throws IllegalArgumentException {
        // numbers 숫자, 구분자(separators) 이외의 값이 있으면
        if (!(numbers.matches("^[0-9" + separators + "]*$"))) {
            throw new IllegalArgumentException("Invalid input");
        }
        // 구분자에 숫자 있으면
        if (separators.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

}
