public class MinimumCharactersForPolindrome {
    public static int minCharactersForPolindrome(String A){
        int n=A.length();
        int ans=n;
        while(n>1 && !isPolindrome(A,n)){
            n--;
        }
        System.out.println("n"+n);
        System.out.println("ans"+ans);
        return (ans-n);
    }
    public static boolean isPolindrome(String A,int length){
        int i=0;
        int j=length-1;
        while(i<=j & A.charAt(i)==A.charAt(j)){
            i++;
            j--;
        }
        if(i>j){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println("Minimum characters required for Polindrome"+minCharactersForPolindrome("ABC"));
        System.out.println("Minimum characters required for Polindrome"+minCharactersForPolindrome("AACECAAAA"));
    }
}
