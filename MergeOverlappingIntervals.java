import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        ArrayList<Interval> A = new ArrayList<Interval>(2);
        A.add(new Interval(1,3));
        A.add(new Interval(2,6));
        A.add(new Interval(8,10));
        A.add(new Interval(15,18));

        ArrayList<Interval> resultIntervals=merge(A);
        for(Interval i : resultIntervals){
            System.out.println("Inserted merged intervals"+"("+i.start +" ,"+i.end + ")" );
        }

    }
    public static ArrayList<Interval> merge(ArrayList<Interval> intervals){
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                 return o1.start-o2.start;
            }
        });

        ArrayList<Interval> result=new ArrayList<>();
        int start=intervals.get(0).start;
        int end=intervals.get(0).end;
        for (int i=1;i<intervals.size();i++){
            if(intervals.get(i).start<=end){
                end=Math.max(intervals.get(i).end,end);
            }
            else{
                result.add(new Interval(start,end));
                start=intervals.get(i).start;
                end=intervals.get(i).end;
            }
        }
        result.add(new Interval(start,end));
        return result;
    }
}
