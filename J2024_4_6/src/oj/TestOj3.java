package oj;

public class TestOj3 {
    public static void main(String[] args) {
        int[] arr = {3,4,2,1};
        System.out.println(findMin(arr));
    }

    /**
     * 基准值为最左边时,是不可以的因为无法处理，单调递减的情况
     * 最主要的问题是right有的时候还没判断呢，right就走了
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int pre = 0;
        int left = 0, right = nums.length - 1; // 注意点1，左右别搞反了
        while (left < right) {
            if (nums[pre] < nums[nums.length - 1]) return nums[pre];//处理边界情况,单调递增
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[pre]) left = mid + 1;// +还是-别搞错
            else right = mid;
        }
        return nums[right];
    }
    /*
    基准值为最右边时
     */
    public static int findMin1(int[] nums) {
        int last = nums.length - 1;
        int left = 0, right = last;// 注意点1，左右别搞反了
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[last]) left = mid + 1;// +还是-别搞错
            else right = mid;
        }
        return nums[right];
    }
}
