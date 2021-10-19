import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InsertNewInterval {

    public static void main(String[] args) {
        List<Interval> A = new ArrayList<Interval>(2);
        A.add(new Interval(1,2));
        A.add(new Interval(3,5));
        A.add(new Interval(6,7));
        A.add(new Interval(8,10));
        A.add(new Interval(12,16));

        List<Interval> resultIntervals=insert(A,new Interval(4,9));
        for(Interval i : resultIntervals){
            System.out.println("Inserted merged intervals"+"("+i.start +" ,"+i.end + ")" );
        }

    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        Stack<Interval> stack = new Stack<>();

        List<Interval> result = new ArrayList<>();


        for(Interval i : intervals){
            stack.push(i);
        }

        Interval current = null;

        while(!stack.isEmpty()){
            current = stack.pop();

            if(!overlap(current, newInterval)){
                if(current.start > newInterval.end){
                    result.add(current);
                    continue;
                }

                if(current.end < newInterval.start){
                    result.add(newInterval);
                    newInterval = current;

                  /*  while(!stack.isEmpty()){
                        result.add(stack.pop());
                    }*/
                }
            }else{

                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);

            }

        }

        if(stack.isEmpty() && newInterval != null)
            result.add(newInterval);


       /* while(!stack.isEmpty()){
            result.add(stack.pop());
        }
*/

        Collections.reverse(result);


        return result;
    }

    static boolean  overlap(Interval i1, Interval i2){

        if((i1.end < i2.start) || i2.end < i1.start)
            return false;

        return true;
    }
}
