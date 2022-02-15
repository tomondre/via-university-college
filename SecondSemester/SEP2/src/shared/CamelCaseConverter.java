package shared;

/**
 * Class responsible for converting the View enums to CamelCase for the path to the view. To be used in the ViewFactory
 */
public class CamelCaseConverter
{
    /**
     * Converts the final field convention type to CamelCase
     * @param s the string to convert
     * @return the converter string
     */
    public static String toCamelCase(String s)
    {
        String[] parts = s.split("_");
        String camelCaseString = "";
        for (String part : parts)
        {
            camelCaseString = camelCaseString + toProperCase(part);
        }
        return camelCaseString;
    }

    private static String toProperCase(String s)
    {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
