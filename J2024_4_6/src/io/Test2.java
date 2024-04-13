package io;

public class Test2 {
    /**
     * 0~n-1中缺失的数字
     * 二分查找法
     * @param arr
     * @return
     */
    public static int find_missing_value_index(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid) left = mid + 1;
            else  right = mid;
        }
        if (arr[left] == left) return left + 1;
        return left;
    }

    //哈希表，直接遍历找结果，位运算，数学（高斯求和公式） 其他四种解法
    public static void main(String[] args) {
        int[] arr = {0,1,4,5};
        int[] arr1 = {0,1,2,3};
        System.out.println(find_missing_value_index(arr));
        System.out.println(find_missing_value_index(arr1));
    }
}
