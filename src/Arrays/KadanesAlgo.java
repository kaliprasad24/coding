package Arrays;

public class KadanesAlgo {
    public static int maxSubArray(int[] nums) {
        int maxsofar = Integer.MIN_VALUE;
        int maxUntil = 0;
        for(int i=0;i<nums.length;i++){
            maxUntil+=nums[i];
            if(maxUntil>maxsofar){
                maxsofar = maxUntil;
            }
            if(maxUntil<0){
                maxUntil = 0;
            }
        }
        return maxsofar;
    }

    public static void main(String[] args) {

    }
}
