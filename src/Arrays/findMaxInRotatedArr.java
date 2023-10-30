package Arrays;

class findMaxInRotatedArr {
    public int findMin(int[] nums) {
        int min = nums[0];
        for(int i=1;i<nums.length;i++){
            if(min>nums[i]){
                min = nums[i];
                break;
            }
        }
        return min;
    }

    public int findMin2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                min = Math.min(min,nums[low]);
                low = mid+1;
            }
            else if(nums[low]>nums[mid]){
                low = mid;
            }
        }
        return min;
    }
}