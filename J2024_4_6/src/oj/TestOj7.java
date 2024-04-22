package oj;

import java.util.Arrays;

public class TestOj7 {
    public static void main(String[] args) {
//        int x = 3;
//        if ((( x >> 1) & 1) == 0) {
//
//        }
//        System.out.println(x);
        String s = "leetcode";
        System.out.println(isUnique(s));
    }
    public static boolean isUnique(String astr) {
// 位图
        // 根据鸽巢原理优化
        if (astr.length() > 26) return false;
        int bitMap = 0;//用来标记信息
        for(int i = 0; i < astr.length(); i++) {
            int n = astr.charAt(i) - 'a';
            if (((bitMap >> n) & 1) == 0) bitMap = (1 << n) | bitMap;//查询和修改比特位
            else return false;
        }
        return true;
    }
    public static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int x : nums) xor = (xor ^ x);
        int lowbit = xor & (-xor);
        int m = 0, n = 0;
        for (int x : nums) {
            if ((( x >> lowbit) & 1) == 0)  {
                m = (m ^ x);
            }
          else {
                n = (n ^ x);
            }
        }
        int[] ans = {m,n};
        return ans;
    }
    public static void main2(String[] args) {
//        System.out.println(1 ^ 4);
        System.out.println(3 ^ 5);

    }
    public static void main1(String[] args) {
        int n = 2;
        System.out.println(Arrays.toString(countBits(n)));
    }
    public static int[] countBits(int n) {
        int[] ans = new int[n+1];
        // 1.先提取1
        // 2.干掉1
        for (int i = 0; i <= n; i++) {
            int ret = 0, flag  = i;
            while((flag & (-flag)) != 0) {//注意这里的&优先级大于！=，总之对于不清楚优先级的操作符，能加括号就加括号
                ret++;
                flag &= (flag - 1);
            }
            ans[i] = ret;
        }
        return ans;
    }
}
