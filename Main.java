import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> A =new ArrayList<Integer>(3);
        A.add(0);A.add(2);A.add(3);

        ArrayList<Integer> B =new ArrayList<Integer>(3);
        B=plusOne(A);
    for (int i=0;i<B.size();i++){
        System.out.println("One Plus Value B!"+B.get(i));
    }

    }
    public static ArrayList<Integer> plusOne(ArrayList<Integer> a){

        int i=0;
        while(i<a.size()-1 && a.get(i)==0){
            a.remove(i);
        }
        int carry=1;
        for(i=a.size()-1;i>=0;i--){

            int sum=a.get(i)+carry;
            a.set(i,sum%10);
            carry=sum/10;

            if(carry==0){
                break;
            }

        }
        if(carry!=0){
            a.set(0,carry);
        }
        return a;
    }
}
