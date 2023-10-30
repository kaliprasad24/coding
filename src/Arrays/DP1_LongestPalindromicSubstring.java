package Arrays;

import java.util.Arrays;

public class DP1_LongestPalindromicSubstring {
    static public String longestPalindrome(String s) {
        int maxL = 1;
        String result = "";
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n-1;i++){
            dp[i][i] = 1;
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                maxL = 2;
                result = s.substring(i,i+2);
            }
            else {
                dp[i][i+1] = 0;
            }
        }
        dp[n-1][n-1] = 1;
        if(maxL<2){
            result = String.valueOf(s.charAt(n-1));
        }
        System.out.println(Arrays.deepToString(dp));

        for(int i = 2;i<n;i++){
            int left = 0;
            int right = i;
            while (right < n){
                if(s.charAt(left) == s.charAt(right) && dp[left+1][right-1] == 1){
                    dp[left][right] = 1;
                    String sub = s.substring(left,right+1);
                    if(sub.length() > maxL){
                        maxL = sub.length();
                        result = s.substring(left,right+1);
                    }
                }
                left++;
                right++;
            }
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        longestPalindrome("aaaaa");
    }
}
