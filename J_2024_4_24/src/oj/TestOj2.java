package oj;

import java.util.Arrays;
import java.util.List;

public class TestOj2 {
    public static void main(String[] args) {
//        试一下字符串替换
        String a = "ab?c?";
//        a = a.replace('?','a');
        // String是不可变类型，所以会在创建一个对象出来
//        a = a.replaceFirst(a,"");
        List<String> list = Arrays.asList(a);
//        for (String s : list) {
//            System.out.println(s);
//        }
        System.out.println(list);
        char[] charArray = a.toCharArray();
        String s = String.valueOf(charArray);
//        char c = Character.valueOf(charArray[0] + 1);
//        System.out.println(c);
        char c = charArray[0];
        char b = c;

    }
}
