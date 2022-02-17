package shared;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CamelCaseConverterTest
{
    @Test
    public void testConvertsSingleFinalFieldConventionNameToCamelCase()
    {
        String converted = convert("STRING");
        assertEquals("String", converted);
    }

    @Test
    public void testConvertsMultipleFinalFieldConventionNameToCamelCase()
    {
        String converted = convert("STRING_STRING");
        assertEquals("StringString", converted);
    }

    @Test
    public void testConvertsSingleFinalFieldConventionNameWithNumericsToCamelCase()
    {
        String converted = convert("STRING12");
        assertEquals("String12", converted);
    }

    @Test
    public void testConvertsMultipleFinalFieldConventionNameWithNumericsToCamelCase()
    {
        String converted = convert("STRING12_STRING23");
        assertEquals("String12String23", converted);
    }

    @Test
    public void testConvertsMultipleFinalFieldConventionNameStartsWithNumericsToCamelCase()
    {
        String converted = convert("12STRING_23STRING");
        assertEquals("12string23string", converted);
    }

    private String convert(String string)
    {
        return CamelCaseConverter.toCamelCase(string);
    }
}