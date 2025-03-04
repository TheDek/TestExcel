public class PercentCell extends RealCell
{
    private double value;
    private String valueString;
    public PercentCell(String valueString)
    {
        super(valueString);
        // value = (Double.parseDouble(valueString.substring(0,(valueString.length() - 1)))/100);
        value = (Double.parseDouble(valueString.substring(0,(valueString.length() - 1))));
    }
    public String abbreviatedCellText()
    {
        String formattedValue = String.format("%.0f", value) + "%";
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
    public String fullCellText()
    {
        return Double.toString(value/100);
    }
    
}
