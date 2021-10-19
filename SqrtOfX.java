public class SqrtOfX {
    public static void main(String[] args){
        System.out.println("Square Root of 9"+sqrtFunction(9));
        System.out.println("Square Root of 12"+sqrtFunction(12));
        System.out.println("Square Root of 121"+sqrtFunction(121));
    }
    public static int sqrtFunction(int a){
        int high=a;
        int low=1;
        while(low<=high){
            int mid=(low+high)/2;
            if(mid*mid==a){
                return mid;
            }
            else if(mid*mid>a){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        return (int)high;
    }
}
