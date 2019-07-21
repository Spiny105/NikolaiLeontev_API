package enums;

public enum Languages {

    ENGLISH("en");

    private final String item;

    Languages(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

}
