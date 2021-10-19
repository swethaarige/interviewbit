public class ExcelColumnTitle {
    public static void main(String[] args) {
        System.out.print("Print STring"+printString(51));
    }


    // Function to print Excel column
    // name for a given column number
    private static String printString(int columnNumber)
    {
        // To store result (Excel column name)
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0)
        {
            // Find remainder
            int rem = columnNumber % 26;
            System.out.println("test"+(1%26));
            System.out.println("Remainder"+rem);

            // If remainder is 0, then a
            // 'Z' must be there in output
            if (rem == 0)
            {
                columnName.append("Z");
                columnNumber = (columnNumber / 26) - 1;
                System.out.println("ColumnNumber in reminaider 0 block"+columnNumber);
            }
            else // If remainder is non-zero
            {
                columnName.append((char)((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
                System.out.println("ColumnNumber in reminaider Non 0 block"+columnNumber);
            }
            System.out.println(columnName.reverse());
        }
        return columnName.toString();
        // Reverse the string and print result

    }

}
