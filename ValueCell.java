public class ValueCell extends RealCell
{
    public ValueCell(String input)
    {
        super(input);
    }

    @Override
    public double getDoubleValue()
    {
        return Double.parseDouble(fullCellText());
    }

    @Override
    public String abbreviatedCellText()
    {
        double value = getDoubleValue();
        String text = String.format("%.1f", value); // Always one decimal place

        if (text.length() > 10)
        {
            return text.substring(0, 10);
        }
        else
        {
            StringBuilder sb = new StringBuilder(text);
            while (sb.length() < 10)
            {
                sb.append(" ");
            }
            return sb.toString();
        }
    }
}
