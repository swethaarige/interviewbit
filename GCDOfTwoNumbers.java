public class GCDOfTwoNumbers {
    public static void main(String[] args){
        System.out.println("Gcd of the two numbers"+gcd(15,10));
        System.out.println("Gcd of the two numbers"+gcd(24,36));

    }
    public static int gcd(int a, int b){
        if(a==b){
            return a;
        }
        if(a==0){
            return b;
        }
        if(b==0){
            return a;
        }
        if(a>b){
            return gcd(a-b,b);
        }
        else{
            return gcd(b-a,a);
        }
    }
}
