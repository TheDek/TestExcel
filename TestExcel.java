import java.io.FileNotFoundException;
import java.util.Scanner;
// Update this file with your own code.

public class TextExcel 
{

    public static void main(String[] args) 
    {
        // Instantiate the Helper class correctly
        TestsAll.Helper h = new TestsAll().new Helper();
        // System.out.println(h.getText());

        Spreadsheet s = new Spreadsheet();
        boolean active = true;
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        while (active) 
        {
            System.out.println("What would you like to do?\n0: quit\n1: process command");
            answer = Integer.parseInt(sc.nextLine());
            if (answer == 0) 
            {
                active = false;
            }
            else if(answer == 1)
            {
                String command = sc.nextLine();
                System.out.println(s.processCommand(command));
            }
        }
        System.out.println(s.getGridText());
        sc.close();
    }
}
