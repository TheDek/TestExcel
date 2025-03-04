import java.text.DecimalFormat;

public class RealCell implements Cell
{
    protected String fullCellText;

    public RealCell(String input)
    {
        this.fullCellText = input;
    }

    @Override
    public String fullCellText()
    {
        return fullCellText;
    }

    @Override
    public String abbreviatedCellText()
    {
        DecimalFormat df = new DecimalFormat("#.##########"); 
        String formattedText = df.format(getDoubleValue());

        if (formattedText.length() > 10)
        {
            return formattedText.substring(0, 10); 
        }
        return String.format("%-10s", formattedText);
    }

    public double getDoubleValue()
    {
        if (fullCellText.matches("-?\\d+(\\.\\d+)?")) 
        {
            return Double.parseDouble(fullCellText);
        }
        return 0.0;
    }
}
