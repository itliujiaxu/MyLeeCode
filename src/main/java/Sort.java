public class Sort {

    public static void main(String[] args) {
        int[] nums = {3,2,6,7,2,1,0};
        //maopao(nums);
        //quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    //快排
    public static void quickSort(int[] nums,int left,int right){
        if(left>=right){
            return;
        }
        int i = left,j = right;
        int helper = nums[left];
        while(i<j){
            while (nums[j] >= helper && i<j){
                j--;
            }
            while (nums[i] <= helper && i<j){
                i++;
            }
            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[left] = nums[i];
        nums[i] = helper;
        quickSort(nums,left,i-1);
        quickSort(nums,i+1,right);
    }
    //冒泡排序
    public static void maopao(int[] nums){

        for(int i = 0;i<nums.length-1;i++){
            boolean flag = false;
            for(int j = 0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
}
