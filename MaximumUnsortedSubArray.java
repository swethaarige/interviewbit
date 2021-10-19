import java.util.ArrayList;
import java.util.List;

public class MaximumUnsortedSubArray {
    public static void main(String[] args){
        ArrayList<Integer> A=new ArrayList<>(5);
        A.add(1);A.add(3);A.add(2);A.add(4);A.add(5);
        ArrayList<Integer> resultSubArray=subUnsort(A);
        System.out.println("maximumUnsortedSubArray"+resultSubArray);

    }
    public  static ArrayList<Integer> subUnsort(ArrayList<Integer> A){
        int i=0;int j=0;
        int n=A.size();
        int[] mins=new int[n];
        int[] maxs=new int[n];
        maxs[0]=A.get(0);
        for(i=1;i<n;i++){
        maxs[i]=Math.max(A.get(i),maxs[i-1]);
        }
        mins[n-1]=A.get(n-1);
        for(j=n-2;j>=0;j--){
            mins[j]=Math.min(A.get(j),mins[j+1]);
        }
        int start=0;
        int end=n-1;
        ArrayList<Integer> result=new ArrayList<>();
        while(start<n && mins[start]==A.get(start)){
            start++;
        }
        while(end>0 && maxs[end]==A.get(end)){
            end--;
        }
        if(start==n){
            result.add(new Integer(-1));
        }
        else{
            result.add(new Integer(start));
            result.add(new Integer(end));
        }

        return result;
    }

}
