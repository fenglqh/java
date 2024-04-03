package OJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestDemo3 {
    public static void main(String[] args) {

    }
    public List<Integer> findSubstring(String s, String[] words) {
        // 把words放到hash表中
        HashMap<String,Integer> hash1 = new HashMap<>();
        for(String w : words) hash1.put(w,0);
        //把s字符转变为数组这样比较方便
        int n = words[0].length();
        String[] ss = new String[s.length()/n+1];
        for (int i = 0,j = 0; i < s.length(); i+=n) {
            ss[j++] = s.substring(i, i+n);
        }
        List<Integer> ret = new ArrayList<>();
        for(int right = 0,left = 0,count = 0; right < ss.length; right++) {
            //进窗口
            while(right - left + 1 < words.length) {
                if(hash1.containsKey(ss[right]) && count < words.length) {
                    if(hash1.get(ss[right]) == 0) {
                        hash1.put(ss[right],hash1.get(ss[right])+1);
                        count++;
                    } else {
                        right++;
                    }
                } else {
                    right++;
                    break;
                }
            }
            //更新
            if(count >= words.length) {
                ret.add(left);
            }
            // 出窗口

            hash1.put(ss[left],hash1.get(ss[left])-1);
            left++;
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
