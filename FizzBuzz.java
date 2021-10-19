import java.util.ArrayList;

public class FizzBuzz {
    public static void main(String[] args){
    ArrayList<String> result=fizzBuzz(5);
    for(int i=0;i<result.size();i++){
        System.out.println("Result"+result.get(i));
    }
    }
    public static ArrayList<String> fizzBuzz(int A){
        ArrayList<String> result=new ArrayList<String>(A);
        for(int i=1;i<=A;i++){
            if(i%5==0&i%3==0) {
                result.add("FizzBuzz");
            }
            else if(i%3==0){
                result.add("Fizz");
            }
            else if(i%5==0){
                result.add("Buzz");
            }
            else{
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}
