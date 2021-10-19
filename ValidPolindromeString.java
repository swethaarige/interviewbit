import java.util.ArrayList;

public class ValidPolindromeString {
    public static boolean checkForValidPolindrome(String s){
        if(s==null || s.length()==0) return false;
        s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        System.out.println(s);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static String commonPrefix(ArrayList<String> A){
        if(A==null || A.size()==0) return null;
        StringBuilder sb=new StringBuilder();
        int minLen=Integer.MAX_VALUE;
        for(String S:A){
            if(S==null || S.length()==0){
                return null;
            }
            if(S.length()<minLen){
                minLen=S.length();
            }
        }
        for(int j=0;j<minLen;j++){
            int count=0;
            char c=A.get(0).charAt(j);
            for(int i=0;i<A.size();i++){
                if(A.get(i).charAt(j)!=c){
                    break;
                }
                count++;
            }
            if(count!=A.size()) return sb.toString();
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String str = "A man, a plan, a canal: Panama";

        System.out.println(checkForValidPolindrome(str));
        String str1 = "race a car";
        System.out.println(checkForValidPolindrome(str1));
        ArrayList<String> listOfStrings=new ArrayList<>(3);
        listOfStrings.add("abcdefgh");
        listOfStrings.add("aefghijk");
        listOfStrings.add("abcefgh");
        String commonPRefix=commonPrefix(listOfStrings);
        System.out.println("Common PRefix"+commonPRefix);


    }
}
