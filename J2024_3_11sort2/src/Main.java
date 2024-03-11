public class Main {
    //leetcode 34用两个二分查找
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int[] ret = {-1, -1};
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                ret[0] = mid;
                right = mid - 1;
            }
        }
        left = 0;
        right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                ret[1] = mid;
                left = mid + 1;
            }
        }
        return ret;
    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1;
        int sum = 0;

        while(left < right) {
            int width = right - left;
            int hig = Math.min(height[left], height[right]);
            int v = width * hig;
            if(v > sum) sum = v;
            if(height[left] > height[right]) {
                right--;
            } else{
                left++;
            }
        }
        return sum;
    }
//    暴力枚举
    public static int maxArea1(int[] height) {
        int len = height.length;
        int sum = 0;
        for(int i = 0; i < len-1 ;i++) {
            for(int j = i+1; j < len; j++) {
                int temp = (j-i) * minN(height[i],height[j]);
                if (temp > sum) sum = temp;
            }
        }

        return sum;
    }
    private static int minN(int a, int b) {
        return a > b ? b : a;
    }
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        maxArea(arr);
    }
}
