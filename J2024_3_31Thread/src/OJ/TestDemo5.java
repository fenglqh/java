package OJ;

public class TestDemo5 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        //把t子串扔到hash表里
        int[] hash1 = new int[126];
        for (int i = 0; i < t.length(); i++) {
            hash1[t.charAt(i)] += 1;
        }
        int[] hash2 = new int[126];
        String ret = "";
        int left = 0, right = 0, count = 0, n = t.length();
        while(left < s.length()) {
            //进窗口
            if (count < n && right < s.length()) {
                if (hash2[s.charAt(right)]++ < hash1[s.charAt(right)]) count++;
                right++;
            }
            //判断更新结果
            if (count == n) {
                String a = s.substring(left, right);
                // ret = s.substring(left, right);
                if (ret.equals("")) {
                    ret = a;
                } else {
                    ret = ret.length() > a.length() ? a : ret;
                }
            }
            // 出窗口
            if (count >= n || right >= s.length()) {
                if (hash2[s.charAt(left)]-- <= hash1[s.charAt(left)]) count--;
                left++;
                while (left < s.length() && hash2[s.charAt(left)] > hash1[s.charAt(left)] ) {
                    left++;
                }
            }

        }
        return ret;
    }
    public static void main1(String[] args) {
        String s = "";
        String a = "asa";
        StringBuffer ss = new StringBuffer("");
        String substring = a.substring(0, 1);
        s = substring;
        System.out.println(s);
    }
}
