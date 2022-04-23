package Ex02;

public class Office {
    public static SpreadsheetImpl newSpreadsheet(int rows, int columns){
        return new SpreadsheetImpl(rows, columns);
    }
}
