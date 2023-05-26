import java.util.Arrays;

public class Test {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * 你可以按任意顺序返回答案。
     * 示例 1：
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     */
    public static int[] search_sum(int[] nums ,int target) {
        int[] ret = new int[]{0,0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    break;
                }
            }
            if(ret[0] != 0) {
                break;
            }
        }
        return ret;

    }
    public static void main5(String[] args) {
        int[] nums = {22,15,2,3};
        int target = 25;
        int[] ret = search_sum(nums, target);
        if(ret[0] == ret[1]) {
            System.out.println("查找失败");
        }else {
            System.out.println(Arrays.toString(ret));
        }
    }
    /**
     * 给定一个整型数组, 实现冒泡排序(升序排序)
     * 蒙了
     */
    public static void bubble_sort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length -2 -i; j++) {
                if(array[j] > array[j+1]) {
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main4(String[] args) {
        int[] array = {5,3,6,7,3,1,2,0,11};
        bubble_sort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * 给定一个有序整型数组, 实现二分查找
     */
    public static int binary_Search(int num, int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(array[mid] > num) {
                right = mid;
            } else if (array[mid] < num) {
                left = mid + 1;
            } else {
                break;
            }
        }
        if(left > right) {
            return -1;
        } else {
            return mid;
        }
    }
    public static void main3(String[] args) {
        int[] array = {1,2,3,4,5,7,9,23,24,45};
        int ret = binary_Search(45, array);
        System.out.println(ret);
    }
    /**
     * 调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序。
     * 如数组：[1,2,3,4,5,6]
     * 调整后可能是：[1, 5, 3, 4, 2, 6]
     */
    public static void change(int[] array) {
        int left = 0;
        int right = array.length -1;
        while (left < right) {
            if(array[left] % 2 != 0) {
                left++;
            }
            if (array[right] % 2 == 0) {
                right--;
            }
            if(array[left] % 2 == 0 && array[right] % 2 != 0) {
                int temp = 0;
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right++;
            }
        }
    }
    public static void main2(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        change(array1);
        for (int x:array1
             ) {
            System.out.print(x + " ");
        }
    }
    /**
    实现一个方法 transform, 以数组为参数, 循环将数组中的每个元素 乘以 2 ,
     并设置到对应的数组元素上. 例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
     */
    public static void transform(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
    }
    public static void main1(String[] args) {
        int[] array1 = {1,2,3,4};
        transform(array1);
        for (int x:array1
             ) {
            System.out.print(x + " ");
        }
    }
}
