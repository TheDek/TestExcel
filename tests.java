// // ALL TESTS FOR CP3

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.params.ParameterizedTest;
// import org.junit.jupiter.params.provider.CsvSource;
// import static org.junit.Assert.*;

// class JUnitExampleTest {
// /*    @Test
//     @DisplayName("Fail Test")
//     void failTest() {
//         assertEquals(2, 3);
//     }

//     @Test
//     @DisplayName("Pass Test")
//     void passTest() {
//         assertEquals("Hello", "Hello");
//     }
//     */
//  public static class Helper {
//     // For use only by test code, which uses it carefully.
//     private String[][] items;

//     public Helper() {
//       items = new String[20][12];
//       for (int i = 0; i < 20; i++)
//         for (int j = 0; j < 12; j++)
//           items[i][j] = format("");
//     }

//     public static String format(String s) {
//       return String.format(String.format("%%-%d.%ds", 10, 10), s);
//     }

//     public void setItem(int row, int col, String text) {
//       items[row][col] = format(text);
//     }

//     public String getText() {
//       String ret = "   |";
//       for (int j = 0; j < 12; j++)
//         ret = ret + format(Character.toString((char) ('A' + j))) + "|";
//       ret = ret + "\n";
//       for (int i = 0; i < 20; i++) {
//         ret += String.format("%-3d|", i + 1);
//         for (int j = 0; j < 12; j++) {
//           ret += items[i][j] + "|";
//         }
//         ret += "\n";
//       }
//       return ret;
//     }
//   }
//   // @Before

//   public static void setUpBeforeClass() throws Exception {
//   }
//   // CheckPoint 1
//     @Test
//     @DisplayName("testGetCols")
//     public void testGetCols() {
//     // Failure message:
//     // getCols doesn't return the right number of columns (10)
//     Spreadsheet grid = new Spreadsheet();
//     assertEquals( 12, grid.getCols(),"getCols doesn't return the right number of columns (12)");
//   }

//     @Test
//     @DisplayName("testGetRows")
//     public void testGetRows() {
//     // Failure message:
//     // getRows doesn't return the right number of rows (15)
//     Spreadsheet grid = new Spreadsheet();
//     assertEquals(20, grid.getRows(),"getRows doesn't return the right number of columns (20)");
//   }

//     @Test
//     @DisplayName("testProcessCommand1")
//     public void testProcessCommand1() {
//     // Failure message:
//     // output from empty command should be ""

//     Spreadsheet grid = new Spreadsheet();
//     String str = grid.processCommand("");
//     assertEquals( str, "","output from empty command should be \"\"");
//   }

//     @Test
//     @DisplayName("testProcessCommandNonliteralEmpty")
//     public void testProcessCommandNonliteralEmpty() {
//     // Failure message:
//     // output from empty command " " should be ""
//     Spreadsheet grid = new Spreadsheet();
//     String input = " ".trim();
//     String output = grid.processCommand(input);
//     assertEquals("", output,"output from empty command \" \" should be \"\"");
//   }

//     @Test
//     @DisplayName("testLongShortStringCell1")
//     public void testLongShortStringCell1() {
//     // Failure message:
//     // for "L20" the column of a SpreadsheetLocation return 11
//     // for "L20" the row of a SpreadsheetLocation return 19
//     // for "D5" the column of a SpreadsheetLocation return 3
//     // for "L20" the row of a SpreadsheetLocation return 4
//     // for "A1" the column of a SpreadsheetLocation return 0
//     // for "A1" the row of a SpreadsheetLocation return 0
//     SpreadsheetLocation loc = new SpreadsheetLocation("L20");
//     assertEquals( loc.getCol(), 11,"for L20 the column of a SpreadsheetLocation return 11");
//     assertEquals( loc.getRow(), 19,"for L20 the row of a SpreadsheetLocation return 19");

