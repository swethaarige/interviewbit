public class CheckPolindrome {
    public static void main(String[] args){
        //System.out.println("IsPolindrome"+check(121));
        int arr1[]={1,2,3,4,5,6};
        int findAnelement=findElement(arr1,6,4);
        System.out.println("Found an elemnet at position"+findAnelement);
    }
    public boolean isPalindrome(int a) {
        if(a==check(a)){
            return true;
        }
        else{
            return false;
        }
    }
    public static int check(int num){
        int reverted=0;
        while(num>0){
            reverted=reverted*10+num%10;
            num=num/10;
        }
        return reverted;
    }
    public static int findElement(int[] arr, int n, int target){
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
