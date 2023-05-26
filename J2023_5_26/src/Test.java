import java.util.Arrays;

public class Test {
    /**

     */
    /**
     * 编写程序数一下 1到 100 的所有整数中出现多少个数字9
     */
    public static void main(String[] args) {

    }
    /**
     * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
     * 1 4 5 7 6 8
     */
    public static boolean is_odd(int a) {
        if(a % 2 != 0) {
            return true;
        }else {
            return false;
        }
    }
    public static boolean three_is_odd(int[] array) {
        int count = 0;
        int i = 0;
        while (i < array.length) {
            if (is_odd(array[i])) {
                count++;
                i++;
                if (count == 3) {
                    break;
                }
            } else {
                count = 0;
                i++;
            }
        }
        if (count == 3) {
            return true;
        }else {
            return false;
        }
    }
    public static void main3(String[] args) {
        int[] arr1 = {1,7,2,4,5,7,3,6};
        int[] arr2 = {1,7,2,4,5,9,4};
        System.out.println(three_is_odd(arr1));
        System.out.println(three_is_odd(arr2));
    }
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * 1 5 3 3 3 3 5 //sort
     */
    public static int most_elem(int[] array) {
        Arrays.sort(array);
        int i = 0;
        int count = 1;
        while (i < array.length - 1) {
            if (array[i] == array[i + 1]) {
                count++;
                i++;
                if (count > array.length / 2) {
                    break;
                }
            } else {
                count = 1;
                i++;
            }
        }
        return array[i];
    }
    public static void main2(String[] args) {
        int[] array = {2,2,1,1,1,2,2};
        System.out.println(most_elem(array));
    }
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @param args
     */
    public static int only_exist(int[] arrays) {
        Arrays.sort(arrays);
        int ret = 0;
        int i = 0;
        while (i < arrays.length) {
            if (arrays[i] == arrays[i+1]) {
                i+=2;
            }else {
                ret = arrays[i];
                break;
            }
        }
        return ret;
    }//不完美的地方假如数组里面出现一次的元素是0怎么办
    public static void main1(String[] args) {
        int[] array = {4,2,1,2,3,4,1};
        System.out.println(only_exist(array));
    }
}
