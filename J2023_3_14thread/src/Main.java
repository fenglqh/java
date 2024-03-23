import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] a = {3,2,20,1,1,3};
//        int[] a= {
//                5207,5594,477,6938,8010,7606,2356,6349,3970,751,5997,6114,9903,3859,6900,7722,2378,1996,8902,228,4461,90,7321,7893,4879,9987,1146,8177,1073,7254,5088,402,4266,6443,3084,1403,5357,2565,3470,3639,9468,8932,3119,5839,8008,2712,2735,825,4236,3703,2711,530,9630,1521,2174,5027,4833,3483,445,8300,3194,8784,279,3097,1491,9864,4992,6164,2043,5364,9192,9649,9944,7230,7224,585,3722,5628,4833,8379,3967,5649,2554,5828,4331,3547,7847,5433,3394,4968,9983,3540,9224,6216,9665,8070,31,3555,4198,2626,9553,9724,4503,1951,9980,3975,6025,8928,2952,911,3674,6620,3745,6548,4985,5206,5777,1908,6029,2322,2626,2188,5639};
//        int x = 565610;
        int x = 10;
        System.out.println(minOperations(a, x));

    }
    public static int minOperations(int[] nums, int x) {
        // 滑动窗口法
        // 数组求和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // 定义变量
        int target = sum - x;
        int count = 0, len = 0;
        for(int right = 0, left = 0; right < nums.length; ) {
            // 入窗口
            if (count < target) {
                count+= nums[right];
                right++;
            } else if (count == target) {
                // 更新结果
                len = Math.max(len,right - left);
                // 出窗口
                count -= nums[left];
                left = right - 1;
                right++;
            } else {
                count -= nums[left];
                left = right - 1;
                right++;
            }
        }
        return len == 0 ? -1 : nums.length - len;
    }
//    该方法行不通，因为如果两边相等，但是减去一个后，x比减去的数小，这样就无法判断改减去哪边
    public static int minOperations2(int[] nums, int x) {
// 暴力解法
        int left = 0, right = nums.length - 1, count = 0;
        while(left <= right) {
            if(nums[left] > x && nums[right] > x) break;
            if(nums[left] < x && nums[right] > x) {
                x -= nums[left];
                count++;
                left++;
                continue;
            }
            if(nums[left] > x && nums[right] < x) {
                x -= nums[right];
                count++;
                right--;
                continue;
            }
            if(nums[left] > nums[right]) {
                x -= nums[left];
                left++;
                count++;
                continue;
            } else{
                x -= nums[right];
                right--;
                count++;
                continue;
            }
        }
        return x > 0 ? -1 : count;
    }
    public static void main3(String[] args) {
       int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
       int k = 2;
        System.out.println(longestOnes(arr, k));
    }
    public static int longestOnes(int[] nums, int k) {
        // 滑动窗口法，基于暴力枚举的优化
        // 定义变量
        int left = 0, right = 0, zero = 0, len = 0;
        while(left < nums.length) {
            // 进窗口
            while(right < nums.length) {
                // 出窗口判断
                if(nums[right] == 0 && zero >= k) break;
                if(nums[right] == 0) zero++;
                right++;
            }
            // 更新结果
            len = Math.max(len, right - left);
            // 出窗口
            while(zero >= k) {
                if(left >= nums.length) break;
                if(nums[left] == 0) zero--;
                left++;
            }
            //特殊情况
            if (right >= nums.length) {
                len = Math.max(len, right - left);
                break;
            }
        }
        return len;
    }
    public static int longestOnes1(int[] nums, int k) {
        // 暴力枚举
        int len = 0;
        for (int left = 0; left < nums.length; left++) {
            int right = left;
            int zero = 0;
            while (right < nums.length) {
                if (nums[right] == 0 && zero >= k) break;
                if (nums[right] == 0) zero++;
                right++;
            }
            len = Math.max(len, right - left);
        }
        return len;
    }
    public static void main2(String[] args) {
        int n = 1;
        Random random = new Random();
        Random random1 = new Random();
        System.out.println("R:"+random.nextInt(10));
        System.out.println("R1:"+random1.nextInt());
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        int a = 0;
        while(a < nums.length-3) {
            int b = a + 1;
//            int t = target - nums[a] - nums[b];
            while(b < nums.length-2) {
                long sum = (long)nums[a] + (long)nums[b];
                long t = (long)target - sum;
                int left = b + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long tmp = nums[left] + nums[right];
                    if(tmp > t) {right--;}
                    else if(tmp < t) {left++;}
                    else {
//                        ret.add(list);
                        ret.add(new ArrayList<Integer>(Arrays.asList(nums[a],nums[b],nums[left],nums[right])));
                        left++;
                        while(left < right && nums[left-1] == nums[left] ) left++;
                        right--;
                        while(left < right && nums[right+1] == nums[right]) right--;
                    }
                }
                b++;
                while(b < nums.length-2 && nums[b-1] == nums[b] ) b++;

            }
            a++;
            while(a < nums.length-2 && nums[a-1] == nums[a] ) a++;
        }
        return ret;
    }

    public static void main1(String[] args) {
        int[] a = {1000000000,1000000000,1000000000,1000000000};
//        System.out.println(-294967296L-2000000000L);
        System.out.println(fourSum(a, -294967296));
    }
}
