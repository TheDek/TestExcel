public class RealCell implements Cell
{
    private double value;
    private String valueString;
    
    public RealCell(String valueString)
    {
        this.valueString = valueString;
        value = 0.0;
    }
    
    public String abbreviatedCellText()
    {
        if (valueString.length() < 10) 
        {
            while (valueString.length() < 10)
                valueString += " ";
        }
        else if (valueString.length() == 10)
            return valueString;
        else
        {
            return valueString.substring(0,10);
        }
        return valueString;
    }
    
	public String fullCellText()
	{
	    return valueString;
	}
	public double getDoubleValue()
	{
	    return value;
	}
}
