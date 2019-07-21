package enums;

public enum ErrorCodes {

    ERROR_UNKNOWN_WORD(1),
    ERROR_REPEAT_WORD(2),
    ERROR_CAPITALIZATION(3),
    ERROR_TOO_MANY_ERRORS(4);

    private final Integer item;

    ErrorCodes(Integer item) {
        this.item = item;
    }

    public Integer getItem() {
        return item;
    }

}
