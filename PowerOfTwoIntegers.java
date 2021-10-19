public class PowerOfTwoIntegers {
    public static void main(String[] args) {
        System.out.println("Is Power Of Two Integers"+isPowerOfTwo(4));
        System.out.println("Is Power Of Two Integers"+isPowerOfTwo(3));

    }

    public static boolean isPowerOfTwo(int A) {

        if(A==1) return true;
        for (int i = 2; i * i <= A; i++) {
            int p = A;
            while (p % i == 0) {
                p /=  i;
            }
            if (p == 1) {
                return true;
            }

        }
        return false;
    }
}