//     loc = new SpreadsheetLocation("D5");
//     assertEquals(3, loc.getCol(),"for D5 the column of a SpreadsheetLocation return 3");
//     assertEquals(4, loc.getRow(),"for D5 the row of a SpreadsheetLocation return 4");

//     loc = new SpreadsheetLocation("A1");
//     assertEquals( 0,loc.getCol(),"for A1 the column of a SpreadsheetLocation return 0");
//     assertEquals(0, loc.getRow(),"for A1 the column of a SpreadsheetLocation return 0");
//   }
//   @Test
//   public void testShortStringCell() {
//     // Failure message:
//     // after A1 = "Hello",
//     // location should be (0,0),
//     // the abbreviatedCellText should be equal "hello"
//     // the fullCellText should be equal "hello"
//     Spreadsheet grid = new Spreadsheet();
//     String hello = "Hello";
//     grid.processCommand("A1 = \"" + hello + "\"");
//     Cell helloCell = grid.getCell(new SpreadsheetLocation("A1"));
//     assertEquals( Helper.format(hello), helloCell.abbreviatedCellText(),"after A1 = \"Hello\", location should be (0,0), the abbreviatedCellText should be equal \"hello\"");
//     assertEquals("\"" + hello + "\"", helloCell.fullCellText(),"after A1 = \"Hello\",location should be (0,0),the fullCellText should be equal \"hello\"");
//   }

//   @Test
//   public void testLongStringCellNoSpaces() {
//     // Failure message:
//     // after L2 = "greeting",
//     // location should be (1,11),
//     // the abbreviatedCellText should be equal ThisIsALon
//     // the fullCellText should be equal to "ThisIsALongString"
//     Spreadsheet grid = new Spreadsheet();
//     String greeting = "ThisIsALongString";
//     grid.processCommand("L2 = \"" + greeting + "\"");
//     Cell greetingCell = grid.getCell(new SpreadsheetLocation("L2"));
//     assertEquals( Helper.format(greeting), greetingCell.abbreviatedCellText(),"after L2 = \"greeting\",location should be (1,11),the abbreviatedCellText should be equal \"ThisIsALon\"");
//     assertEquals( "\"" + greeting + "\"", greetingCell.fullCellText(),"after L2 = \"greeting\",location should be (1,11),the abbreviatedCellText should be equal to \"ThisIsALongString\"");
//   }

//   @Test
//   public void testLowerCaseCellProcessInspection() {
//     // Failure message:
//     // after B2 = "", and b2 and c18 = "3.1410"
//     // the return of processCommand("c18") should be equal ""3.1410"
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("B2 = \"\"");
//     String processText = grid.processCommand("b2");
//     assertEquals( "\"\"", processText,"after B2 = \"\", the result of processCommand(\"b2\") should be \"\"");
//     grid.processCommand("c18 = \"3.1410\"");
//     String processText2 = grid.processCommand("c18");
//     assertEquals( "\"3.1410\"", processText2,"after c18 = \"3.1410\", the return of processCommand(\"c18\") should be equal \"3.1410\"");
//   }

//   @Test
//   public void testClearLocation() {
//     // Failure message:
//     // After A1 = "first"
//     // testing locatio is (0,0)
//     // After D8 = "second"
//     // testing location is (7,3)
//     // After clear A1
//     // testing fullCellText of A1 is equal to ""
//     // testing fullCellText of D8 is equal to "second"
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("A1 = \"first\"");
//     grid.processCommand("D8 = \"second\"");
//     grid.processCommand("clear A1");
//     Cell cellFirst = grid.getCell(new SpreadsheetLocation("A1"));
//     Cell cellSecond = grid.getCell(new SpreadsheetLocation("D8"));

//     assertTrue("After A1 = \"first\",cellFirst inspection text after clear","".equals(cellFirst.fullCellText()));
//     assertTrue("After D8 = \"second\" testing fullCellText of D8 is equal to \"second\"","\"second\"".equals(cellSecond.fullCellText()));

