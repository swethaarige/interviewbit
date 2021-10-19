public class DebuggingProblem {
    public static void main(String[] args) {
        int [] A={1,1,1,1,1,0};
        int [] B={0,0,0,0,0,1};


        int result1=testcode(A);
        System.out.println("TestCode answer1"+result1);
        int result2=testcode(B);
        System.out.println("TestCode answer2"+result2);

    }
    public static int testcode(int[] A) {
        int n = A.length;
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1]) {
                result = result + 1;
            }
        }
        int r = 0;
        System.out.println("result" + result);
        for (int j = 1; j < n; j++) {

            int count = 0;
                if (A[j - 1] != A[j]) {
                    count = count + 1;
                } else {
                    count = count - 1;
                }

            if (j < n - 1) {
                if (A[j + 1] != A[j]) {

                    count = count + 1;
                } else {
                    count = count - 1;
                }
            }
            System.out.println("count,r" + count + "And" + r);
            r = Math.max(r, count);
            System.out.println("r" + r);

        }
        return result + r;
    }
}
