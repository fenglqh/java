import java.util.Arrays;

public class Main {
    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(true) {
            slow = replace(slow);
            fast = replace(fast);
            fast = replace(fast);
            if(slow == fast) {
                return false;
            }
            if(slow == 1 || fast == 1) {
                return true;
            }
        }
    }
    private static int replace(int n) {
        int sum = 0;
        while(true) {
            if(n/10 == 0 && n % 10 == 0) {
                break;
            }

            sum += (n % 10) * (n % 10);
            n = n / 10;


        }
        return sum;

    }

    public static void main3(String[] args) {
        System.out.println(isHappy(19));
    }
    public static void test(int a) {//678
        if (a == 0) {
            return;
        }
        test(a/10);
        System.out.print(a%10 + " ");
    }
    public static void main(String[] args) {
        test(5634);
    }
    public static void duplicateZeros(int[] arr) {
        int dest = -1;
        int cur = 0;
        while (dest < arr.length-1) {
            if (arr[cur] != 0) {
                dest++;
            } else {
                dest += 2;
            }
            cur++;
        }

        cur--;
        while (cur >= 0) {

            if (arr[cur] == 0) {
                if (dest >= arr.length) {
                    arr[dest - 1] = 0;
                    dest--;
                } else {
                    arr[dest] = 0;
                    arr[dest - 1] = 0;
                    dest -= 2;
                }
            } else {
                arr[dest] = arr[cur];
                dest--;
            }
            cur--;
        }
    }

    public static void main2(String[] args) {
        int[] arr = {8,4,5,0,0,0,0,7};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void main1(String[] args) {
        int[] array = {768,34,157,9,42,56,2,56,3,67,432};
        int[] array1 = {3,-1};
        int[] arr = {44,32,11,6,7,32,96,34,23,34,45,31};
        MySort.shellSort(array1);
//        MySort.insertSort(arr);
//        MySort.quickSort2(array1);
//        int pointer = MySort.pointer(arr, 0, array.length);
//        System.out.println(pointer);
        MySort.quickSort2(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(array1));

    }
}
