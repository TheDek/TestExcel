public abstract class RealCell implements Cell
{
    private String userInput;

    public RealCell(String input)
    {
        this.userInput = input;
    }

    @Override
    public String fullCellText()
    {
        return userInput;
    }

    public abstract double getDoubleValue();

    @Override
    public String abbreviatedCellText()
    {
        double value = getDoubleValue();
        String text = String.format("%.10g", value); // Ensures up to 10 significant digits

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
