// SpreadsheetLocation.java

public class SpreadsheetLocation implements Location 
{
    private int row;
    private int col;

    public SpreadsheetLocation(String cellName) 
    {
        // Extract column letter and row number from cellName
        String columnPart = cellName.replaceAll("[^A-Za-z]", "").toUpperCase();
        String rowPart = cellName.replaceAll("[^0-9]", "");

        // Convert column letter to index (A -> 0, B -> 1, ..., Z -> 25, AA -> 26, etc.)
        col = 0;
        for (int i = 0; i < columnPart.length(); i++) 
        {
            col *= 26;
            col += columnPart.charAt(i) - 'A' + 1;
        }
        col--; // Convert to zero-based index

        // Convert row number to zero-based index
        row = Integer.parseInt(rowPart) - 1;
    }

    @Override
    public int getRow() 
    {
        return row;
    }

    @Override
    public int getCol() 
    {
        return col;
    }
}
