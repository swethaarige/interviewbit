import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelBookingsPossible {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<Integer>(3);
        A.add(1);
        A.add(3);
        A.add(5);

        ArrayList<Integer> D = new ArrayList<Integer>(3);
        D.add(2);
        D.add(6);
        D.add(8);

        System.out.println("Advance Hotel Bookings Possible"+hotel(A,D,1));

    }


    public  static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K){
        Collections.sort(arrive);
        Collections.sort(depart);
        int roomsRequired=0,i=0,j=0;
        while(i<arrive.size()&&j<arrive.size()&&roomsRequired<=K){
            if(arrive.get(i)<depart.get(j)){
                i++;
                roomsRequired++;
            }
            else{
                j++;
                roomsRequired--;
            }
        }
        if(roomsRequired<=K){
            return true;
        }
        else{
            return false;
        }

    }
}
