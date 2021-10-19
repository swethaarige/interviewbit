public class SearchForARange {
    public static int[] solution(int[] nums, int target){
        //corner case
        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }
        int[] result=new int[2];
        int start=0;
        int end=nums.length-1;
        //Find the first position in the target
        while(start+1<end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                end=mid;
            }
            else if(nums[mid]<target){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        if(nums[start]==target){
            result[0]=start;
        }
        else if(nums[end]==target){
            result[0]=end;
        }
        else{
            result[0]=result[1]=-1;
            return result;
        }
        start=0;
        end=nums.length-1;
        while(start+1<end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                start=mid;
            }
            else if(nums[mid]<target){
                start=mid;
            }
            else{
                end=mid;
            }
        }
        if(nums[start]==target){
            result[0]=start;
        }
        else if(nums[end]==target){
            result[0]=end;
        }
        else {
            result[0] = result[1] = -1;
        }
        return result;
        }
}
