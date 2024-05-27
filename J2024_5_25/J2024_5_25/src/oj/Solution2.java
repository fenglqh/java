package oj;

import java.util.HashMap;
import java.util.HashSet;

public class Solution2 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        boolean contains = hs.contains(1);
        System.out.println(contains);
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 2);
        hm.containsKey(1);
        hm.get(1);

    }
    public int[] test() {
        return new int[]{1,2,3,4,5,6,7,8,9};
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (h.containsKey(nums[i]) && Math.abs(h.get(nums[i]) - i) <= k) {
                return true;
            }
            h.put(nums[i],i);
        }
        return false;
    }
}
