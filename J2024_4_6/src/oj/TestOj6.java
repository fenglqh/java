package oj;

import java.util.HashMap;

public class TestOj6 {
    public static void main(String[] args) {
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
