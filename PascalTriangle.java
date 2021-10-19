import java.util.*;


public class PascalTriangle {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> pascalTriangle=generate(5);
        for (int i=0;i<5;i++){

                System.out.println("Pascal Trainagle"+pascalTriangle.get(i));

        }
        ArrayList<Integer> kthRowofPascal=generateKthRow(10);
        for(int i=0;i<kthRowofPascal.size();i++){
            System.out.println("Kth Row"+kthRowofPascal.get(i));
        }
        ArrayList<ArrayList<Integer>> A=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> element1=new ArrayList<>();
        element1.add(1);element1.add(2);element1.add(3);
        A.add(element1);
        ArrayList<Integer> element2=new ArrayList<>();
        element2.add(4);element2.add(5);element2.add(6);
        A.add(element2);
        ArrayList<Integer> element3=new ArrayList<>();
        element3.add(7);element3.add(8);element3.add(9);
        A.add(element3);

        ArrayList<ArrayList<Integer>> antiDioganalsresult=antiDiagonals(A);
        for (int i=0;i<antiDioganalsresult.size();i++){

            System.out.println("AntiDiagonals"+antiDioganalsresult.get(i));

        }
        ArrayList<Integer> nobleIntegerArray=new ArrayList<>(4);
        nobleIntegerArray.add(1);nobleIntegerArray.add(2);nobleIntegerArray.add(3);nobleIntegerArray.add(4);
        int nobleNumber=nobleInteger(nobleIntegerArray);
        System.out.println("Noble interger value"+nobleNumber);

        ArrayList<String> listOfValues=new ArrayList<>(5);
        listOfValues.add("0.6");listOfValues.add("0.7");listOfValues.add("0.8");listOfValues.add("1.2");listOfValues.add("0.4");
        int tripleExists=sumOfTriplets(listOfValues);
        System.out.println("Triplet Exists"+tripleExists);

        List<Integer> largestNumberList=new ArrayList<>(5);
        largestNumberList.add(3);largestNumberList.add(30);largestNumberList.add(34);largestNumberList.add(5);largestNumberList.add(9);
        String largestNum=largestNumber(largestNumberList);
        System.out.println("Largest Number"+largestNum);

        ArrayList<Integer> valuesForwaveArray=new ArrayList<Integer>();
        valuesForwaveArray.add(2);valuesForwaveArray.add(3);valuesForwaveArray.add(4);valuesForwaveArray.add(1);
        ArrayList<Integer> waveArray=waveArray(valuesForwaveArray);
        for(Integer i:waveArray){
            System.out.println("Wave Array values"+i);
        }
        List<Integer> repeatedValuesList=new ArrayList<>(4);
        repeatedValuesList.add(1);repeatedValuesList.add(2);repeatedValuesList.add(2);repeatedValuesList.add(3);
        System.out.println("Repeated Number in an array"+repeatingNumber(repeatedValuesList));

    }
    public static ArrayList<ArrayList<Integer>> generate(int A){
        int numOfRows=A;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(A==0)
            return result;
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for(int i=1;i<numOfRows;i++){
            result.add(new ArrayList<>());
            result.get(i).add(1);
            for(int j=0;j<i-1;j++){
                int num=result.get(i-1).get(j)+result.get(i-1).get(j+1);
                result.get(i).add(num);
            }
            result.get(i).add(1);
        }
        return result;
    }

    public static ArrayList<Integer> generateKthRow(int A){
        ArrayList<Integer> result=new ArrayList<Integer>();
        result.add(1);
        for(int i=1;i<=A;i++){
            int num=(A+1-i)*result.get(i-1)/i;
            result.add(num);
        }
        return result;
    }

    public static ArrayList<ArrayList<Integer>> antiDiagonals(ArrayList<ArrayList<Integer>> A){

        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        int dimension=A.size();
        for (int i=0;i<2*dimension-1;i++){
            result.add(getDiagonal(i,A));
        }
        return result;

    }
    public static ArrayList<Integer> getDiagonal(int layer, ArrayList<ArrayList<Integer>> A){
        ArrayList<Integer> result=new ArrayList<>();
        for(int i=0;i<=layer;i++){
            int j=layer-i;
            if(i<A.size()&&j<A.size()) {
                result.add(A.get(i).get(j));
            }
        }
        return result;

    }
    public static int nobleInteger(ArrayList<Integer> A){
        Collections.sort(A);
        for(int i=0;i<A.size();i++){
            if(i<A.size()-1 && A.get(i)==A.get(i+1)){
                continue;
            }
            if(A.size()-i-1==A.get(i)){
            return 1;
            }
        }

        return -1;
    }

    public static int sumOfTriplets(ArrayList<String> A) {
        int n = A.size();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.valueOf(A.get(i));
        }
        double a = arr[0], b = arr[1], c = arr[2];
        for (int i = 3; i < n; i++)
            if (a + b + c > 1 && a + b + c < 2) {
                return 1;
            } else if (a + b + c > 2) {
                if (a > b && a > c) {
                    a = arr[i];
                } else if (b > a && b > c) {
                    b = arr[i];
                } else if (c > a && c > b) {
                    c = arr[i];
                }
            } else {
                if (a > b && a > c) {
                    a = arr[i];
                } else if (b > a && b > c) {
                    b = arr[i];
                } else if (c > a && c > b) {
                    c = arr[i];
                }
            }

    if(a+b+c>1 && a+b+c<2){
        return 1;
    }
    else{
        return 0;
    }

    }
    public  static String largestNumber(List<Integer> A){
        List<String> strs=new ArrayList<>();
        for(Integer i:A){
            strs.add(String.valueOf(i));
        }
        Collections.sort(strs, new MyComparator());
        StringBuffer strBfr=new StringBuffer();
        for (String s: strs){
            if("0".equals(s) && strBfr.length()!=0) {
                continue;

            }
            strBfr.append(s);
        }


        return strBfr.toString();
    }
    static class MyComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            String first=o1+o2;
            String second=o2+o1;
            return second.compareTo(first);
        }

    }

    public static ArrayList<Integer> waveArray(ArrayList<Integer> A){
        Collections.sort(A);
        for (int i=0;i<A.size()-1;i=i+2){
            int temp=A.get(i);
            A.set(i,A.get(i+1));
            A.set(i+1,temp);
        }
        return A;
    }
    public static int repeatingNumber(List<Integer> A){
        HashSet hs=new HashSet();
        for(Integer each:A){
            if(hs.contains(each)){
                return each;
            }
            else{
                hs.add(each);
            }
        }


        return -1;
    }
}
