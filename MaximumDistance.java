import java.util.ArrayList;
import java.util.List;

public class MaximumDistance {
    public static void main(String[] args){
        List<Integer> A=new ArrayList<>(4);
        A.add(3);A.add(5);A.add(4);A.add(2);
        int maximumGap=maximumGap(A);
        System.out.println("Maximum Gap"+maximumGap);

    }

    public static int maximumGap(List<Integer> A){
        int maxDiff;
        int i,j;
        int n=A.size();
        int[] Lmin=new int[n];
        int[] Rmax=new int[n];
        Lmin[0]=A.get(0);
        for(i=1;i<n-1;i++){
            Lmin[i]=Math.min(A.get(i),Lmin[i-1]);

        }
        Rmax[n-1]=A.get(n-1);
        for(j=n-2;j>=0;--j){
            Rmax[j]=Math.max(A.get(j),Rmax[n-1]);
        }
        i=0;
        j=0;
        maxDiff=0;
        while(j<n &&i<n){
            if(Lmin[i]<=Rmax[j]){
                maxDiff=Math.max(maxDiff,j-i);
                j=j+1;
            }
            else{
                i=i+1;
            }

        }
        return maxDiff;

    }

}
