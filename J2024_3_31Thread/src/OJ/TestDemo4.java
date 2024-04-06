package OJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 再解决串联所有单词的子串卡壳了，于是打算把它的基础题（438. 找到字符串中所有字母异位词）再来一遍，再处理这道题
 */
public class TestDemo4 {

    public static void main(String[] args) {
        String s = "aaa";
        String[] words = {"aa","aa"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        // 把words放到hash表中
        HashMap<String,Integer> hash1 = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(!hash1.containsKey(words[i])) {
                hash1.put(words[i],1);
            } else {
                hash1.put(words[i], hash1.get(words[i]) + 1);
            }
        }
        //把s字符转变为数组这样比较方便
        int n = words[0].length();

        List<Integer> ret = new ArrayList<>();
        for(int b = 0; b < words[0].length(); b++) {
            String[] ss = new String[(s.length()-b)/n];

            int i = b,j=0;
            while(i+n <= s.length()) {
                ss[j++] = s.substring(i, i+n);
                i+=n;
            }
            HashMap<String,Integer> hash2 = new HashMap<>();
            for(int right = 0, left = 0, count = 0; right < ss.length; right++) {
                //进窗口
                if (right - left + 1 <= words.length) {
                    //先判断hash2里有没有，没有就加
                    if (!hash2.containsKey(ss[right])) {
                        hash2.put(ss[right], 1);
                    } else {
                        hash2.put(ss[right],hash2.get(ss[right]) + 1);
                    }
                    // 判断在不在hash1里
                    if (hash1.containsKey(ss[right])) {
                        if (hash2.get(ss[right]) <= hash1.get(ss[right]) ) count++;
                    }
                }
                //判断，更新结果
                if(count == words.length) ret.add(left*words[0].length() + b);
                //出窗口
                if (right - left + 1 == words.length) {
                    //判断在不在hash1里
                    if (hash1.containsKey(ss[left])) {
                        if (hash2.get(ss[left]) <= hash1.get(ss[left])) count--;
                    }
                    hash2.put(ss[left],hash2.get(ss[left]) - 1);
                    left++;
                }
            }


        }
        return ret;

    }
    public static void main2(String[] args) {
        String s = "barfoothefoobarman";
        int n = 3;
        int b = 1;
        String[] ss = new String[(s.length()-b)/(n)];
        int deadline = s.length();
        if (b != 0) {
            deadline = s.length() - (n - b);
        }
        for (int i = b,j = 0; i <= deadline; i+=n) {
            ss[j++] = s.substring(i, i+n);
        }
        System.out.println(ss.length);
        System.out.println("--");
    }
    public static void main1(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }
    public static List<Integer> findAnagrams(String s, String p) {
        //变成字符数组更容易操作
        char[] pp = p.toCharArray();
        char[] ss = s.toCharArray();
        //需要两个hash表来记录字符的个数
        int[] hash1 = new int[26];
        for(int i = 0; i < pp.length; i++) {
            hash1[pp[i] - 'a'] = hash1[pp[i] -'a'] + 1;
        }
        int[] hash2 = new int[26];
        //需要一个返回值
        List<Integer> ret = new ArrayList<>();
        //count来记录有效数据
        for (int right = 0, left = 0, count = 0; right < ss.length; right++) {
            //进窗口
            if (right - left + 1 <= pp.length) {
                char in = ss[right];
                if (hash2[in - 'a']++ < hash1[in - 'a']) count++;
            }
            //判断更新结果
            if (count == pp.length) ret.add(left);
            //出窗口
            if (right - left + 1 == pp.length) {
                char out = ss[left++];
                if (hash2[out - 'a']-- <= hash1[out - 'a']) count--;
            }

        }
        return ret;

    }
}
