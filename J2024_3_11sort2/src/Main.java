import java.util.*;

public class Main {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> back = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length -2) {
            if (nums[i] > 0) {
                break;//还可以优化，当i是正数时，在后面是找不到小于0的数的
            }
            int target = -nums[i];
            int left = i+1, right = nums.length-1;
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    List<Integer> ret = new ArrayList<>();
                    ret.add(nums[i]);
                    ret.add(nums[left]);
                    ret.add(nums[right]);

                    back.add(ret);
//                    int tmp = nums[left++];
//                    while(left < right && tmp == nums[left]) left++;//注意点，小范围循环，还要在注意一下范围
                    left++;
                    while(left < right && nums[left] == nums[left-1]) left++;//注意点，小范围循环，还要在注意一下范围
                    right--;
                    while(left < right && nums[right] == nums[right+1]) right--;//细节，比较的时候要和上一个数比，而不是和下一个数比
                }
            }
//            int tmp = nums[i];

//            while(i < nums.length-1 &&  nums[i+1] == nums[i]) i++;
//            i++;
            i++;
            while(i < nums.length-1 && nums[i] == nums[i-1]) i++;
        }
        return back;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
    public static ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        int left = 0;
        int right = array.length-1;
        ArrayList<Integer> ret = new ArrayList<>();
        while(left < right) {
            int tmp = array[left] + array[right];
            if(tmp > sum) {
                right--;
            } else if(tmp < sum) {
                left++;
            } else{
                ret.add(array[left]);
                ret.add(array[right]);
                break;
            }
        }


        return ret;
    }

    public static void main6(String[] args) {
        int[] arr = {1,2,4,7,11,15};
//        ArrayList<Integer> a = FindNumbersWithSum(arr, 15);
//        System.out.println(a);
        //突然想到一个点 数组能比较吗
        int[] arr1 = {-1,0,1};
        int[] arr2 = {-1,0,1};
        System.out.println(arr1 == arr2);//false
        System.out.println(Arrays.equals(arr1, arr2));//true
        int[] arr3 = {-1,1,0};
        System.out.println(Arrays.equals(arr3, arr1));//false
    }
//    LeetCode611 暴力解法
    public static int triangleNumber(int[] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length-2; i++) {
        for (int j = i + 1; j < nums.length-1; j++) {
            for (int k = j+1; k < nums.length; k++) {
                if (nums[i] + nums[j] > nums[k] &&
                        nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i]) {
                    sum += 1;
                }
            }

        }
    }

    return sum;
}

    public static void main5(String[] args) {
        int arr[] = {2,2,3,4};
        System.out.println(triangleNumber(arr));
    }
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
    public static void main4(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        maxArea(arr);
    }
}