//   }

//   @Test
//   public void testProcessCommandSpecialStrings() {
//     // Failure message:
//     // Testing B7 = "A1 = ( avg A2-A3 )"
//     // Testing F13 = "A1 = ( 1 * 2 / 1 + 3 - 5 )"
//     // Testing B7 fullCellText is A1 = ( avg A2-A3 )
//     // Testing F13 fullCellText is A1 = ( 1 * 2 / 1 + 3 - 5 )
//     Spreadsheet grid = new Spreadsheet();
//     String stringSpecial1 = "A1 = ( avg A2-A3 )";
//     String stringSpecial2 = "A1 = ( 1 * 2 / 1 + 3 - 5 )";
//     Helper helper = new Helper();
//     String grid1 = grid.processCommand("B7 = \"" + stringSpecial1 + "\"");
//     helper.setItem(6, 1, stringSpecial1);
//     assertEquals( helper.getText(), grid1,"Testing F13 = \"A1 = ( 1 * 2 / 1 + 3 - 5 )\"");
//     String grid2 = grid.processCommand("F13 = \"" + stringSpecial2 + "\"");
//     helper.setItem(12, 5, stringSpecial2);
//     assertEquals( helper.getText(), grid2,"Testing the grid after B7 = \"A1 = ( avg A2-A3 )\" and F13 = \"A1 = ( 1 * 2 / 1 + 3 - 5 )\"");
//     String inspectedSpecial1 = grid.getCell(new SpreadsheetLocation("B7")).fullCellText();
//     assertEquals( "\"" + stringSpecial1 + "\"", inspectedSpecial1,"Testing B7 fullCellText is A1 = ( avg A2-A3 )");
//     String inspectedSpecial2 = grid.getCell(new SpreadsheetLocation("F13")).fullCellText();
//     assertEquals("\"" + stringSpecial2 + "\"", inspectedSpecial2,"Testing F13 fullCellText is A1 = ( 1 * 2 / 1 + 3 - 5 )");
//   }

//   @Test
//   public void testClear() {
//     // Failure message:
//     // Adding A1 = "first"
//     // Adding D8 = "second"
//     // After clear, A1 and D8 should be empty.
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("A1 = \"first\"");
//     grid.processCommand("D8 = \"second\"");
//     grid.processCommand("clear");
//     Cell cellFirst = grid.getCell(new SpreadsheetLocation("A1"));
//     Cell cellSecond = grid.getCell(new SpreadsheetLocation("D8"));
//     assertEquals( "", cellFirst.fullCellText(),"Adding A1 = \"first\"  After clear, A1 should be empty.");
//     assertEquals( "", cellSecond.fullCellText(),"Adding D8 = \"second\" After clear, D8 should be empty.");

//   }
//  @Test
//   public void testEmptyGridText() {
//     // Failure message:
//     // Testing is the spreadsheet is empty.
//      Spreadsheet grid = new Spreadsheet();
//   Helper helper = new Helper();
//     assertEquals( helper.getText(), grid.getGridText()," Testing the grid is empty");
//   }
//   @Test
//   public void testEmptySpreadSheet () {
//     // Failure message:
//     // Testing is the spreadsheet is empty.
//     Spreadsheet grid = new Spreadsheet();
//     Helper helper = new Helper();
//     assertEquals( helper.getText(), grid.getGridText(),"Testing if the spreadsheet is empty");
//   }

//   @Test
//   public void testEmptyStringCell() {
//     // Failure message:
//     // Adding B2 = ""
//     // Testing B2 abbreviatedCellText is ""
//     // Testing B2 fullCellText is ""
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("B2 = \"\"");
//     Cell emptyStringCell = grid.getCell(new SpreadsheetLocation("B2"));
//     assertEquals( Helper.format(""), emptyStringCell.abbreviatedCellText(),"Adding B2 = \"\" Testing B2 abbreviatedCellText is \"\"");
//     assertEquals("\"\"", emptyStringCell.fullCellText(),"Adding B2 = \"\" Testing B2 fullCellText is \"\"");

