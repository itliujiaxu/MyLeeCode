/*5. 最长回文子串
        给你一个字符串 s，找到 s 中最长的回文子串。
        示例 1：
            输入：s = "babad"
            输出："bab"
            解释："aba" 同样是符合题意的答案。*/
public class LongestPalindrome5 {
    public static void main(String[] args) {
        LongestPalindrome5 lp = new LongestPalindrome5();
        String s = "babad";
        System.out.println(lp.longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int start = 0;
        int maxNum = 1;
        char[] chars = s.toCharArray();
        for(int i = 0; i < len-1; i++){
            int m1 = helper(chars, i, i);
            int m2 = helper(chars, i, i+1);
            int mMax = Math.max(m1, m2);
            if(mMax>maxNum){
                maxNum = mMax;
                start = i - (maxNum-1)/2;
            }
        }
        return s.substring(start, start + maxNum);
    }
    public int helper(char[] chars, int i, int j){
        int len = chars.length;
        while(i>=0 && j<len){
            if(chars[i] != chars[j]){
                break;
            }
            i--;
            j++;
        }
        return j-i-1;
    }
}
