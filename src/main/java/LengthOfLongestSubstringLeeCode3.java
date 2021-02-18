import java.util.HashSet;
import java.util.Set;

/*3. 无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class LengthOfLongestSubstringLeeCode3 {

    public static void main(String[] args) {
        LengthOfLongestSubstringLeeCode3 lo = new LengthOfLongestSubstringLeeCode3();
        String s = "pwwkew";
        System.out.println(lo.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
//        ---------------------------参考解题思路自己实现的-------------------
//        滑动窗口
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        //r右指针，右指针-1代表还未移动
        int len = 0,r = -1;
        for (int i = 0; i < n; i++) {
            //移除掉上一个字符，代表左指针右移一位
            if(i!=0){
                set.remove(s.charAt(i-1));
            }
            //不断遍历到最后一位
            while(r+1<n && !set.contains(s.charAt(r+1))){
                set.add(s.charAt(r+1));
                r++;
            }
            len = Math.max(len,r+1-i);
        }
        return len;
//        ---------------------------------自己做的----------------------------
//        if(s.length() == 0){
//            return 0;
//        }else if(s.length() == 1){
//            return 1;
//        }
//        char[] a = s.toCharArray();
//        Map<Character,Object> map = new HashMap<Character, Object>();
//        int as = 0;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i; j < a.length; j++){
//                if(map.containsKey(a[j])){
//                    as = Math.max(as,map.size());
//                    if(as>=a.length-i){
//                        return as;
//                    }
//                    map.clear();
//                    break;
//                }
//                map.put(a[j],j);
//            }
//        }
//        return as;
//        ---------------------别人做的---------------
//        int[] last = new int[128];
//        int n = s.length();
//
//        int res = 0;
//        int start = 0; // 窗口开始位置
//        for(int i = 0; i < n; i++) {
//            int index = s.charAt(i);
//            start = Math.max(start, last[index]);
//            res   = Math.max(res, i - start + 1);
//            last[index] = i+1;
//        }
//
//        return res;
    }

}
