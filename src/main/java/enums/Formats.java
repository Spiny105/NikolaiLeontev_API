package enums;

public enum Formats {

    PLAIN("plain");

    private final String item;

    Formats(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

}