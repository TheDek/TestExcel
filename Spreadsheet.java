// Update this file with your own code.

public class Spreadsheet implements Grid
{
    private int rows;
    private int columns;
    private Cell[][] sheet;
    public Spreadsheet()
    {
        rows = 20;
        columns = 12;
        sheet = new Cell[rows][columns];  
        for (int r = 0; r < rows; r++) 
        {
            for (int c = 0; c < columns; c++) 
            {
                sheet[r][c] = new EmptyCell();
            }
        }
    }

	@Override
    public String processCommand(String command)
    {
        if (command == null || command.trim().isEmpty()) 
        {
            return "";
        }
        
        String[] s = command.split(" ");
        if(s[0].toLowerCase().equals("clear"))
        {
            if (command.toLowerCase().equals("clear")) // "clear"
            {
                for (int r = 0; r < rows; r++) 
                {
                    for (int c = 0; c < columns; c++) 
                    {
                        sheet[r][c] = new EmptyCell();
                    }
                }
                return getGridText();
            }
            else // "clear A10" returns full text
            {
                command = command.substring(6);
                SpreadsheetLocation loc = new SpreadsheetLocation(command.toLowerCase());
                sheet[loc.getRow()][loc.getCol()] = new EmptyCell();
                return getGridText();
            }
        }
        else
        {
            if(s.length == 1) // "A10" returns full text
            {
                SpreadsheetLocation loc = new SpreadsheetLocation(command.toLowerCase());
                return sheet[loc.getRow()][loc.getCol()].fullCellText();
            }
            else if(command.indexOf("\"") > 1) // "A10 = "bob""
            {
                String[] arr = command.split("\"");
                SpreadsheetLocation loc = new SpreadsheetLocation(s[0].toLowerCase());
                if (arr.length > 1)
                {
                    Cell t = new TextCell(arr[1]);
                    sheet[loc.getRow()][loc.getCol()] = t;
                    return getGridText();
                }
                else
                {
                    Cell t = new TextCell("");
                    sheet[loc.getRow()][loc.getCol()] = t;
                    return getGridText();
                }
            }
            else
            {
                SpreadsheetLocation loc = new SpreadsheetLocation(s[0].toLowerCase());
                String valueString = s[2];
                
                if (valueString.substring(0,1).equals("("))
                {
                    sheet[loc.getRow()][loc.getCol()] = new FormulaCell("formula", this);
                    return getGridText(); 
                }
                else if(valueString.substring(valueString.length()-1).equals("%"))
                {
                    PercentCell t = new PercentCell(valueString);
                    sheet[loc.getRow()][loc.getCol()] = t;
                    return getGridText(); 
                }
                else
                {
                    ValueCell t = new ValueCell(valueString);
                    sheet[loc.getRow()][loc.getCol()] = t;
                    return getGridText(); 
                }
                
            }
        }
    }
	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return rows;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return columns;
	}

	@Override
	public Cell getCell(Location loc)
	{
	    int row = loc.getRow();
	    int column = loc.getCol();
	    
		return sheet[row][column];
	}

	@Override
	public String getGridText()
	{
		String fullText = "   ";
		for(char i = 'A'; i< 'A' + columns; i++)
		{
	        fullText += "|";
	        String cellText = i + "";
		    while(cellText.length()<10)
		    {
		        cellText += " ";
		    }
		    fullText += cellText;
		}
		fullText += "|";
		for(int j = 1; j<= 20; j++)
		{
		        
		        fullText += "\n";
		        String n = Integer.toString(j);
		        if(n.length() == 1)
		        {
		            fullText += (n + "  ");
		        }
		        else
		        {
		            fullText += (n + " ");
		        }
		        for(int column = 0; column<columns; column++)
		        {
    		        fullText += "|";
    		        fullText += sheet[j-1][column].abbreviatedCellText();
		        }
		        fullText += "|";
		}
		fullText += "\n";
		return fullText;
	}
}
