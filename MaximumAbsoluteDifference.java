import java.util.ArrayList;

public class MaximumAbsoluteDifference {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(3);
        A.add(1);
        A.add(3);
        A.add(-1);
        System.out.println("Maximum Absolute Value"+maxArr(A));

    }
        public  static int maxArr(ArrayList<Integer> A) {

        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++)
        {

            // Updating max and min variables
            // as described in algorithm.
            max1 = Math.max(max1, A.get(i) + i);
            min1 = Math.min(min1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) - i);
            min2 = Math.min(min2, A.get(i) - i);
        }

        // Calculating maximum absolute difference.
        return Math.max(max1 - min1, max2 - min2);

    }
}
