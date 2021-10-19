import java.util.ArrayList;
import java.util.Arrays;

public class SetZeroesMatrix {

    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> A=new ArrayList<ArrayList<Integer>>(3);
        A.add(new ArrayList<Integer>((Arrays.asList(1,0,1))));
        A.add(new ArrayList<Integer>((Arrays.asList(1,1,1))));
        A.add(new ArrayList<Integer>((Arrays.asList(1,1,1))));
        ArrayList<ArrayList<Integer>> zeroMatrix=new ArrayList<ArrayList<Integer>>(3);
        zeroMatrix=setZeroes(A);
        for(int i=0;i<zeroMatrix.size();i++){
            for(int j=0;j<zeroMatrix.get(i).size();j++){
                System.out.println("Zeroes matrix"+zeroMatrix.get(i).get(j));
            }
        }

        ArrayList<ArrayList<Integer>> R=new ArrayList<ArrayList<Integer>>(3);
        R.add(new ArrayList<Integer>((Arrays.asList(1,2,3))));
        R.add(new ArrayList<Integer>((Arrays.asList(4,5,6))));
        R.add(new ArrayList<Integer>((Arrays.asList(7,8,9))));
        ArrayList<ArrayList<Integer>> rotatedMatrix=rotateMatrix(R);
        for(int i=0;i<rotatedMatrix.size();i++){
            for(int j=0;j<rotatedMatrix.get(i).size();j++){
                System.out.println("Zeroes matrix"+rotatedMatrix.get(i).get(j));
            }
        }

    }
    public static ArrayList<ArrayList<Integer>> setZeroes(ArrayList<ArrayList<Integer>> a){
        int n=a.size();
        if(n==0){
            return null;
        }
        int[] cols=new int[a.get(0).size()];
        int[] rows=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<a.get(i).size();j++){
                if(a.get(i).get(j)==0){
                    rows[i]=-1;
                    cols[j]=-1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<a.get(i).size();j++){
                if((rows[i]==-1) || (cols[j]==-1)){
                    a.get(i).set(j,0);
                }
            }
        }

        return a;

    }

    public static ArrayList<ArrayList<Integer>> rotateMatrix(ArrayList<ArrayList<Integer>> A){
        int S=A.size()-1;
        for(int i=0;i<A.size()/2;i++){
            for(int j=i;j<S-i;++j){
                int temp1=A.get(S-j).get(i);
                int temp2=A.get(S-i).get(S-j);
                int temp3=A.get(j).get(S-i);
                int temp4=A.get(i).get(j);

                A.get(i).set(j,temp1);
                A.get(S-j).set(i,temp2);
                A.get(S-i).set(S-j,temp3);
                A.get(j).set(S-i,temp4);
            }
        }
        return A;
    }
}
