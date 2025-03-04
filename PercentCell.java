public class PercentCell extends RealCell
{
    public PercentCell(String input)
    {
        super(input);
    }

    @Override
    public double getDoubleValue()
    {
        String percentStr = fullCellText().substring(0, fullCellText().length() - 1);
        double percentValue = Double.parseDouble(percentStr);
        return percentValue / 100.0;
    }

    @Override
    public String fullCellText()
    {
        return Double.toString(getDoubleValue()); // Converts percent to decimal form
    }

    @Override
    public String abbreviatedCellText()
    {
        int displayPercent = (int) (getDoubleValue() * 100);
        String text = displayPercent + "%";

        if (text.length() > 10)
        {
            return text.substring(0, 10);
        }
        else
        {
            return String.format("%-10s", text);
        }
    }
}
