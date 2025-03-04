public class EmptyCell implements Cell
{
    private String cellText;
    
    public EmptyCell()
    {
        cellText = "          ";
    }
    @Override
    public String abbreviatedCellText() // text for spreadsheet cell display, must be exactly length 10
    {
        return cellText; // 10 spaces
    }
    
    @Override
	public String fullCellText() // text for individual cell inspection, not truncated or padded
	{
	    return "";
	}
}
