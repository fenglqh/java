package oj;

import java.util.Arrays;
import java.util.HashMap;

public class TestOj6 {
    public static void main(String[] args) {
        int[][] arr = {{67,64,78},{99,98,38},{82,46,46},{6,52,55},{55,99,45}};
        int[][] ints = matrixBlockSum(arr, 1);
        System.out.println("---");
    }
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] dp = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i+1][j+1] = dp[i+1][j] + dp[i][j+1] - dp[i][j] + mat[i][j];
            }
        }
        int[][] answer = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int m1 = Math.max(i-k, 0) + 1;
                int n1 = Math.max(j-k, 0) + 1;
                int m2 = Math.min(i+k, mat.length - 1) + 1;
                int n2 = Math.min(j+k, mat[0].length - 1) + 1;
                answer[i][j] = dp[m2][n2] - dp[m2][n1-1] - dp[m1-1][n2] + dp[m1-1][n1-1];
            }
        }

        return answer;
    }
    public static int hammingWeight(int n) {
        int count = 0;
        while ((n & (-n)) != 0) {
            count++;
            n = n & (n - 1);//干掉0
        }
        return count;
    }
    public static void main2(String[] args) {
        int[] arr = {0,1};
        System.out.println(findMaxLength(arr));
    }
    public static int findMaxLength(int[] nums) {
        // 转换成和0的子数组问题

        HashMap<Integer, Integer> h = new HashMap<>();
        int sum = 0, ret = 0;
        h.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) sum += -1;
            else sum += nums[i];
            int x = h.getOrDefault(sum, i);
            ret = Math.max(ret, i-x);
            h.put(sum, h.getOrDefault(sum, i));
        }
        return ret;
    }
    public static void main1(String[] args) {
        int[] h = {-1,2,9};
        int k = 2;//预期结果是2
        System.out.println(subarraysDivByK(h, k));
    }
    public static int subarraysDivByK(int[] nums, int k) {
        // 哈希表
        HashMap<Integer, Integer> h = new HashMap<>();
        // 特殊情况
        h.put(0,1);
        int sum = 0, ret = 0;
        for (int x : nums) {
            sum += x;
            ret += h.getOrDefault((sum % k + k) % k, 0);
            h.put((sum % k + k) % k, h.getOrDefault((sum % k + k) % k , 0)+1);
        }
        return ret;
    }
}
