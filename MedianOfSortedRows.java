import java.lang.reflect.Array;
import java.util.*;

public class MedianOfSortedRows {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> element1 = new ArrayList<>();
        element1.add(1);
        element1.add(3);
        element1.add(5);
        A.add(element1);
        ArrayList<Integer> element2 = new ArrayList<>();
        element2.add(2);
        element2.add(6);
        element2.add(9);
        A.add(element2);
        ArrayList<Integer> element3 = new ArrayList<>();
        element3.add(3);
        element3.add(6  );
        element3.add(9);
        A.add(element3);
        System.out.println("Median"+findMedian(A));
        System.out.println("Search Element"+searchMatrix(A,9));
    }
    public static int findMedian(ArrayList<ArrayList<Integer>> A){
        int min= Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int r=A.size();
        int c=A.get(0).size();
        System.out.println(" r and c values"+r+"And" +c);
        for(int i=0;i<r;i++){
            if(A.get(i).get(c-1)>max){
                max=A.get(i).get(c-1);
            }
        }
        for(int i=0;i<r;i++){
            if(A.get(i).get(0)<min){
                min=A.get(i).get(0);
            }
        }
        int desired=(r*c+1)/2;
        System.out.println("Min Max and desired"+min +"," +max +","+desired);
        while(min<max){
            int mid=(max+min)/2;
            int get=0,place=0;
            for(int i=0;i<r;i++){
                get=Arrays.binarySearch(A.get(i).toArray(),mid);
                System.out.println("get value after binarySearch"+get);
                if(get<0){
                    get=Math.abs(get)-1;
                }
                else{
                    while(get<c && A.get(i).get(get)==mid){
                        get++;
                    }
                }
                place+=get;
            }
            if(place<desired){
                min=mid+1;
            }
            else{
                max=mid;
            }
        }
        return min;
    }
    public static int searchMatrix(ArrayList<ArrayList<Integer>> A,int b){
        if(A.size()<1)
            return 0;
        int yLength=A.get(0).size();
        int max=A.size()*yLength-1;
        int min=0;
        int x,y;
        while(min<=max){
            int mid=(min+max)/2;
            x=mid/yLength;
            y=mid%yLength;
            if(A.get(x).get(y)==b){
                return 1;
            }
            else if(A.get(x).get(y)>b){
            max=mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return 0;
    }
}
