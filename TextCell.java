public class TextCell implements Cell
{
    private String cellText;
    
    public TextCell(String newText)
    {
        this.cellText = newText;
    }
    public String abbreviatedCellText() // text for spreadsheet cell display, must be exactly length 10
    {
        String newText = cellText;
        if (newText.length() < 10) 
        {
            while (newText.length() < 10)
                newText += " ";
        }
        else if (newText.length() == 10)
            return newText;
        else
        {
            return newText.substring(0,10);
        }
        return newText;
    }


	public String fullCellText() // text for individual cell inspection, not truncated or padded
	{
	    return "\"" + cellText + "\"";
	}
	
}
