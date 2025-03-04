public class ValueCell extends RealCell
{
    private double value;
    private String valueString;
    public ValueCell(String valueString)
    {
        super(valueString);
        value = Double.parseDouble(valueString);
    }
    public String abbreviatedCellText()
    {
        String formattedValue = String.format("%.1f", value);
        if (formattedValue.length() < 10) 
        {
            while (formattedValue.length() < 10)
                formattedValue += " ";
        }
        else if (formattedValue.length() == 10)
            return formattedValue;
        else
        {
            return formattedValue.substring(0,10);
        }
        return formattedValue;
    }
    
}
