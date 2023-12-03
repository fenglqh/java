/**
 * 合并两个有序数组
 */

public class AddTwoArrayList {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //大方向是从后往前，数字大的就放到nums1的最后面

        //如果m=0 n=1 m+n=1 ret = 0 len1 = -1 len2 = 0

        //如果m=1 n=0 m+n=1 ret = 0 len1 = 0 len2 = -1
        //如果m=0 n=0 m+n=0 ret = -1 len = -1 len2 = -1
        //如果m=1 n=1 m+n=2 ret = 1 len1 = 0 len2 = 0
        if(n == 0) {
            return;
        }
        if(m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int ret = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;

        while (len2 >= 0 ) {
            if(len1 >= 0 &&(nums1[len1] > nums2[len2])) {
                nums1[ret] = nums1[len1];
                len1--;

            } else {
                nums1[ret] = nums2[len2];
                len2--;

            }
            ret--;
        }



    }

    public static void main(String[] args) {
        int[] num1 = {2,0};
        int m = 1;

        int[] nums2 = {1};
        int n = 1;
        merge(num1,m,nums2,n);
        for (int x:
            num1 ) {
            System.out.print(x +" ");
        }
    }
}
