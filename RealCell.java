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
        String formattedText = String.format("%.10s", fullCellText);
        if (formattedText.length() < 10)
        {
            formattedText = String.format("%-10s", formattedText);
        }
        return formattedText;
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
