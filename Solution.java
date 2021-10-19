
// you can also use imports, for example:
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
    public static String[] solution(String S, int[] B, int[] C) throws ParseException{
        // write your code in Java SE 8
        String givenDate=S.substring(0,11);
        String removeDots=givenDate.replace(".","");
        String givenTime=S.substring(S.length()-2);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Calendar c=Calendar.getInstance();
        try{
            c.setTime(sdf.parse(removeDots));
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        String[] output=new String[2];
        if(givenTime.equals("PM")&&B[0]==0&&C[0]==0){
            c.add(Calendar.DAY_OF_MONTH,1);
            String earliestDate=sdf.format(c.getTime());
            Calendar c1=Calendar.getInstance();
            c1.setTime(sdf.parse(removeDots));
            c1.add(Calendar.DAY_OF_MONTH,(B[1]+C[1]));
            int dayOfWeekForlatestDate=c1.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeekForlatestDate==Calendar.SATURDAY){
                //If its friday skip to Monday
                c1.add(Calendar.DATE,2);
            }
            else if(dayOfWeekForlatestDate==Calendar.SUNDAY){
                //If its Saturday skip to Monday
                c1.add(Calendar.DATE,1);
            }
            String latestDate=sdf.format(c1.getTime());
            SimpleDateFormat sdfFinal=new SimpleDateFormat("dd-MMM-yyyy");
            String outputEarliestDate=sdfFinal.format(sdf.parse(earliestDate));
            String outputLatestDate=sdfFinal.format(sdf.parse(latestDate));
            output[0]=outputEarliestDate;
            output[1]=outputLatestDate;
        }
        else{
            c.add(Calendar.DAY_OF_MONTH,(B[0]+C[0]));
            String earliestDate=sdf.format(c.getTime());
            Calendar c1=Calendar.getInstance();
            c1.setTime(sdf.parse(removeDots));
            c1.add(Calendar.DAY_OF_MONTH,(B[1]+C[1]));
            int dayOfWeekForlatestDate=c1.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeekForlatestDate==Calendar.SATURDAY){
                //If its friday skip to Monday
                c1.add(Calendar.DATE,2);
            }
            else if(dayOfWeekForlatestDate==Calendar.SUNDAY){
                //If its Saturday skip to Monday
                c1.add(Calendar.DATE,1);
            }
            String latestDate=sdf.format(c1.getTime());
            SimpleDateFormat sdfFinal=new SimpleDateFormat("dd-MMM-yyyy");
            String outputEarliestDate=sdfFinal.format(sdf.parse(earliestDate));
            String outputLatestDate=sdfFinal.format(sdf.parse(latestDate));
            output[0]=outputEarliestDate;
            output[1]=outputLatestDate;
        }
        return output;
    }
}


