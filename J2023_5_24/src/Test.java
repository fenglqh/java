import java.util.Arrays;

public class Test {
    /**
     * 给定一个整型数组, 实现冒泡排序(升序排序)
     * 蒙了
     */
    public static void bubble_sort(int[] array) {
        for (int i = 0; i < array.length -1; i++) {
            for (int j = i; j < array.length -2; j++) {
                if(array[j] > array[j+1]) {
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
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
