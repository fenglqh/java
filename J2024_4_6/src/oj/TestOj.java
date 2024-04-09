package oj;

public class TestOj {
    public static void main(String[] args) {
        int[] arr = {0,1,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (arr[mid] <= arr[mid + 1]) left = mid;
            else right = mid - 1;
        }
        return left + 1;
    }
}
