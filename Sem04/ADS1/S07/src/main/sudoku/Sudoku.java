package sudoku;

public class Sudoku {
    private GridItem[][] grid;
    private final int size = 9;
    private final int groupSize = size / 3;

    public Sudoku() {
        grid = new GridItem[size][size];
        populateGrid();
    }

    public Sudoku(GridItem[][] grid) {
        this.grid = grid;
        populateGrid();
    }

    private void populateGrid() {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c] = new GridItem(-1, false);
            }
        }
    }

    public Sudoku(String str) {
        grid = new GridItem[size][size];
        for (int i = 0; i < size * size; i++) {
            int row = i / size;
            int column = i % size;
            int numericValue = Character.getNumericValue(str.charAt(i));
            grid[row][column] = new GridItem(numericValue, numericValue != -1);
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        String divideLineHorizontal = "━".repeat((size * 3) + groupSize + 1) + "\n";

        for (int r = 0; r < size; r++) {
            if (r % groupSize == 0) {
                result.append(divideLineHorizontal);
            }
            for (int c = 0; c < size; c++) {
                if (c % groupSize == 0) {
                    result.append("┃");
                }
                int val = grid[r][c].getValue();
                if (val == -1) {
                    result.append(" - ");
                } else {
                    result.append(" ").append(val).append(" ");
                }
            }
            result.append("┃");
            result.append("\n");
        }
        result.append(divideLineHorizontal);

        return result.toString();
    }

    public void solve(int curRow, int curCol) {

        //Condition when the maze is solved
        if (curRow == size - 1 && curCol == size) {
            System.out.println(this);
            return;
        }

        //Check if we are outside of columns and correcting the values to start of next row
        if (curCol >= size) {
            curCol = 0;
            ++curRow;
        }

        GridItem gridItem = grid[curRow][curCol];

        //Skipping the value change if we are on a field that was given by the initial sudoku layout
        if (gridItem.isOrigin()) {
            solve(curRow, ++curCol);
            return;
        }

        //Going through possible values
        for (int i = 1; i <= size; i++) {
            if (checkAllRules(i, curRow, curCol)) {
                gridItem.setValue(i);
                solve(curRow, curCol + 1);
                gridItem.setValue(-1);
            }
        }
    }

    public boolean checkAllRules(int value, int row, int col) {
        return followsGroupRule(value, row, col) && followsRowRule(value, row) && followsColumnRule(value, col);
    }

    public boolean followsGroupRule(int num, int row, int column) {
        int groupStartCol = 0;
        int groupStartRow = 0;

        //Setup index of first row of the group
        for (int i = 0; i <= size; i = i + 3) {
            if (row < i + groupSize) {
                groupStartRow = i;
                break;
            }
        }

        //Setup index of first column of the group
        for (int i = 0; i <= size; i = i + 3) {
            if (column < i + groupSize) {
                groupStartCol = i;
                break;
            }
        }

        for (int r = 0; r < groupSize; r++) {
            int currentRow = groupStartRow + r;
            for (int c = 0; c < groupSize; c++) {
                int currentColumn = groupStartCol + c;
                if (grid[currentRow][currentColumn].getValue() == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean followsRowRule(int num, int row) {
        for (int i = 0; i < size; i++) {
            if (num == grid[row][i].getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean followsColumnRule(int num, int column) {
        for (int i = 0; i < size; i++) {
            if (grid[i][column].getValue() == num) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String grid =
                "53--7----" + //Row 1
                "6--195---" + //Row 2
                "-98----6-" + //Row 3
                "8---6---3" + //Row 4
                "4--8-3--1" + //Row 5
                "7---2---6" + //Row 6
                "-6----28-" + //Row 7
                "---419--5" + //Row 8
                "----8--79";  //Row 9

        new Sudoku(grid).solve(0, 0);
    }
}
