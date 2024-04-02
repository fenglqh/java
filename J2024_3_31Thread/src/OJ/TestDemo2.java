package OJ;

import java.util.HashMap;

public class TestDemo2 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
//        StringBuffer a = new StringBuffer("");
//        StringBuffer b = new StringBuffer("");
//
//        System.out.println(a.toString().equals(""));

    }
    public static String minWindow(String s, String t) {
        //把子串扔到hash表中
        int[] hash1 = new int[126];
        for(int i = 0; i < t.length(); i++) {
            hash1[t.charAt(i)] =  hash1[t.charAt(i)] + 1;
        }
        // 暴力枚举
        int right = 0, left = 0,n = t.length();
        StringBuffer ret = new StringBuffer();
        while(right < s.length()) {
            StringBuffer ret1 = new StringBuffer();
            int[] hash2 = new int[126];
            int count = 0;
            while(count < n &&  left < s.length()) {
                if(hash2[s.charAt(left)] < hash1[s.charAt(left)]) {
                    count++;
                }
                ret1.append(s.charAt(left));
                left++;
            }
            //更新结果

            StringBuffer ret2 = ret;
            if (ret2.toString().equals("")) {
                ret = ret1;
            } else {
                ret = (ret.length() < ret1.length() ? ret : ret1);
            }

            //
            right++;
        }
        return String.valueOf(ret);
    }
    public static void main2(String[] args) {
        String a = String.valueOf(new  StringBuffer());
        StringBuffer s = new StringBuffer();
        s.append("a");
        s.append("c");
        System.out.println(s.length());
        System.out.println(s);
    }
    public static void main1(String[] args) {
        int[] a = new int[10];
        String t = "abbc";
        HashMap<Character,Integer> hash1 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!hash1.containsKey(t.charAt(i))) {
                hash1.put(t.charAt(i),1);
            } else {
                hash1.put(t.charAt(i),hash1.get(t.charAt(i))+1);
            }
        }
        System.out.println("---");
    }
}
