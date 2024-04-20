import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {99,1,2,7,999,-11,4,5,10,88};
        int[] arr1 = {6,4,9,8,3,7,2,0,4};
        System.out.println(6 == 9 && 3/0==0);//如果第一个条件是false那么就不会去判断第二个条件
        Sort.quickDoublePointer(arr);
        Sort.quickDoublePointer(arr1);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
    }
    public static void main1(String[] args) {
        int[] arr = {99,1,2,7,999,-11,4,5,10,88};
        int[] arr1 = {6,1,2,5,4,11,9,7,10,8};
        Sort.quickHole(arr);
        System.out.println(Arrays.toString(arr));
//        Sort.quickHoare(arr1);
//        System.out.println(Arrays.toString(arr1));
//        Sort.quickHoare(arr);
//        System.out.println(Arrays.toString(arr));
    }
}
