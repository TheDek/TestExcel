//Update this file with your own code.

public class SpreadsheetLocation implements Location
{// B3 =>col =1 row=2
    private String cellName;
    private char cellChar;

    public SpreadsheetLocation(String cellName)//"B11"
    {
        this.cellName = cellName;
        cellChar = cellName.charAt(0);
    }
    
    @Override
    public int getRow()
    {
        if (cellName.length()>1)
        {
            int row = Integer.parseInt(cellName.substring(1));
            return row-1;
        }
        return -1;
    }

    @Override
    public int getCol()
    {
        int colInt = (int) cellChar;
        
        // TODO Auto-generated method stub
        return (colInt - 97);
    }

}