//   }

//   @Test
//   public void testProcessCommand2() {
//     // Failure message:
//     // After A1 = "oNe", Testing the getGridText()
//     // After L20 = "TWo", Testing the getGridText()
//     // After clear A1, Testing there is only one cell field.
//     // After clear, Testing if the spreadsheet is empty.
//     Spreadsheet grid = new Spreadsheet();
//     Helper helper = new Helper();
//     String gridOne = grid.processCommand("A1 = \"oNe\"");
//     helper.setItem(0, 0, "oNe");
//     assertEquals( helper.getText(), gridOne,"After A1 = \"oNe\", Testing the getGridText()");
//     String accessorOne = grid.getGridText();
//     assertEquals( helper.getText(), accessorOne,"After A1 = \"oNe\", Testing the getGridText()");
//     String gridTwo = grid.processCommand("L20 = \"TWo\"");
//     helper.setItem(19, 11, "TWo");
//     assertEquals( helper.getText(), gridTwo,"After L20 = \"TWo\", Testing the getGridText()");
//     String gridOnlyTwo = grid.processCommand("clear A1");
//     helper.setItem(0, 0, "");
//     assertEquals( helper.getText(), gridOnlyTwo,"After clear A1, Testing there is only one cell field.");
//     String gridEmpty = grid.processCommand("clear");
//     helper.setItem(19, 11, "");
//     assertEquals(helper.getText(), gridEmpty,"After clear, Testing if the spreadsheet is empty.");
//   }

 

//   @Test
//   public void testProcessCommandInspection() {
//     // Failure message:
//     // inspection of empty cell A1 should be empty
//     // After A1 = "first", inspection of A1 should be "first"
//     Spreadsheet grid = new Spreadsheet();
//     String empty = grid.processCommand("A1");
//     assertEquals("", empty,"inspection of empty cell A1 should be empty");
//     grid.processCommand("A1 = \"first\"");
//     String first = grid.processCommand("A1");
//     assertEquals("\"first\"", first,"After A1 = \"first\", inspection of A1 should be \"first\"");

//   }

//   @Test
//   public void testMixedCaseClear() {
//     // Failure message:
//     // After A1 = "first" and D8 = "second" and the command CleaR the 2 cells A1 and
//     // D8 should be empty
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("A1 = \"first\"");
//     grid.processCommand("D8 = \"second\"");
//     grid.processCommand("CleaR");
//     Cell cellFirst = grid.getCell(new SpreadsheetLocation("A1"));
//     Cell cellSecond = grid.getCell(new SpreadsheetLocation("D8"));
//     assertEquals( "", cellFirst.fullCellText(),"After A1 = \"first\" and D8 = \"second\" and the command CleaR the cell A1 should be empty");
//     assertEquals( "", cellSecond.fullCellText(),"After A1 = \"first\" and D8 = \"second\" and the command CleaR the cell D8 should be empty");

//   }

//   @Test
//   public void textNonliteralClear() {
//     // Failure message:
//     // After A1 = "first" and D8 = "second" and the command clear the whole grid
//     // should be empty. Testing by checking getGridText against Helper
//     Spreadsheet grid = new Spreadsheet();
//     String clear = " clear ".trim();
//     grid.processCommand("A1 = \"first\"");
//     grid.processCommand("D8 = \"second\"");
//     grid.processCommand(clear);
//     Cell cellFirst = grid.getCell(new SpreadsheetLocation("A1"));
//     Cell cellSecond = grid.getCell(new SpreadsheetLocation("D8"));
//     assertEquals( "", cellFirst.fullCellText(),"After A1 = \"first\" and D8 = \"second\" and the command clear, A1 should be empty");
//     assertEquals("", cellSecond.fullCellText(),"After A1 = \"first\" and D8 = \"second\" and the command clear, D8 should be empty" );
//     String finalGrid = grid.getGridText();
//     Helper th = new Helper();
//     String emptyGrid = th.getText();
//     assertEquals(emptyGrid, finalGrid,"After A1 = \"first\" and D8 = \"second\" and the command clear the whole grid should be empty");
//   }

