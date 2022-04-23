package Ex02;

public class DashSpreadsheetExporter {
    private SpreadsheetImpl sheet;

    public DashSpreadsheetExporter(SpreadsheetImpl sheet) {
        this.sheet = sheet;
    }

    public String export() {
        String result = "";
        result += sheet.getRowCount();
        result += ",";
        result += sheet.getColumnCount();
        result += "#";
        for(int r = 0; r < sheet.getRowCount(); r++) {
            for(int c = 0; c < sheet.getColumnCount(); c++){
                if(sheet.getArray()[r][c] == "") {
                    result += "-";
                } else {
                    result += sheet.getArray()[r][c];
                }
            }
        }
        return result;
    }
}
