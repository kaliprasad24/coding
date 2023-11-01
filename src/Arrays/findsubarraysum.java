package Arrays;

import java.util.HashMap;

public class findsubarraysum {

    public static int subarraysum(int[] arr,int target){
        int currentSum = arr[0], start = 0, i,n = arr.length,count = 0;
        for (i = 1; i <= n; i++) {
            while (currentSum > target && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }

            if (currentSum == target) {
                count++;
            }
            if (i < n)
                currentSum = currentSum + arr[i];
        }
        return count;
    }

    public static int subArraySum(int[] nums,int n,int k){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int summ = 0, count = 0;
        hashMap.put(0,1);
        for (int i = 0; i < n; i++) {
            summ += nums[i];
            if (hashMap.get(summ - k) != null) {
                count+=hashMap.get(summ-k);
            }
            hashMap.put(summ,hashMap.getOrDefault(summ,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {24,16, 5, 26, 27, 2};
        int[] arr2 = {10, 2, -2, -20, 10};
        int out = subArraySum(arr2,5,-10);
        System.out.println(out);
    }
}
