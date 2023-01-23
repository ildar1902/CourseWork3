package me.ildar.coursework3.model;

public enum Size {
    XS(null, 35),
    S(36, 37),
    M(38, 40),
    L(41, 43),
    XL(44, 46),
    XXL(47, null);

    private final Integer lowerBound;
    private final Integer upperBound;

    Size(Integer lowerBound, Integer upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Integer getLowerBound() {
        return lowerBound;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    @Override
    public String toString() {
        if (getLowerBound() == null) {
            return getUpperBound().toString();
        }
        if (getUpperBound() == null) {
            return getLowerBound().toString();
        }
        return getLowerBound() + "-" + getUpperBound();
    }
}