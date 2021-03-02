import java.util.HashMap;
import java.util.Map;

/*1. 两数之和
给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class TwoSumLeeCode1 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] a = twoSum(nums,target);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] returnNums = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                returnNums[0] = i;
                returnNums[1] = map.get(nums[i]);
                return returnNums;
            }
            map.put(target-nums[i],i);
        }
        return returnNums;
    }

}