//   @Test
//   public void testProcessCommandMoreSpecialStrings() {
//     // Failure message:
//     // testing the A16 = with every element
//     // from { "clear", "(", " = ", "5", "4.3", "12/28/1998", "A1 = ( 1 / 1 )",
//     // "A20 = 1/1/2000", "A9 = 4.3", "abcdefgh", "abcdefghi", "abcdefghijk" }
//     Spreadsheet grid = new Spreadsheet();
//     String[] specialStrings = new String[] { "clear", "(", " = ", "5", "4.3", "12/28/1998", "A1 = ( 1 / 1 )",
//         "A20 = 1/1/2000", "A9 = 4.3", "abcdefgh", "abcdefghi", "abcdefghijk" };

//     Helper helper = new Helper();
//     System.out.println("Testing...");
//     for (int col = 0; col < specialStrings.length; col++) {
//       for (int row = 5; row < 20; row += 10) {
//         String cellName = Character.toString((char) ('A' + col)) + (row + 1);
//         helper.setItem(row, col, specialStrings[col]);
//         System.out.println("Testing:\""+specialStrings[col]+"\"");
//         String sheet = grid.processCommand(cellName + " = \"" + specialStrings[col] + "\"");
//         assertEquals( helper.getText(), sheet,"testing the A16 = with every element from { \"clear\", \"(\", \" = \", \"5\", \"4.3\", \"12/28/1998\", \"A1 = ( 1 / 1 )\", \"A20 = 1/1/2000\", \"A9 = 4.3\", \"abcdefgh\", \"abcdefghi\", \"abcdefghijk\"");
//         String loc = ""+ (char)(col+65) + (row+1);
//         String inspected = grid.getCell(new SpreadsheetLocation(loc)).fullCellText();
//         assertEquals( "\"" + specialStrings[col] + "\"", inspected,"testing the A16 = with every element from { \"clear\", \"(\", \" = \", \"5\", \"4.3\", \"12/28/1998\", \"A1 = ( 1 / 1 )\", \"A20 = 1/1/2000\", \"A9 = 4.3\", \"abcdefgh\", \"abcdefghi\", \"abcdefghijk\"");
//       }
//     }
//     assertEquals( helper.getText(), grid.getGridText(),"testing the A16 = with every element from { \"clear\", \"(\", \" = \", \"5\", \"4.3\", \"12/28/1998\", \"A1 = ( 1 / 1 )\", \"A20 = 1/1/2000\", \"A9 = 4.3\", \"abcdefgh\", \"abcdefghi\", \"abcdefghijk\"");

//   }

//   @Test
//   public void testLowerCaseCellAssignment() {
//     // Failure message:
//     // testing with b5 = "Cell", B5 should return "Cell"
//     Spreadsheet grid = new Spreadsheet();
//     String text = "Cell";
//     grid.processCommand("b5 = \"" + text + "\"");
//     Cell cell = grid.getCell(new SpreadsheetLocation("B5"));
//     assertEquals( Helper.format(text), cell.abbreviatedCellText(),"testing with b5 = \"Cell\", abbreviatedCellText should be \"Cell\"");
//     assertEquals( "\"" + text + "\"", cell.fullCellText());
//     String processText = grid.processCommand("b5");
//     assertEquals( "\"" + text + "\"", processText,"testing with b5 = \"Cell\", processCommand(\"b5\") should return \"Cell\"");
//     String processText2 = grid.processCommand("B5");
//     assertEquals( "\"" + text + "\"", processText2,"testing with b5 = \"Cell\", processCommand(\"B5\") should return \"Cell\"");

