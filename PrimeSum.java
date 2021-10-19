import java.util.ArrayList;

public class PrimeSum {
    public static void main(String[] args){
        ArrayList<Integer> result=new ArrayList<>(2);
        result=primeSum(6);
        System.out.println("Prime numbers result "+result.get(0) +result.get(1));

    }
    public static ArrayList<Integer> primeSum(int A){
        ArrayList<Integer> result=new ArrayList<Integer>(2);
        for(int i=2;i<A;i++){
            if(isPrime(i) && isPrime(A-i)){
                result.add(i);
                result.add(A-i);

            }
        }
        return result;
    }
    public static boolean isPrime(int number){
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
