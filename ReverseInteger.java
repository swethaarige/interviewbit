public class ReverseInteger {
    public static void main(String[] args){
        System.out.println("ReverseInteger"+reverse(123));
    }
    public static int reverse(int a){
        boolean negativeFlag=false;
        if(a<0){
            negativeFlag=true;
            a=-a;
        }
        int prev_rev_num=0,rev_num=0;
        while(a>0){
            int currentDigit=a%10;
            rev_num=(rev_num*10)+currentDigit;
            if((rev_num-currentDigit)/10!=prev_rev_num){
                return 0;
            }
            prev_rev_num=rev_num;
            a=a/10;
        }
        return negativeFlag ? -rev_num:rev_num;
    }

}