//   }

//   @Test
//   public void testLongShortStringCell() {
//     // Failure message:
//     // Testing with L20 = "Hello, world!" position 19,11
//     // abbreviatedCellText =>Hello, wor
//     // fullCellText=> "Hello, world!"
//     Spreadsheet grid = new Spreadsheet();
//     String greeting = "Hello, world!";
//     grid.processCommand("L20 = \"" + greeting + "\"");
//     Cell greetingCell = grid.getCell(new SpreadsheetLocation("L20"));
//     assertEquals( Helper.format(greeting), greetingCell.abbreviatedCellText(),"Testing with L20 = \"Hello, world!\" position 19,11 abbreviatedCellText should return Hello, wo");
//     assertEquals( "\"" + greeting + "\"", greetingCell.fullCellText(),"Testing with L20 = \"Hello, world!\" position 19,11 fullCellText should return \"Hello, world!\"");

//   }

//   @Test
//   public void testEmptyGridCells() {
//     // Failure message:
//     // Testing if the whole grid is empty
//     Spreadsheet grid = new Spreadsheet();
//     for (int i = 0; i < grid.getRows(); i++)
//       for (int j = 0; j < grid.getCols(); j++) {
//         String loc = ""+ (char)(j+65) + (i+1);
//         Cell cell = grid.getCell(new SpreadsheetLocation(loc));
//         assertEquals( Helper.format(""), cell.abbreviatedCellText(),"Testing if the whole grid is empty");
//         assertEquals( "", cell.fullCellText(),"Testing if the whole grid is empty");
//       }
//   }

//   @Test
//   public void testMixedCaseClearLocation() {
//     String msg="After A18 = \"first\" and D8 = \"second\" and clEAr a18, A18 should be empty";
//     // and D8 should have "second" in it.
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("A18 = \"first\"");
//     grid.processCommand("D8 = \"second\"");
//     grid.processCommand("clEAr a18");
//     Cell cellFirst = grid.getCell(new SpreadsheetLocation("A18"));
//     Cell cellSecond = grid.getCell(new SpreadsheetLocation("D8"));
//     String sec ="\"second\"";
//     assertTrue(msg, "".equals(cellFirst.fullCellText()));
    
//     assertEquals(true, "".equals(cellFirst.fullCellText()),msg);
//     assertEquals(true, "\"second\"".equals(cellSecond.fullCellText()),msg);
//     //assertTrue("\"second\"".equals(cellSecond.fullCellText()));

//     String processedCleared = grid.processCommand("A18");
//     //assertTrue("".equals(processedCleared));

//     assertEquals(true, "".equals(processedCleared),msg);

//   }


//   @Test
//   public void testDifferentCellTypes() {
//     // Failure message:
//     // After C11 = "hi"
//     // The cell at position 10, 2, shouldn't be empty.
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("C11 = \"hi\"");
//     Cell stringCell = grid.getCell(new SpreadsheetLocation("C11"));
//     Cell emptyCell = grid.getCell(new SpreadsheetLocation("A1"));
//     assertTrue("string cell implementation class must be different from empty cell",
//         !emptyCell.getClass().equals(stringCell.getClass()));

//   }



//   // CheckPoint 3
//   @Test
//   public void testPercentCell() {
//     String percent = "11.25%";
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("A1 = " + percent);
//     Cell dateCell = grid.getCell(new SpreadsheetLocation("A1"));
//     assertEquals("11%", dateCell.abbreviatedCellText().trim(),"After A1 = 11.25% checking abbreviatedCellText");
//     assertEquals( "0.1125", dateCell.fullCellText(),"After A1 = 11.25% checking fullCellText");
//   }

