import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ArticleETAProblem{


        public String[] solution(String s,int[] E,int[] L) throws ParseException {
            String givenDate = s.substring(0,11).replace(".","");
            //String removeDots=givenDate.replace(".","");
            System.out.println("Given date" +givenDate);
            String givenTime=s.substring(s.length()-2);
            System.out.println("Given time" +givenTime);

            //Specifying date format that matches the given date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Calendar c = Calendar.getInstance();
            try{
                //Setting the date to the given date
                c.setTime(sdf.parse(givenDate));
            }catch(ParseException e){
                e.printStackTrace();
            }
            String[] output=new String[2];
            if(givenTime.equals("PM") && E[0]==0 && L[0]==0){
                c.add(Calendar.DAY_OF_MONTH, 1);

           /* //Number of Days to add
                int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == Calendar.SATURDAY) { // If it's Friday so skip to Monday
                    c.add(Calendar.DATE, 2);
                } else if (dayOfWeek == Calendar.SUNDAY) { // If it's Saturday skip to Monday
                    c.add(Calendar.DATE, 1);
                }*/
            //Date after adding the days to the given date
            String earliestDate = sdf.format(c.getTime());
                Calendar c1=Calendar.getInstance();
                c1.setTime(sdf.parse(givenDate));
            //Displaying the new Date after addition of Days
            System.out.println("Date after Addition: "+earliestDate);
                //Number of Days to add
                c1.add(Calendar.DAY_OF_MONTH, (E[1]+L[1]));
                //c1.add(Calendar.DAY_OF_MONTH, 1);
                int dayOfWeekForLatestdate = c1.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeekForLatestdate == Calendar.SATURDAY) { // If it's Friday so skip to Monday
                    c1.add(Calendar.DATE, 2);
                } else if (dayOfWeekForLatestdate == Calendar.SUNDAY) { // If it's Saturday skip to Monday
                    c1.add(Calendar.DATE, 1);
                }
                String latestdate=sdf.format(c1.getTime());
                //input date format
                SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");

//output date format
                SimpleDateFormat dFormatFinal = new SimpleDateFormat("dd-MMM-yyyy");
                //Date date = dFormat.parse(latestdate);
                String outputEarlistdate=dFormatFinal.format(dFormat.parse(earliestDate));
                String outputlatestdate = dFormatFinal.format(dFormat.parse(latestdate));
                output[0]=outputEarlistdate;
                output[1]=outputlatestdate;

        }
            else{
                //Number of Days to add
                c.add(Calendar.DAY_OF_MONTH, (E[0]+L[0]));
               /* int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == Calendar.SATURDAY) { // If it's Friday so skip to Monday
                    c.add(Calendar.DATE, 2);
                } else if (dayOfWeek == Calendar.SUNDAY) { // If it's Saturday skip to Monday
                    c.add(Calendar.DATE, 1);
                }*/
                //Date after adding the days to the given date
                String earliestDate = sdf.format(c.getTime());
                //Displaying the new Date after addition of Days
                System.out.println("Date after Addition: "+earliestDate);
                //Number of Days to add
                Calendar c1=Calendar.getInstance();
                c1.setTime(sdf.parse(givenDate));
                c1.add(Calendar.DAY_OF_MONTH, (E[1]+L[1]));
                int dayOfWeekForLatestdate = c1.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeekForLatestdate == Calendar.SATURDAY) { // If it's Friday so skip to Monday
                    c1.add(Calendar.DATE, 2);
                } else if (dayOfWeekForLatestdate == Calendar.SUNDAY) { // If it's Saturday skip to Monday
                    c1.add(Calendar.DATE, 1);
                }
                String latestdate=sdf.format(c1.getTime());

                //input date format
                SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");

//output date format
                SimpleDateFormat dFormatFinal = new SimpleDateFormat("dd-MMM-yyyy");
                //Date date = dFormat.parse(latestdate);
                String outputEarlistdate=dFormatFinal.format(dFormat.parse(earliestDate));
                String outputlatestdate = dFormatFinal.format(dFormat.parse(latestdate));
                output[0]=outputEarlistdate;
                output[1]=outputlatestdate;

            }
            return output;
    }
}
