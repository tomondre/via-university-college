public class BoardSquare {

    private boolean hasQueen;
    private int row;
    private int col;
    private int boardSize;

    public BoardSquare(int row, int col, int boardSize) {
        this.row = row;
        this.col = col;
        this.boardSize = boardSize;
    }

    public boolean hasQueen() {
        return hasQueen;
    }

    public void setHasQueen(boolean hasQueen) {
        this.hasQueen = hasQueen;
    }

    public boolean hasConflict(int rowToCheck, int colToCheck) {
        if (!hasQueen) {
            return false;
        }

        //Item is on the same row
        if (rowToCheck == row) {
            return true;
        }

        int currentRow;
        int currentCol;

        currentRow = row;
        currentCol = col;
        while (currentCol < boardSize && currentRow < boardSize) {
            currentRow++;
            currentCol++;
            if (currentRow == rowToCheck && currentCol == colToCheck) {
                return true;
            }
        }

        currentRow = row;
        currentCol = col;
        while (currentRow >= 0 && currentCol < boardSize) {
            currentCol++;
            currentRow--;

            if (currentRow == rowToCheck && currentCol == colToCheck) {
                return true;
            }
        }
        return false;
    }
}
