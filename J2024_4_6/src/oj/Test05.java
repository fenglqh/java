package oj;

import java.util.Arrays;
import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {
        int[] arr = {1};
//        System.out.println(subarraySum(arr,0));
    }
    public int subarraySum(int[] nums, int k) {
        //滑动窗口法不可以，得要有单调性
        //1.定义变量
        int right = 0, left = 0, n = nums.length, ret = 0, count = 0;
        for (; left < n; left++) {
            //2.进窗口
            while (count < k && right < n) count += nums[right++];
            // 3.更新结果
            if (count == k) ret += 1;
            if (count >= k) count -= nums[left];
        }
        return ret;
    }
    public static void main3(String[] args) {
        int[] arr = {1,2,3,4};
        int[] ints = productExceptSelf(arr);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
        f[0] = 1;// 细节
        for (int i = 1; i < n; i++) {
            f[i] = f[i-1] * nums[i-1];
        }
        g[n-1] = 1;
        for (int i = n-2; i >= 0 ; i--) {
            g[i] = g[i+1] * nums[i+1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = f[i] * g[i];
        }
        return ret;
    }
    public static void main2(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
        // 初始化数组
        long[][] arr = new long[n + 1][m + 1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {//注意循环终止的条件，否则会发生数组越界，
                // 因为该进入初始化的数据被下面的逻辑读取了
                long ret = in.nextLong();
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] + ret - arr[i - 1][j - 1];
            }
        }
        // 使用前缀矩阵和
        while (q > 0) {
            int x1 = in.nextInt(), y1 = in.nextInt(), x2 = in.nextInt(), y2 = in.nextInt();
            long x = arr[x2][y2] - arr[x1 - 1][y2] - arr[x2][y1 - 1] + arr[x1 - 1][y1 - 1];
            System.out.println(x);
            q--;
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        // 1. 读入数据
        int n = in.nextInt(), q = in.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n+1; i++) arr[i] = in.nextInt() + arr[i-1];
        // 2. 数组

        while(q > 0) {
            int left = in.nextInt();
            int right = in.nextInt();
            System.out.println(arr[right] - arr[left - 1]);
            q--;
        }

    }
}
