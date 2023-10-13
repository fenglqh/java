import java.util.Scanner;

class Solution {
    public int countSegments(String s) {
        String[] strs = s.split(" ");
        int a = strs.length;
        return a;
    }


}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution sol = new Solution();
        int a = sol.countSegments(str);
        System.out.println(a);
    }
}
