package oj;

public class TestOj2 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr));
    }
    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < nums[mid - 1]) right = mid - 1;//关键还是分析出怎么去收缩区间，这边是从左边开始收缩区间
            else left = mid;
        }
        return right;
    }
}
