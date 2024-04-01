package OJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDemo1 {
    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String s2 = "abc";
        System.out.println(findAnagrams(s1, s2));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        //首先将p扔到hash表里
        int[] p1 = new int[123];
        int[] s1 = new int[123];
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < p.length(); i++) {
            p1[p.charAt(i)] += 1;
        }
        int n = p.length();
        int left = 0,right = 0,k = 0;
        while(right < s.length()) {
            //进窗口
            while(k < n && left < s.length() ) {
                s1[s.charAt(left)] += 1;
                left++;
                k++;
            }
            if(Arrays.equals(s1, p1)) {
                ret.add(right);
            }
            //出窗口
            if(k >= n) {
                s1[s.charAt(right)] -= 1;
                right++;
                k--;
            } else {
                break;
            }
        }
        return ret;
    }
    public static List<Integer> findAnagrams1(String s, String p) {
// 暴力枚举加hash表
        //首先将p扔到hash表里
        int[] p1 = new int[123];
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < p.length(); i++) {
            p1[p.charAt(i)] += 1;
        }
        int n = p.length();
        //暴力枚举
        for(int j = 0; j < s.length(); j++ ) {
            int[] s1 = new int[123];
            for(int k = 0,d = j; k < n && d < s.length(); k++) {
                s1[s.charAt(d++)] += 1;
            }
            if(Arrays.equals(s1, p1)) {
                ret.add(j);
            }
        }
        return ret;
    }
    public static void main1(String[] args) {
        int[] p1 = new int[123];
        int[] a = {2,2,2};
        int[] b = {2,2,2};
        System.out.println(Arrays.equals(a, b));
        String p = "abcdd";
        for(int i = 0; i < p.length(); i++) {
            p1[p.charAt(i)] += 1;
        }
        System.out.println(p1);
    }
}
