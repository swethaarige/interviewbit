import java.util.ArrayList;

public class TrailingZeroesInFactorial {
    public static void main(String[] args){
        System.out.println("Trailing Zeroes"+trailingZeroes(5));
        System.out.println("Trailing Zeroes"+trailingZeroes(10));
        ArrayList<Integer> list=new ArrayList<>(2);
        list.add(0);list.add(1);
        ArrayList<Integer> list2=new ArrayList<>(3);
        list2.add(1);list2.add(2);list2.add(2);list2.add(1);
        ArrayList<Integer> rearrangedArray=arrangeArray(list2);
        for(int i=0;i<rearrangedArray.size();i++)
        System.out.println("arranged Array"+rearrangedArray.get(i));

    }
    public static int trailingZeroes(int A){
        int temp=5;
        int count=0;
        while(A/temp!=0){
            count+=A/temp;
            temp=temp*5;
        }
        return count;
    }
    public static  ArrayList<Integer> arrangeArray(ArrayList<Integer> A){
        int n=A.size();
        for (int i = 0; i < n; i++) A.set(i, A.get(i) + (A.get(A.get(i)) % n) * n );
        for (int i = 0; i < n; i++) A.set(i, A.get(i) / n);
        return A;
    }
}
