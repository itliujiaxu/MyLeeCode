/*4. 寻找两个正序数组的中位数
        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
        示例 1：
            输入：nums1 = [1,3], nums2 = [2]
            输出：2.00000
            解释：合并数组 = [1,2,3] ，中位数 2*/
public class FindMedianSortedArrays4 {

    public static void main(String[] args) {
        FindMedianSortedArrays4 fmsa = new FindMedianSortedArrays4();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(fmsa.findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean flag = true;
        int len = len1 + len2;
        if(len%2 == 1){
            flag = false;
        }
        int[] mergeNums = new int[len];
        int p = len1-- + len2-- - 1;
        while(len1 >= 0 || len2 >= 0){
            if(len1 >= 0 && len2 >= 0){
                mergeNums[p--] = nums1[len1]>nums2[len2] ? nums1[len1--] : nums2[len2--];
            }else if(len1 >= 0){
                mergeNums[p--] = nums1[len1--];
            }else{
                mergeNums[p--] = nums2[len2--];
            }
        }
        if(flag){
            return (double)(mergeNums[len/2] + mergeNums[len/2 - 1])/2;
        }else{
            return mergeNums[len/2];
        }
    }
}