//   @Test
//   public void testBasicRealCell() {
//     String real = "3.14";
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("D18 = " + real);
//     Cell realCell = grid.getCell(new SpreadsheetLocation("D18"));
//     assertEquals(Helper.format(real), realCell.abbreviatedCellText(),"After D18 = 3.14 checking abbreviatedCellText");
//     assertEquals( real, realCell.fullCellText(),"After D18 = 3.14 checking fullCellText");
//   }

//   @Test
//   public void testMoreRealCells() {
//     String zero = "0.0";
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("A1 = " + zero);
//     Cell zeroCell = grid.getCell(new SpreadsheetLocation("A1"));
//     assertEquals(Helper.format(zero), zeroCell.abbreviatedCellText(),"After A1 = 0.0 checking real cell abbreviatedCellText");
//     assertEquals(zero, zeroCell.fullCellText(),"After A1 = 0.0 checking real cell fullCellText");
//     String negativeTwo = "-2.0";
//     grid.processCommand("B1 = " + negativeTwo);
//     Cell negativeTwoCell = grid.getCell(new SpreadsheetLocation("B1"));
//     assertEquals( Helper.format(negativeTwo), negativeTwoCell.abbreviatedCellText(),"After B1 = -2.0 checking real cell abbreviatedCellText");
//     assertEquals(negativeTwo, negativeTwoCell.fullCellText(),"After B1 = -2.0 checking real cell fullCellText");
//   }

//   @Test
//   public void testDifferentCellTypes2() {
//     Spreadsheet grid = new Spreadsheet();
//     grid.processCommand("H4 = 12.281998%");
//     grid.processCommand("G3 = \"5\"");
//     grid.processCommand("F2 = -123.456");
//     /*
//             Cell dateCell = grid.getCell(new TestLocation(3, 7));
//             Cell stringCell = grid.getCell(new TestLocation(2, 6));
//             Cell realCell = grid.getCell(new TestLocation(1, 5));
//             Cell emptyCell = grid.getCell(new TestLocation(0, 4));
//     */
//     Cell stringCell = grid.getCell(new SpreadsheetLocation("G3"));
//     Cell realCell = grid.getCell(new SpreadsheetLocation("F2"));
//     Cell emptyCell = grid.getCell(new SpreadsheetLocation("E1"));
//     Cell[] differentCells = {stringCell, realCell, emptyCell };
//     for (int i = 0; i < differentCells.length - 1; i++) {
//       for (int j = i + 1; j < differentCells.length; j++) {
//         assertTrue("percent H4 = 12.281998%, string G3 = \"5\", real F2 = -123.456, empty cells must all have different class types",
//             !differentCells[i].getClass().equals(differentCells[j].getClass()));
//       }
//     }
//   }

//   @Test
//   public void testProcessCommand3() {
//     Helper helper = new Helper();
//     Spreadsheet grid = new Spreadsheet();
//     String first = grid.processCommand("A1 = 1.021822%");
//     helper.setItem(0, 0, "1%");
//     assertEquals( helper.getText(), first,"A1 = 1.021822% checking the grid");
//     String second = grid.processCommand("B2 = -5");
//     helper.setItem(1, 1, "-5.0");
//     assertEquals( helper.getText(), second,"B2 = -5 checking the grid");
//     String third = grid.processCommand("C3 = 2.718");
//     helper.setItem(2, 2, "2.718");
//     assertEquals( helper.getText(), third,"C3 = 2.718 checking the grid");
//     String fourth = grid.processCommand("D4 = 0");
//     helper.setItem(3, 3, "0.0");
//     assertEquals( helper.getText(), fourth,"D4 = 0.0 checking the grid");
//   }

