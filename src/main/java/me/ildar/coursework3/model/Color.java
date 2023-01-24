package me.ildar.coursework3.model;

public enum Color {
    WHITE("белый"),
    BLACK("чёрный"),
    GRAY("серый"),
    BLUE("синий"),
    GREEN("зелёный"),
    RED("красный"),
    YELLOW("жёлтый");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return getColor();
    }
}
