package enums;

public enum Options {

    NO_OPTIONS(0),
    IGNORE_URLS(4),
    IGNORE_DIGITS(2),
    FIND_REPEAT_WORDS(8),
    IGNORE_CAPITALIZATION(512);

    private final Integer item;

    Options(Integer item) {
        this.item = item;
    }

    public Integer getItem() {
        return item;
    }

}


