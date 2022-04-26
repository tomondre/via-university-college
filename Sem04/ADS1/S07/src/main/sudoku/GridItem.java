package sudoku;

public class GridItem {

    private boolean isOrigin;
    private int value;

    public GridItem(int value, boolean isOrigin) {
        this.isOrigin = isOrigin;
        this.value = value;
    }

    public boolean isOrigin() {
        return isOrigin;
    }

    public void setOrigin(boolean origin) {
        isOrigin = origin;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
