public class ExcelColumnNumber {
    public static void main(String[] args) {
        System.out.print(titleToNumber("CDA"));
    }

    // Returns resul when we pass title.
   public static int titleToNumber(String s)
    {
        // This process is similar to
        // binary-to-decimal conversion
        int result = 0;
        for (int i = 0; i < s.length(); i++)
        {
            System.out.println("s.charAt(i)"+s.charAt(i));

            result *= 26;
            result += s.charAt(i)-'A' + 1;
            System.out.println("result"+result);

        }
        return result;
    }
}
