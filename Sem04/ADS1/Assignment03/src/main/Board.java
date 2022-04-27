public class Board {

    //Grid withe booleans that represents if the queen is place in each item or not
    private BoardSquare[][] grid;
    private int size;

    public Board(int size) throws Exception {
        if (size < 4) {
            throw new Exception("Size too small for the board");
        }
        grid = new BoardSquare[size][size];

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                grid[r][c] = new BoardSquare(r, c, size);
            }
        }

        this.size = size;
    }

    public void solveQueens(int col) {
         //Check if the algorithm is done, if yes, report and return
        if (col >= size) {
            System.out.println(toString());
            return;
        }

        for (int r = 0; r < size; r++) {
            //If the position is ok
            if(isPlacementOk(r, col)) {
                //Add queen to the current position
                BoardSquare currentBoardSquare = grid[r][col];
                currentBoardSquare.setHasQueen(true);

                //Call recursively for next row
                solveQueens(col + 1);

                //Undo current queen placement
                currentBoardSquare.setHasQueen(false);
            }
        }
    }

    private boolean isPlacementOk(int row, int col) {
        //For each previous row
        for (int r = 0; r < size; r++) {
            //For each column in a current row
            for (int c = 0; c <= col; c++) {
                BoardSquare currentSquare = grid[r][c];
                if (currentSquare.hasConflict(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String horizontalLine = "━".repeat(size * 4 + 1) + "\n";

        result.append(horizontalLine);

        for (int r = 0; r < size; r++) {
            result.append("┃");
            for (int c = 0; c < size; c++) {
                BoardSquare boardSquare = grid[r][c];
                if (boardSquare.hasQueen()) {
                    result.append(" Q ");
                } else {
                    result.append("   ");
                }
                result.append("┃");
            }
            result.append("\n").append(horizontalLine);
        }
        return result.toString();
    }
}
