public class BinarySearchExample{
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        int findAnelement = findElement(arr, 6, 4);
        System.out.println("Found an elemnet at position" + findAnelement);

    }
    public static int findElement(int arr[], int n, int target){
        int start=0,end=n-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]<target){
                start=mid+1;
            }
            else{
                start=mid-1;
            }

        }
        return -1;
    }

}
