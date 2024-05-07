package oj;

import java.util.*;

public class TestOj4 {
    public static void main(String[] args) {
        String s = "a##c";
        String t = "#a#c";
        System.out.println(backspaceCompare(s, t));
    }
    public static boolean backspaceCompare(String ss, String tt) {
        int s = ss.length() - 1, t = tt.length() - 1;
        while(s >= 0 && t >= 0) {
            if (ss.charAt(s) != tt.charAt(t)) return false;
            // 处理连续两个都是#的情况

            if (ss.charAt(s) != '#') {
                s--;
                while (s >= 0 && ss.charAt(s) == '#') s -= 2;
            }
            else {
                s -= 2;
                while (ss.charAt(s + 1) == '#') s -= 2;
                while (s >= 0 && ss.charAt(s) == '#') s -= 2;
            }

            if (tt.charAt(t) != '#') {
                t--;
                while (t >= 0 && tt.charAt(t) == '#') t -= 2;
            }
            else {
                t -= 2;
                while (tt.charAt(t + 1) == '#') t -= 2;
                while (t >= 0 && tt.charAt(t) == '#') t -= 2;
            }
        }
        if (s != t) return false;
        return true;
    }
    public static void main3(String[] args) {
//        int[] n = {-74,48,-20,2,10,-84,-5,-9,11,-24,-91,2,-71,64,
//                63,80,28,-30,-58,-11,-44,-87,-22,54,-74,-10,-55
//                ,-28,-46,29,10,50,-72,34,26,25,8,51,13,30,35,-8,50,
//                65,-6,16,-2,21,-78,35,-13,14,23,-3,26,-90,86,25,-56
//                ,91,-13,92,-25,37,57,-20,-69,98,95,45,47,29,86,-28
//                ,73,-44,-46,65,-84,-96,-24,-12,72
//                ,-68,93,57,92,52,-45,-2,85,-63,56,55,12,-85,77,-39};
        int[] n = {3,2,1,5,6,4};
        int[] ints = sortArray(n);
//        return new int[]{1,2};
        System.out.println(Arrays.toString(ints));
    }
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

//    private static int[] partion1(int[] nums, int start ,int end) {
////        int r = new Random().nextInt(100);
////        int key = nums[r % (end - start + 1) + start];
//        int key = nums[start + (end - start) / 2];
//        int left =  start - 1,right = end+1;
//        for (int i = start; i < right; ) {
//            if (nums[i] == key) i++;
//            else if (nums[i] < key) swap(nums, ++left, i++);
//            else if (nums[i] > key) swap(nums, --right, i);
//        }
//        int[] ret = {left,right};
//        return ret;
//    }
    private static void deal(int[] nums, int start, int end) {
        if (start >= end) return;
//        int key = nums[start + (end - start) / 2];
        int key = nums[new Random().nextInt(end - start + 1) + start];
        int left =  start - 1,right = end+1;
        for (int i = start; i < right; ) {
            if (nums[i] == key) i++;
            else if (nums[i] < key) swap(nums, ++left, i++);
            else if (nums[i] > key) swap(nums, --right, i);
        }
        deal(nums,start, left);
        deal(nums,right, end);

    }
    public static int[] sortArray(int[] nums) {
        deal(nums, 0 ,nums.length-1);
        return nums;
    }
    public static void main2(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
        int left = -1, right = nums.length, i = 0;
        while(i < right) {
            if (nums[i] == 0) {
                int tmp = nums[left + 1];
                nums[left + 1] = nums[i];
                nums[i] = tmp;
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2){
                int tmp = nums[right - 1];
                nums[right - 1] = nums[i];
                nums[i] = tmp;
                right--;

            }
        }
    }
    public static void main1(String[] args) {
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
