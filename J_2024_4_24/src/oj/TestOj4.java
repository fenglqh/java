package oj;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class TestOj4 {
    public static void main(String[] args) {
//        LinkedList list = new LinkedList();
//        Object o = list.get(0);
        LinkedHashMap<Character, Integer> hm = new LinkedHashMap<>();
        hm.put('a', 1);
        hm.put('r', 2);
        hm.put('c', 3);
        Integer a = hm.get('a'-1);
//        System.out.println(a);
        String a1 = "croak";
        System.out.println(a1.indexOf('c'));
        System.out.println(a1.indexOf('a'));

    }

}
