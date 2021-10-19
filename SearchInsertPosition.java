import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchInsertPosition {

    public static void main(String[] args){
        int arrayOfInetgers[]={1,3,5,6};
        List<Integer> list = Arrays.stream(arrayOfInetgers)		// IntStream
                .boxed()  		// Stream<Integer>
                .collect(Collectors.toList());

        System.out.println("Inserted Position"+searchInsertsolution(list,5));
        System.out.println("Inserted Position"+searchInsertsolution(list,2));
        System.out.println("Inserted Position"+searchInsertsolution(list,7));
        System.out.println("Inserted Position"+searchInsertsolution(list,0));

    }
    public static int searchInsertsolution(List<Integer> a,int target) {
        int low = 0;
        int high = a.size() - 1;
        if (a.get(low) > target) return low;
        if (a.get(high) < target) return high + 1;
        while (low <= high) {
            int mid = low + high / 2;
            if (a.get(mid) == target) {
                return mid;
            } else if (a.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;
    }

}

