package calculator;

public class DivisionIndexDto {
    public int inputStartIndex;
    public int inputEndIndex;
    public int separatorStartIndex;
    public int separatorEndIndex;

    public DivisionIndexDto(int separatorStartIndex,
                            int separatorEndIndex, int inputStartIndex, int inputEndIndex) {
        this.separatorStartIndex = separatorStartIndex;
        this.separatorEndIndex = separatorEndIndex;
        this.inputStartIndex = inputStartIndex;
        this.inputEndIndex = inputEndIndex;
    }
}
