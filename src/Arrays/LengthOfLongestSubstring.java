package Arrays;

import java.util.HashMap;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int len = 0;
        int n = s.length();
        int start = 0;
        int end = 0;
        while (end<n){
            if(hashMap.get(s.charAt(end))!=null && (hashMap.get(s.charAt(end))>=start)){
                int index = hashMap.get(s.charAt(end));
                start = index+1;
            }
            len = Math.max(len,end-start+1);
            hashMap.put(s.charAt(end),end);
            end++;
        }
        return len;
    }

    public int lengthOfLongestSubstring2(String s) {
       int len = 0;
       int start = 0;
       int end;
       for(end = 0;end<s.length();end++){
           if(end!=s.indexOf(s.charAt(end),start)){
               start = s.indexOf(s.charAt(end),start)+1;
           }
           len = Math.max(len,end-start+1);
       }
        return len;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring s = new LengthOfLongestSubstring();
        System.out.println(s.lengthOfLongestSubstring2("tmmzuxt"));
    }
}