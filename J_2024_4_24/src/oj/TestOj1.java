package oj;

public class TestOj1 {
    public static void main(String[] args) {

    }
    public static int[] missingTwo(int[] nums) {
        int xorx = 0;
        for(int i = 1; i <= nums.length+2; i++) {
            xorx ^= i;
        }
        for(int z : nums) xorx ^= z;
        int lowbit = (xorx & (- xorx));
        int diff = 0;
        while(diff < 32) {
            if((( lowbit >> diff) & 1) == 1) break;
            else diff++;
        }
        int a = 0, b = 0;
        for(int i = 1; i <= nums.length+2; i++) {
            if (((i >> diff)&1) == 1) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        for (int x : nums) {
            if (((x  >> diff) &1) == 1) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        int[] ret = {a,b};
        return ret;
    }
}
