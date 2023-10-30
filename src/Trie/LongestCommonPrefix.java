package Trie;

public class LongestCommonPrefix {

    class TrieNode{
        int endOfWord;
        int noOfWords;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[27];
            endOfWord = 0;
            noOfWords = 0;
        }
    }

    TrieNode root;

    void insert(String input){
        int level = 0;
        TrieNode curr = root;
        for(level = 0;level<input.length();level++){
            int index = input.charAt(level)-'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr.children[index].noOfWords++;
            curr = curr.children[index];
        }
        curr.endOfWord++;
    }

    String search(String word, int count){
        int out = 0;
        String stringout = "";
        int level;
        TrieNode curr = root;
        for(level =0;level<word.length();level++){
            int index = word.charAt(level)-'a';
            if(curr.children[index] != null && curr.children[index].noOfWords == count){
                stringout+=word.charAt(level);
                out++;
                curr = curr.children[index];
            }
            else {
                System.out.println(out);
                return stringout;
            }
        }
        return stringout;
    }

    public String longestCommonPrefix(String[] strs) {
        root = new TrieNode();

        for (String s : strs){
            insert(s);
        }
        String out = search(strs[0],strs.length);
        System.out.println(out);
        return out;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lp = new LongestCommonPrefix();
        String[] strs = {"flower","plow","flight"};
        lp.longestCommonPrefix(strs);

        String s = "kali";
        System.out.println(s.indexOf("li  "));
    }
}
