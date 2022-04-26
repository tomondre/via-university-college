package sudoku;

public class Sudoku {
    private GridItem[][] grid;

    public Sudoku() {
        grid = new GridItem[9][9];
    }

    public Sudoku(GridItem[][] grid) {
        this.grid = grid;
    }

    public Sudoku(String str) {
        grid = new GridItem[9][9];
        for (int i = 0; i < 81; i++) {
            int row = i / 9;
            int column = i % 9;
            int numericValue = Character.getNumericValue(str.charAt(i));
            grid[row][column] = new GridItem(numericValue, numericValue != -1);
        }
    }

    public String toString() {
        String result = "";
        for (int r = 0; r < 9; r++) {
            if (r % 3 == 0) {
                result += "━━━━━━━━━" + "\n";
            }
            for (int c = 0; c < 9; c++) {
                if (c % 3 == 0) {
                    result += "┃";
                }
                int val = grid[r][c].getValue();
                if (val == -1) {
                    result += "-";
                } else {
                    result += val;
                }
            }
            result += "\n";
        }
        return result;
    }

    public void solve(int curRow, int curCol) {

        //Condition when the maze is solved
        if (curRow == 8 && curCol == 8) {
            System.out.println(this);
            return;
        }

        //Check if we are outside of columns and correcting the values to start of next row
        if (curCol > 8) {
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
        for (int i = 1; i < 10; i++) {
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
        int groupStartCol;
        int groupStartRow;

        if (row < 3) {
            groupStartRow = 0;
        } else if (row > 5) {
            groupStartRow = 6;
        } else {
            groupStartRow = 3;
        }

        if (column < 3) {
            groupStartCol = 0;
        } else if (column > 5) {
            groupStartCol = 6;
        } else {
            groupStartCol = 3;
        }

        for (int r = 0; r < 3; r++) {
            int currentRow = groupStartRow + r;
            for (int c = 0; c < 3; c++) {
                int currentColumn = groupStartCol + c;
                if (grid[currentRow][currentColumn].getValue() == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean followsRowRule(int num, int row) {
        for (int i = 0; i < 9; i++) {
            if (num == grid[row][i].getValue()) {
                return false;
            }
        }
        return true;
    }

    public boolean followsColumnRule(int num, int column) {
        for (int i = 0; i < 9; i++) {
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
//        String grid =
//                "---------" + //Row 1
//                "---------" + //Row 2
//                "---------" + //Row 3
//                "---------" + //Row 4
//                "---------" + //Row 5
//                "---------" + //Row 6
//                "---------" + //Row 7
//                "---------" + //Row 8
//                "---------";  //Row 9


        Sudoku sudoku = new Sudoku(grid);

        String s = sudoku.toString();

        boolean b = false;
//        b = sudoku.followsGroupRule(1, 2, 4);
//        b = sudoku.followsRowRule(6, 8);
//        b = sudoku.followsColumnRule(6, 0);

        sudoku.solve(0, 0);
    }
}
