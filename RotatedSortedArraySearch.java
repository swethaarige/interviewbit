import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RotatedSortedArraySearch {
    public static int rotatedSortedArraySearch(List<Integer> A, int b){
        int i=0;
        int j=A.size()-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(A.get(mid)==b){
                return mid;
            }
            if(A.get(mid)>=A.get(i)){
                if(b<A.get(mid) && b>=A.get(i)){
                    j=mid-1;
                }
                else{
                    i=mid+1;
                }
            }
            else{
                if(b>A.get(mid) && b<=A.get(i)){
                    i=mid+1;
                }
                else{
                    j=mid-1;
                }
            }

        }
    return -1;
    }
    public static void main(String[] args){
        int arrayOfInetgers[]={4,5,6,7,0,1,2};
        List<Integer> list = Arrays.stream(arrayOfInetgers)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());

        int FindAnElement=rotatedSortedArraySearch(list,4);
        System.out.println("Element found in ROtatedSortedArray"+FindAnElement);
    }
}

