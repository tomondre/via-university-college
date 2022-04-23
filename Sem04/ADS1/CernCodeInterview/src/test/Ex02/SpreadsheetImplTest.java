package Ex02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpreadsheetImplTest {

    private SpreadsheetImpl sheet;

    @Before
    public void setup() {
        int rows = 10;
        int columns = 5;
        sheet = Office.newSpreadsheet(rows, columns);
    }

    @Test
    public void cellsAreEmptyByDefault() {
        Assert.assertEquals("", sheet.get(0, 0));
        Assert.assertEquals("", sheet.get(3, 4));
    }

    @Test
    public void cellsAreStored() {
        sheet.put(1, 2, "foo");
        Assert.assertEquals("foo", sheet.get(1, 2));

        sheet.put(3, 3, "bar");
        Assert.assertEquals("bar", sheet.get(3, 3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void cantGetOutOfLimits() {
        sheet.get(12, 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void cantPutOutOfLimits() {
        sheet.put(3, 7, "foo");
    }
    @Test
    public void basicValueTypesAreRecognized() {
        sheet.put(2, 3, "foo");
        Assert.assertEquals(ValueType.STRING, sheet.getValueType(2, 3));

        sheet.put(0, 0, "foo56");
        Assert.assertEquals(ValueType.STRING, sheet.getValueType(0, 0));

        sheet.put(5, 2, "12");
        Assert.assertEquals(ValueType.INTEGER, sheet.getValueType(5, 2));

        // A value is a formula if and only if the first character is "="
        sheet.put(1, 1, "= 4 + 8");
        Assert.assertEquals(ValueType.FORMULA, sheet.getValueType(1, 1));

        // Formulas are not computed. That means, no need to parse them
        Assert.assertEquals("= 4 + 8", sheet.get(1, 1));
    }

    @Test
    public void integerCellsAreTrimmed() {
        sheet.put(1, 1, "     50 ");
        Assert.assertEquals("50", sheet.get(1, 1));

        // But string cells stay as they are
        sheet.put(2, 2, "     foo ");
        Assert.assertEquals("     foo ", sheet.get(2, 2));
    }

    @Test
    public void differentExportOptionsAreProvided() {
        sheet.put(0, 0, "a");
        sheet.put(1, 1, "b");
        sheet.put(2, 2, "c");
        sheet.put(3, 3, "d");
        sheet.put(3, 4, "e");

        Assert.assertEquals("10,5#" // Line breaks added for readability. There are no "\n" in the String
                        + "a-----" // 0
                        + "-b----" // 1
                        + "--c---" // 2
                        + "---d-e-" // 3
                        + "-----" // 4
                        + "-----" // 5
                        + "-----" // 6
                        + "-----" // 7
                        + "-----" // 8
                        + "-----" // 9
                , new DashSpreadsheetExporter(sheet).export());

        Assert.assertEquals("10,5#" // Line breaks added for readability. There are no "\n" in the String
                        + "a*****" // 0
                        + "*b****" // 1
                        + "**c***" // 2
                        + "***d*e*" // 3
                        + "*****" // 4
                        + "*****" // 5
                        + "*****" // 6
                        + "*****" // 7
                        + "*****" // 8
                        + "*****" // 9
                , new StarSpreadsheetExporter(sheet).export());
    }
}