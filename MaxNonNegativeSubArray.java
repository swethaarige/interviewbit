import java.lang.reflect.Array;
import java.util.ArrayList;

public class MaxNonNegativeSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(6);
        A.add(1);
        A.add(2);
        A.add(5);
        A.add(-7);
        A.add(2);
        A.add(3);


        System.out.println("Maximum Non Negative Sub Array"+maxSum(A));

    }

    public static ArrayList<Integer> maxSum(ArrayList<Integer> a){
        ArrayList<Integer> maxArray=new ArrayList<>();
        ArrayList<Integer> newArray=new ArrayList<>();
        int maxSum=0;
        int newSum=0;
        for(Integer i:a){
            if(i>=0){
                newSum+=i;
                newArray.add(i);
            }
            else{
                newSum=0;
                newArray=new ArrayList<Integer>();
            }
            if((maxSum<newSum || newSum==maxSum) && (newArray.size()>maxArray.size())){
                maxSum=newSum;
                maxArray=newArray;
            }
        }
        return maxArray;
    }
}
