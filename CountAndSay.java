public class CountAndSay {
    public static String countAndSaySequence(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        String str = "11";
        for (int i = 3; i <= n; i++) {
            str += '$';
            int len = str.length();
            String temp = "";
            int count = 1;
            char[] arr = str.toCharArray();
            for (int j = 1; j < len; j++) {
                if (arr[j] != arr[j - 1]) {
                    temp += count + 0;
                    temp += arr[j - 1];
                    count = 1;

                } else {
                    count++;
                }

            }
            str = temp;
        }
        return str;
    }
    public static int amazingStringsCount(String A){
        int result=0;
        for(int i=0;i<A.length();i++){
            if(isVowel(A.charAt(i))) {
                result += A.length() - i;
                result %= 10003;
            }
        }
       return result;
    }
    public static boolean isVowel(char c){
        char[] vowels=new char[]{'a','e','i','o','u','A','E','O','I','U'};
        for(int i=0;i<vowels.length;i++){
            if(vowels[i]=='c'){
                return true;
            }
        }
        return false;
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
    public static int minCharactersForPolindrome(String A){
        int n=A.length();
        int ans=n;
        while(n>1 && !isPolindrome(A,n)){
            n--;
        }
        return ans-n;
    }
    public static void main(String[] args){
        System.out.println("Count And Say"+countAndSaySequence(4));
        System.out.println("Count And Say"+countAndSaySequence(5));
        System.out.println("Count And Say"+countAndSaySequence(5));
        System.out.println("Count And Say"+countAndSaySequence(6));
        System.out.println("Count And Say"+countAndSaySequence(7));
        System.out.println("Count And Say"+countAndSaySequence(8));
        System.out.println("Count And Say"+countAndSaySequence(9));
        System.out.println("Count Of Amazing Substrings"+amazingStringsCount("ABEC"));
        System.out.println("Count Of Amazing Substrings"+(6%10003));
        System.out.println("Minimum characters required for Polindrome"+minCharactersForPolindrome("ABC"));
        System.out.println("Minimum characters required for Polindrome"+minCharactersForPolindrome("AACECAAAA"));
    }
}
