package data;

public enum ColorData {


    RED("Красный"),
    BLACK("Чёрный");

    private String name = null;

    ColorData(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
