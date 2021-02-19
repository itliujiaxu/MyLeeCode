import java.util.Arrays;

/*41. 缺失的第一个正数
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？

示例 1：
    输入：nums = [1,2,0]
    输出：3
示例 2：
    输入：nums = [3,4,-1,1]
    输出：2
示例 3：
    输入：nums = [7,8,9,11,12]
    输出：1

提示：
    0 <= nums.length <= 300
    -231 <= nums[i] <= 231 - 1*/
public class LostMinPositiveNumLeeCode41 {

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int min = 1;
        if(nums == null || nums.length == 0) {
            return min;
        }
        //排序
        Arrays.sort(nums);
        for (int num : nums) {
            //如果存在，则最小缺失正整数只可能是min++
            if(num == min){
                min ++;
                continue;
            }
        }
        return min;
    }

}
