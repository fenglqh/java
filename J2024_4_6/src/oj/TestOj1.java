package oj;
class Test01 {
    public void run() {
        System.out.println("你是猪");
    }
}
class Test02 extends Test01 {
    public void run() {
        System.out.println("死鬼，你是我的小宝贝呀");
    }
}
public class TestOj1 {
    public static void main(String[] args) {
        Test01 test01 = new Test02();
//        Test02 test02 = new Test02();
        test01.run();
//        test02.run();
    }
    public static void main1(String[] args) {
        int[] a = {1,3,5,6};
        int t = 2;
        System.out.println(searchInsert(a, t));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] <= target) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}
