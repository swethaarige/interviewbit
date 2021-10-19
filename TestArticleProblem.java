import java.text.ParseException;

public class TestArticleProblem {
    public static void main(String[] args) {
        ArticleETAProblem articleETAProblem = new ArticleETAProblem();
        String S1 = "20181109 at 08.30.45AM";
        String S2="20181109 at 2.00.30PM";
        String S3="20181109 at 2.00.30AM";
        int[] BB = {0, 1};
        int[] CC = {0, 1};
        int[] DD={1,2};
        int[] EE={0,1};
        try {
            String[] output1 = articleETAProblem.solution(S1, BB, CC);
            System.out.println("EarliestDate" + output1[0]);
            System.out.println("LatestDate" + output1[1]);
            String[] output2 = articleETAProblem.solution(S2, DD, EE);
            System.out.println("EarliestDate" + output2[0]);
            System.out.println("LatestDate" + output2[1]);
            String[] output3 = articleETAProblem.solution(S3, BB,CC);
            System.out.println("EarliestDate" + output3[0]);
            System.out.println("LatestDate" + output3[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
