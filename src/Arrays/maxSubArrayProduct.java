package Arrays;

import java.util.Arrays;

public class maxSubArrayProduct {
    long maxProduct(int[] arr, int n) {
        // code here
        long maxe = -Integer.MAX_VALUE;
        long pref = 1;
        long suf = 1;
        for(int i=0;i<n;i++){
            if(pref == 0) pref = 1;
            if(suf == 0) suf = 1;
            pref *=arr[i];
            suf *=arr[n-i-1];
            maxe = Math.max(maxe,Math.max(pref,suf));
        }
        return maxe;
    }

    long maxProductBF(int[] arr, int n) {
        long max = -Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            long prod = arr[i];
            for(int j=i+1;j<n;j++){
                max = Math.max(max,prod);
                prod*=arr[j];
            }
            max = Math.max(max,prod);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] Arr = {3 ,12 ,15 ,23 ,33 ,-35 ,30 ,-40 ,-30 ,-30 ,-30 ,26 ,28};
        maxSubArrayProduct mx = new maxSubArrayProduct();
        long m = mx.maxProduct(Arr,13);
        System.out.println(m);
        System.out.println(mx.maxProductBF(Arr,13));
    }
}
