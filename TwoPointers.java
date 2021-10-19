import java.util.ArrayList;

public class TwoPointers {
    public static ArrayList<Integer> mergeSortedLists(ArrayList<Integer> a, ArrayList<Integer> b) {
        int aIndex = 0, bIndex = 0;
        //When we inserted all the items from 'b' into 'a' there is no need
        //to continue iteration
        while (bIndex < b.size()) {
            //Find an element in 'a' which is greater than the current
            //element in 'b'
            while (aIndex < a.size() && a.get(aIndex) <= b.get(bIndex)) {
                aIndex++;
            }
            a.add(aIndex, b.get(bIndex));
            bIndex++;
        }
        return a;
    }

    public static ArrayList<Integer> interesectSortedLists(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.size() == 0 || B == null || B.size() == 0) {
            return res;
        }
        int aIndex = 0, bIndex = 0;
        while (aIndex < A.size() && bIndex < B.size()) {
            if (A.get(aIndex).equals(B.get(bIndex))) {
                res.add(A.get(aIndex));
                aIndex++;
                bIndex++;
            } else if (A.get(aIndex) <= B.get(bIndex)) {
                aIndex++;
            } else if (B.get(bIndex) <= A.get(aIndex)) {
                bIndex++;
            }

        }
        return res;
    }

    public  static int mimimizeAbsoluteDifference(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        int i = 0, j = 0, k = 0;
        int ans = Integer.MAX_VALUE;

        int max, min;
        System.out.println("Outside Block");

        while(i < A.size() && j < B.size() && k < C.size()) {

            System.out.println("Inside Block");

            max = Math.max(A.get(i), Math.max(B.get(j), C.get(k)));
            min = Math.min(A.get(i), Math.min(B.get(j), C.get(k)));

            ans = Math.min(ans, max-min);
            if(ans == 0) {
                break;
            }

            if(A.get(i) == min) {
                i++;
            }
            else if(B.get(j) == min) {
                j++;
            }
            else {
                k++;
            }
            System.out.println("Ans"+ans);
        }

        return ans;
    }
    public static int removeDuplicates(ArrayList<Integer> a) {
        if(a.size()<2){
            return a.size();
        }
        int prev=a.get(a.size()-1);
        for(int i=a.size()-2;i>=0;i--){
            if(a.get(i)==prev){
                a.remove(i);
            }
            else{
                prev=a.get(i);
            }
        }

        return a.size();
    }

    public static int removeDuplicatesFromSortedArrayII(ArrayList<Integer> a) {
        if(a.size()<=2){
            return a.size();
        }
        int curr=a.get(0);
        int count=1;
        int i=0;
        for(int j=1;j<a.size();j++){
            int val=a.get(j);
            if(val==curr){
                count++;
                if(count>=3){
                    continue;
                }
            }
            else{
                count=1;
                curr=val;
            }
            a.set(++i,val);

        }

        return i+1;
    }
    public static int removeElementFromAnArray(ArrayList<Integer> a, int b) {
        int n=a.size();
        int i,j;
        for(i=0,j=0;j<n;j++){
            if(a.get(j)!=b){
                i++;
            }

        }
        return i;
    }

    public static void sortColors(ArrayList<Integer> a) {
            int last0 = 0, last1 = 0, last2 = 0;
            for (int i = 0; i < a.size(); i++) {
                switch (a.get(i)) {
                    case 0:
                        System.out.println("Inside 0 block");
                        a.set(last0, 0);
                        last0++;
                        System.out.println("last0++ value"+last0);
                    case 1:
                        if (last1 >= last0)
                            System.out.println("Inside 1 block");
                            a.set(last1, 1);
                        last1++;
                        System.out.println("last1++ value"+last1);
                    case 2:
                        if (last2 >= last1)
                            System.out.println("Inside 2 block");
                            a.set(last2, 2);
                        last2++;
                        System.out.println("last2++ value"+last2);
                }
            }
    }

    public static void sortColors(int[] nums) {
        if (nums.length>1) {
            for (int i = 0; i < nums.length; i++) {
                int index = nums[i]; int j = i;
                while (j > 0 && nums[j-1] > index)
                {
                    nums[j] = nums[j-1];
                    j--;
                }
                nums[j] = index;
            }
        }
    }







    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(3);
        list.add(1);
        list.add(5);
        list.add(8);
        ArrayList<Integer> list2 = new ArrayList<>(2);
        list2.add(6);
        list2.add(9);
        ArrayList<Integer> sortedList=new ArrayList<>(5);
        sortedList=mergeSortedLists(list,list2);
        for(Integer i:sortedList){
            System.out.println("MergedSortedArray"+i);
        }

        ArrayList<Integer> list3 = new ArrayList<>(7);
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list3.add(6);
        ArrayList<Integer> list4 = new ArrayList<>(3);
        list4.add(3);
        list4.add(3);
        list4.add(5);
        ArrayList<Integer> inserctedlist=new ArrayList<>();
        inserctedlist=interesectSortedLists(list3,list4);
        for(Integer i:inserctedlist){
            System.out.println("InserctedSortedArray"+i);
        }
        ArrayList<Integer> list5 = new ArrayList<>(7);
        list5.add(1);
        list5.add(4);
        list5.add(5);
        list5.add(8);
        list5.add(10);

        ArrayList<Integer> list6 = new ArrayList<>(3);
        list6.add(6);
        list6.add(9);
        list6.add(15);
        ArrayList<Integer> list7 = new ArrayList<>(3);
        list4.add(2);
        list4.add(3);
        list4.add(6);
        list4.add(6);
        System.out.println("Mimimize Absolute difference"+mimimizeAbsoluteDifference(list5,list6,list7));

        ArrayList<Integer> list8 = new ArrayList<>(3);
        list8.add(1);
        list8.add(1);
        list8.add(2);

        ArrayList<Integer> list9 = new ArrayList<>();
        list9.add(4);
        list9.add(1);
        list9.add(1);
        list9.add(2);
        list9.add(1);
        list9.add(3);

        System.out.println("Remove Duplicates"+removeDuplicates(list8));

        System.out.println("Remove Element from an array"+removeElementFromAnArray(list9,1));
        ArrayList<Integer> list10 = new ArrayList<>();
        list10.add(0);
        list10.add(1);
        list10.add(2);
        list10.add(0);
        list10.add(1);
        list10.add(2);

        //ArrayList<Integer> sortedColors=new ArrayList<>();
        sortColors(list10);
        for(int i=0;i<list10.size();i++){
            System.out.println("SortColors"+list10.get(i));
        }
        ArrayList<Integer> list11 = new ArrayList<>();
        list11.add(1);
        list11.add(1);
        list11.add(1);
        list11.add(2);

        System.out.println("Remove duplicates from Sorted Arry2"+removeDuplicatesFromSortedArrayII(list11));

       
    }
}
