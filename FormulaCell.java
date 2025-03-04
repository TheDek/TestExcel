import java.util.ArrayList;

public class FormulaCell extends RealCell
{
    private Spreadsheet sheet;

    public FormulaCell(String input, Spreadsheet sheet)
    {
        super(input);
        this.sheet = sheet;
    }

    @Override
    public double getDoubleValue()
    {
        String formula = fullCellText().trim();
        
        if (formula.startsWith("(") && formula.endsWith(")"))
        {
            formula = formula.substring(1, formula.length() - 1).trim();
        }

        // Prevent infinite recursion if the formula references itself
        if (formula.contains(this.fullCellText()))
        {
            return 0.0;
        }

        String[] tokens = formula.split(" ");
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> ops = new ArrayList<>();

        for (int i = 0; i < tokens.length; i++)
        {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))
            {
                ops.add(token);
            }
            else
            {
                double val;
                if (Character.isLetter(token.charAt(0)))
                {
                    Cell refCell = sheet.getCell(new SpreadsheetLocation(token));
                    if (refCell instanceof RealCell)
                    {
                        val = ((RealCell) refCell).getDoubleValue();
                    }
                    else
                    {
                        val = 0.0;
                    }
                }
                else
                {
                    val = Double.parseDouble(token);
                }

                if (!ops.isEmpty() && (ops.get(ops.size() - 1).equals("*") || ops.get(ops.size() - 1).equals("/")))
                {
                    String op = ops.remove(ops.size() - 1);
                    double prevVal = values.remove(values.size() - 1);
                    val = op.equals("*") ? (prevVal * val) : (prevVal / val);
                }
                values.add(val);
            }
        }

        double result = values.get(0);
        int opIndex = 0;
        for (int i = 1; i < values.size(); i++)
        {
            String op = ops.get(opIndex++);
            if (op.equals("+"))
            {
                result += values.get(i);
            }
            else if (op.equals("-"))
            {
                result -= values.get(i);
            }
        }
        return result;
    }

    @Override
    public String abbreviatedCellText()
    {
        String text = Double.toString(getDoubleValue());

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