//   @Test
//   public void testRealCellFormat() {
//     // NOTE spec not totally consistent on inspection format, allow anything that
//     // parses to within epsilon of as entered
//     Spreadsheet grid = new Spreadsheet();
//     String[] realsEntered = { "3.00", "-74.05000", "400", "400.0" };
//     String[] realsFormatted = { "3.0       ", "-74.05    ", "400.0     ", "400.0     " };
//     Helper helper = new Helper();
//     for (int col = 0; col < realsEntered.length; col++) {
//       for (int row = 6; row < 20; row += 10) {
//         String cellName = Character.toString((char) ('A' + col)) + (row + 1);
//         String sheet = grid.processCommand(cellName + " = " + realsEntered[col]);
//         helper.setItem(row, col, realsFormatted[col]);
//         assertEquals( helper.getText(), sheet,"sheet after setting cell " + cellName);
//         String loc = "" + (char)(col+65) + (row+1);
//         String inspected = grid.getCell(new SpreadsheetLocation(loc)).fullCellText();
//         double expected = Double.parseDouble(realsEntered[col]);
//         double actual = Double.parseDouble(inspected);
//         assertEquals( actual, expected, 1e-6,"inspected real value 3.00, -74.05000, 400, 400.0");
//       }
//     }
//     assertEquals(helper.getText(), grid.getGridText(),"inspecting the grid after adding 3.00, -74.05000, 400, 400.0");
//   }

//   @Test
//   public void testRealCellTruncation() {
//     Spreadsheet grid = new Spreadsheet();
//     String big = "-9876543212345";
//     grid.processCommand("A1 = " + big);
//     Cell bigCell = grid.getCell(new SpreadsheetLocation("A1"));
//     assertEquals(10, bigCell.abbreviatedCellText().length(),"inspected  abbreviatedCellText length of real value A1 = -9876543212345 should be 10");
//     assertEquals(Double.parseDouble(big), Double.parseDouble(bigCell.fullCellText()), 1e-6,"inspected real value A1 = -9876543212345 should be "+ Double.parseDouble(big));

//     String precise = "3.14159265358979";
//     grid.processCommand("A2 = " + precise);
//     Cell preciseCell = grid.getCell(new SpreadsheetLocation("A2"));
//     assertEquals(10, preciseCell.abbreviatedCellText().length(),"inspected  abbreviatedCellText length of real value A2 = 3.14159265358979 should be 10");
//     assertEquals(Double.parseDouble(precise), Double.parseDouble(preciseCell.abbreviatedCellText()), 1e-6,"inspected of real value A2 = 3.14159265358979 should be "+Double.parseDouble(precise));
//     assertEquals(Double.parseDouble(precise),Double.parseDouble(preciseCell.fullCellText()), 1e-6,"inspected  abbreviatedCellText  of real value A2 = 3.14159265358979 should be "+Double.parseDouble(precise));

//     String moderate = "123456";
//     grid.processCommand("A3 = " + moderate);
//     Cell moderateCell = grid.getCell(new SpreadsheetLocation("A3"));
//     assertEquals(10, moderateCell.abbreviatedCellText().length(),"inspected  abbreviatedCellText length of real value A3 = 123456 should be 10");
//     assertEquals( moderate + ".0", moderateCell.abbreviatedCellText().trim(),"inspected  abbreviatedCellText of real value A3 = 123456 should be "+moderate + ".0");
//     assertEquals(moderate, moderateCell.fullCellText(),"inspected  fullCellText of real value A3 = 123456 should be "+moderate);

//     String precisePerc = "7.87878%";
//     grid.processCommand("A4 = " + precisePerc);
//     Cell precisePerCell = grid.getCell(new SpreadsheetLocation("A4"));
//     assertEquals( 10, precisePerCell.abbreviatedCellText().length(),"inspected  abbreviatedCellText length of real value A4 = 7.87878% should be 10");
//     assertEquals( "7%", precisePerCell.abbreviatedCellText().trim(),"inspected  abbreviatedCellText  of real value A4 = 7.87878% should be 7%");
//     assertEquals( "0.0787878", precisePerCell.fullCellText(),"inspected fullCellText length of real value A4 = 7.87878% should be 0.0787878");
//   }
 
// }
