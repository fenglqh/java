package arrayList;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        String 底层有的是byte[]有的是char[]具体情况是啥？
        String s = "pwwkew";
//        String s = "dvdf";

        System.out.println(lengthOfLongestSubstring(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        // 定义变量
        int left = 0, right = 0, len = Integer.MIN_VALUE;
        HashSet<Character> h = new HashSet<>();
        for( ; left < s.length(); ) {
            //进窗口
            while(right < s.length() && !h.contains(s.charAt(right))) {
                h.add(s.charAt(right));
                right++;
            }
            // 更新结果
            len = Math.max(len, right - left);
            //出窗口  r必然是等于重复的元素的
            while(right < s.length()) {
                h.remove(s.charAt(left));
                if (s.charAt(left) == s.charAt(right)) {
                    break;
                }
                left++;

            }
            left++;
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int len = Integer.MIN_VALUE;
        for(int left = 0; left < s.length(); ) {
            //进窗口
            int right = left + 1;
            HashSet<Character> ret = new HashSet<>();
            ret.add(s.charAt(left));
            while(right < s.length() && !ret.contains(s.charAt(right))) {
                ret.add(s.charAt(right));
                right++;
            }
            //出窗口
            len = Math.max(len, right - left);
            while(right < s.length() && s.charAt(left) != s.charAt(right)) {//xijie
                left++;
            }
            left++;
        }
        return len = len == Integer.MIN_VALUE ? 0 : len;
    }
    public static int lengthOfLongestSubstring1(String s) {
// 暴力枚举
        int len = Integer.MIN_VALUE;
        for(int left = 0; left < s.length(); left++) {
            HashSet<Character> h = new HashSet<>();
            h.add(s.charAt(left));
            len = Math.max(len, 1);
            int right = left + 1;
            for(; right < s.length(); right++) {
                if (h.contains(s.charAt(right))) {
                    break;
                } else {
                    h.add(s.charAt(right));
                }

            }
            len = Math.max(len,right-left);
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }
    public static void main2(String[] args) {
        int target = 15;
        int[] nums = {1,2,3,4,5};
        int[] nums1 = {2,3,1,2,4,3};
        int[] nums2 = {12,28,83,4,25,26,25,2,25,25,25,12};
        int t = 213;
        t = Integer.MAX_VALUE;
        String a = "aa";
        a.length();
        HashMap<Character,Integer> h = new HashMap<>();
        HashSet<Character> h1 = new HashSet<>();

        h.put(a.charAt(1),1);
        Integer integer = h.get(a.charAt(1));
        System.out.println(minSubArrayLen(7, nums1));
    }
    public static int minSubArrayLen(int target, int[] nums) {//题解代码，不大懂
        int n = nums.length, sum = 0,len = Integer.MAX_VALUE;
        for(int left = 0, right = 0; right < n; right++) {
            //近窗口
            sum += nums[right];
            //判断条件
            while(sum >= target) {//只要最后你进去了，根据单调性，一定比target大，大就一直循环，left一直动
                //看看啥时出窗口
                len = Math.min(len, right - left + 1);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
    public static int minSubArrayLen2(int target, int[] nums) {
        int left = 0, right = 1, sum = nums[left], len = 0, n = nums.length;//len 可以等于Integer.MAX_VALUE
        while(left < n) {
            while(right < n) {
                if(sum < target) {
                    sum += nums[right];
                    right++;
                } else {
                    break;
                }
            }
            if (len == 0) {
                if (sum < target) return len;
                else len = right - left;
            } else {
                if (sum >= target) len = Math.min(len, right-left);
            }
            sum = sum - nums[left++];
        }
        return len;
    }
    public static int minSubArrayLen1(int target, int[] nums) {
        // 暴力枚举
        int left = 0;
        int len = 0;
        while (left < nums.length) {
            int right = left+1;
            int sum = nums[left];
            while (right < nums.length) {
                if (sum < target) {
                    sum += nums[right];
                    right++;
                } else {

                    break;
                }
            }
            if(sum >= target) {
                if (len == 0) {
                    len = right - left;
                } else {
                    len = Math.min(len,right-left);
                }
            }
            left++;

        }
        return len;
    }
    public static void main1(String[] args) {
        MyArraylist myArraylist = new MyArraylist();
        myArraylist.add(0);
        myArraylist.add(1);
        myArraylist.add(2);
        myArraylist.add(3);
        myArraylist.display();
//        myArraylist.add(3,9);
//        myArraylist.display();
        System.out.println(myArraylist.contains(3));
        System.out.println(myArraylist.indexOf(9));
//        System.out.println(myArraylist.get(9));
        myArraylist.set(1,2);
        myArraylist.display();
        myArraylist.remove(4);
        myArraylist.display();
        System.out.println(myArraylist.size());
        myArraylist.clear();
//        myArraylist.add(6,9);

        myArraylist.display();

    }
}
