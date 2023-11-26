package oj;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Solution01 {
//    以下的解题有bug只能解决部分问题
//    public static int removeElement(int[] nums, int val) {
//
//        int i = 0;
//        int j = nums.length - 1;
//
//        while (i < j ) {
//            while (nums[j] == val && i != j) {
//                j--;
//            }
//            while (nums[i] != val && i != j) {
//                i++;
//
//            }
//            if(i == 0 && nums[i] == val) {
//                return 0;
//            }
//            int temp = 0;
//            temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//            i++;
//            j--;
//            if (i == j && nums[i] != val) {
//                return i + 1;
//            }
//        }
//        return i;
//    }

    private static void swap(int[] a, int pos1, int pos2) {
        int temp = 0;
        temp = a[pos1];
        a[pos1] = a[pos2];
        a[pos2] = temp;
    }
    //参考别人的代码重新写一下
    public static int removeElement(int[] nums,int val) {
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if(nums[i] == val) {
                swap(nums,i--,j--);
            }
            i++;

        }
        return j + 1;
    }
    public static void main(String[] args) {
        int[] a = {3,3};
        System.out.println(removeElement(a, 3));
        for (int i = 0; i < removeElement(a, 3);i++) {
            System.out.print(a[i] + " ");
        }

    }
}
