public class PowerFunction {
    public static float power(float x, int n, int d){
        float temp;
        if(n==0){
            return 1;
        }
        temp=power(x,n/2,d);
        if(n%2==0){
            return (temp*temp)%d;
        }
        else{
            if(n>0){
                return (x*temp*temp)%d;
            }
            else{
                return ((temp*temp)/x)%d;
            }
        }

    }
    public static void main(String[] args){
        System.out.println("Power of Function and Division"+power(2,3,3));
    }
}
