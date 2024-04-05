package OJ;

import java.util.*;

public class TestDemo3 {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};
        List<Integer> substring = findSubstring(s, words);
        System.out.println(substring);

    }
    public static List<Integer> findSubstring(String s, String[] words) {
        // 把words放到hash表中
        HashMap<String,Integer> hash1 = new HashMap<>();
        for(String w : words) hash1.put(w,0);
        //把s字符转变为数组这样比较方便
        int n = words[0].length();
        String[] ss = new String[s.length()/n];
        for (int i = 0,j = 0; i < s.length(); i+=n) {
            ss[j++] = s.substring(i, i+n);
        }
        List<Integer> ret = new ArrayList<>();
        //这里的right和left就是指ss数组的下标，right指向将要被判断的子串的下标,count用来记住有效连续判断了多少次
        for(int right = 0,left = 0,count = 0; right < ss.length; right++) {
            //进窗口
            if(count < n) {
                if (!hash1.containsKey(ss[right])) {
                    count = 0;
                    left = right+1;
                    continue;
                }
                hash1.put(ss[right],hash1.get(ss[right])+1);
                if (hash1.get(ss[right]) > 1) {
                    left = right;
                    for(String w : words) hash1.put(w,0);
                    hash1.put(ss[right],1);
                    continue;
                }
                count++;
            }

            if (right - left + 1 > n) {
                left++;
                hash1.put(ss[left],hash1.get(ss[left])-1);
                count--;
            }
            //判断
            if (count == n) ret.add(left);


        }
        return ret;

    }
    public static void main1(String[] args) {
        String[] a = {"aaa","bbb"};
        String c = "abcacbabc";
        String[] ret = new String[c.length()/3+1];
        for (int i = 0,j = 0; i < c.length(); i+=3) {
            String substring = c.substring(i, i+3);
            ret[j++] = substring;
        }
        System.out.println(ret);
    }
}
