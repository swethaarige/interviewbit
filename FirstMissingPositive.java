import java.text.ParseException;
import java.util.*;

public class FirstMissingPositive {

    public static void main(String[] args) {
        Solution articleETAProblem=new Solution();
        String S="2018.11.06 at 08.30.45AM";
        int[] BB={0,2};
        int[] CC={0,3};

        String S1="2018.11.09 at 02.30.45PM";
        int[] BB1={0,1};
        int[] CC1={1,3};
        try {
           String[] output= articleETAProblem.solution(S,BB,CC);
           System.out.println("EarliestDate for 1st test case"+output[0]);
            System.out.println("LatestDate for 1st test case"+output[1]);

            String[] output2= articleETAProblem.solution(S1,BB1,CC1);
            System.out.println("EarliestDate for 2nd test case"+output2[0]);
            System.out.println("EarliestDate for 2nd test case"+output2[1]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       /* ArrayList<Integer> A = new ArrayList<>(4);
        A.add(3);
        A.add(4);
        A.add(-1);
        A.add(1);
        ArrayList<Integer> B = new ArrayList<>(3);
        B.add(1);
        B.add(2);
        B.add(0);
        System.out.println("First Missing Postive in A" + firstMissingPositive(A));
        System.out.println("First Missing Postive in B" + firstMissingPositive(B));

        ArrayList<Integer> C = new ArrayList<>(5);
        C.add(1);
        C.add(2);
        C.add(3);
        C.add(3);
        C.add(5);
        ArrayList<Integer> missingAndRepeated = new ArrayList<>(2);
        missingAndRepeated = repeatedAndMissingNumbers(C);
        for (int i = 0; i < missingAndRepeated.size(); i++) {
            System.out.println("Repeated and missing numbers" + missingAndRepeated.get(i));
        }
        ArrayList<Integer> D = new ArrayList<Integer>(5);
        D.add(1);
        D.add(2);
        D.add(3);
        D.add(1);
        D.add(1);

        //int[] n = (int[])D.toArray(int[D.size()]);
        int[] nums=new int[D.size()];
        //nums= (int[])(D.toArray(int[D.size()]);
        //System.out.println("N/3 Repeated number" + N3RepeatedNumber(nums));*/


    }

    public static int firstMissingPositive(ArrayList<Integer> A) {
        int mx = 1;
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == mx) {
                mx = mx + 1;
            }
        }
        return mx;
    }

    public static ArrayList<Integer> repeatedAndMissingNumbers(List<Integer> A) {
        int size = A.size();
        long sumOfNumbers = getSumOfNumbers(size);
        long sumOfSquares = getSumOfSquares(size);
        long differenceOfSquares = getDifferenceOfSquares(A, sumOfSquares);
        long differenceOfNumbers = getDifferenceOfNumbers(A, sumOfNumbers);
        long sumNumber = differenceOfSquares / differenceOfNumbers;
        int repeatedNumber = (int) ((sumNumber + differenceOfNumbers) / 2);
        int missingInteger = (int) (sumNumber - repeatedNumber);

        ArrayList<Integer> result = new ArrayList<>(2);
        result.add(repeatedNumber);
        result.add(missingInteger);
        return result;
    }

    public static long getSumOfNumbers(double n) {
        return (long) (n * (n + 1) / 2);
    }

    public static long getSumOfSquares(double n) {
        return (long) (n * (n + 1) * (2 * n + 1) / 6);
    }

    public static long getDifferenceOfNumbers(List<Integer> A, long sumOfNumbers) {
        long sum = sumOfNumbers * -1;
        for (Integer i : A) {
            long num = (long) i;
            sum += num;
        }
        return sum;
    }

    public static long getDifferenceOfSquares(List<Integer> A, long sumofSquares) {
        long sum = sumofSquares * -1;
        for (Integer i : A) {
            long num = (long) i;
            sum += (num * num);
        }
        return sum;
    }

    public static int duplicateNumber(List<Integer> A) {
        Set<Integer> hs = new HashSet<>();
        for (Integer no : A) {
            if (!hs.add(no)) {
                return no;
            }

        }
        return -1;
    }

    public static List<Integer> N3RepeatedNumber(ArrayList<Integer> A) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                map.put(A.get(i), map.get(i) + 1);
            } else {
                map.put(A.get(i), 1);
            }
        }
        int count = A.size() / 3;
        List<Integer> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) > count) {
                result.add(key);
            }
        }
        return result;
    }

}
