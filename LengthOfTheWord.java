import java.math.BigInteger;

public class LengthOfTheWord {
    public static int lengthOfTheWord(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        int result=0;
        int len=s.length();
        boolean flag=false;
        for(int i=len-1;i>=0;i--){
            char c=s.charAt(i);
            if(((c>='a') && (c<='z')) ||((c>='A') &&(c<='Z'))){
                flag=true;
                result++;
            }
            else{
                if(flag)
                    return result;
            }

            }
        return result;
        }
        public static String reverseWordsInString(String s){
        if(s==null || s.length()==0){
            return "";

        }
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            if(!arr[i].equals("")){
                sb.append(arr[i]).append(" ");
            }
        }
        return sb.length()==0?"":sb.substring(0,sb.length()-1);
        }
        public static int strStr(String A, String B){
        if(A.length()==0 || B.length()==0){
            return -1;
        }
        else if(A.length()<B.length()){
            return -1;
        }
        int n=A.length();
        int m=B.length();
        for(int i=0;i<=n-m;i++){
            String s=A.substring(i,i+m);
            if(s.equals(B)){
                return i;
            }
        }
        return -1;
        }
        public static int compareVersions(String version1,String version2){
        String[] levels1=version1.split("\\.");
        String[] levels2=version2.split("\\.");

        int length=Math.max(levels1.length,levels2.length);
        for(int i=0;i<=length;i++){
            System.out.println("levels1   "+levels1[i]);
            System.out.println("levels1   "+levels2[i]);
            Integer v1=i<levels1.length?Integer.parseInt(levels1[i]):0;
            Integer v2=i<levels2.length?Integer.parseInt(levels2[i]):0;
            int compare=v1.compareTo(v2);
            if(compare!=0){
                return compare;
            }
        }
        return 0;
        }
        public static int atoi(String str){
        if(str.length()==0 || str==null){
            return 0;
        }
        str=str.trim();
        char flag='+';
        int i=0;
        if(str.charAt(0)=='-'){
            flag='-';
            i++;
        }
        else if(str.charAt(0)=='+'){
            i++;
        }
        double result=0;
        while(str.length()>i && str.charAt(i)>='0' && str.charAt(i)<='9'){
            result=result*10+(str.charAt(i)-'0');
            i++;
        }
        if(flag=='-'){
            result=-result;
        }
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return (int)result;
        }
    public int isValidNumber(final String a) {
        return (a.matches("\\s*[\\-\\+]?([0-9]*\\.?)?[0-9]+(e[\\-\\+]?[0-9]+)?\\s*")) ? 1 : 0;
    }
    public static int romanToInt(String A){
        int l=A.length();
        if(l==0) return 0;
        int sum=0;
        for(int i=0;i<l-1;i++){
            char c=A.charAt(i);
            char cn=A.charAt(i+1);
            int valc=valueOf(c);
            int valcn=valueOf(cn);
            if(valc==0) continue;
            else if(valc==0|| valc>=valcn){
                sum+=valc;
            }
            else{
                sum-=valc;
            }

        }
        sum+=valueOf(A.charAt(l-1));
        return sum;
    }
    public static String intToRoman(int n){
        String o[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String t[]={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String c[]={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String m[]={"","M","MM","MMM"};
        return m[n/1000]+c[n%1000/100]+t[n%100/10]+o[n%10];

    }
    public static int valueOf(char c){
        if(c=='I') return 1;
        else if(c=='V') return 5;
        else if(c=='X') return 10;
        else if(c=='L') return 50;
        else if(c=='C') return 100;
        else if(c=='D') return 500;
        else if(c=='M') return 1000;

        return 0;
    }
    public static String addBinaryNumbers(String A,String B){
        BigInteger x=new BigInteger(A,2);
        BigInteger y=new BigInteger(B,2);
        BigInteger z=x.add(y);
        return z.toString(2);
    }
    public static int isPowerOfTwo(int n){
        if (n == 0)
            return 0;
        while (n != 1)
        {
            if (n%2 != 0)
                return 0;
            n = n/2;
        }
        return 1;
    }
    public static String multiplyStrings(String num1,String num2){
        String n1=new StringBuilder(num1).reverse().toString();
        String n2=new StringBuilder(num2).reverse().toString();
        int[] d=new int[num1.length()+num2.length()];
        //multiply each digit and sum at corresponding positions
        for(int i=0;i<n1.length();i++){
            for(int j=0;j<n2.length();j++){
                d[i+j]+=(n1.charAt(i)-'0') *(n2.charAt(j)-'0');
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<d.length;i++){
            int mod=d[i]%10;
            int carry=d[i]/10;
            if(i+1<d.length){
                d[i+1]+=carry;
            }
            sb.insert(0,mod);
        }
        while(sb.charAt(0)=='0' &&sb.length()>1){
            sb.deleteCharAt(0);
        }
    return sb.toString();

    }
        public static void main(String[] args){
        System.out.println("Length of last word"+lengthOfTheWord("Hello World"));
            System.out.println("Length of last word"+reverseWordsInString("Misheeta Krithikesh"));
            System.out.println("Length of last word"+reverseWordsInString("Hello World"));
            System.out.println("Length of last word"+lengthOfTheWord("Misheeta Krithikesh"));
            System.out.println("StrStr"+strStr("String","ring"));
            System.out.println("Compare Versions"+compareVersions("1.2.3","1.3.4"));
            System.out.println("Compare Versions"+compareVersions("1.1.3","1.0.4"));
            System.out.println("ATOI"+atoi("927 04"));
             final String EXAMPLE_TEST = "This is my small example "
                    + "string which I'm going to " + "use for pattern matching.";
            System.out.println(EXAMPLE_TEST.matches("\\w.*"));
            String[] splitString = (EXAMPLE_TEST.split("\\s+"));
            System.out.println(splitString.length);// should be 14
            for (String string : splitString) {
                System.out.println(string);
            }
            // replace all whitespace with tabs
            System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
            System.out.println("Roman To Integer"+romanToInt("XIV"));
            System.out.println("Integer To Roman"+intToRoman(419));
            System.out.println("Integer To Roman"+intToRoman(246));
            System.out.println("Integer To Roman"+intToRoman(1066));
            System.out.println("Add Binary numbers"+addBinaryNumbers("111","111"));
            System.out.println("Multiply two numbers as Strings"+multiplyStrings("68","26"));
            System.out.println("4 mod 10"+(4%10));
            System.out.println("4 / 10"+(4/10));



        }
    }