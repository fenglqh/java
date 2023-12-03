import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角形
 */
class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        //设置好第一行
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        //剩下的行
        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);

            for (int j = 1; j < i; j++) {
                Integer b = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                curRow.add(b);
            }

            curRow.add(1);
            result.add(curRow);
        }
        return result;

//        因为set方法是根据顺序表已经被使用多少来设置的
//        //初始化列的长度
//        List<List<Integer>> ret = new ArrayList<>(numRows);
//        for (int i = 0; i < numRows; i++) {
//            //初始化行的容量
//            List<Integer> a = new ArrayList<>(i);
//            ret.set(i, a);
//            //为每一行的第一个位置赋值
//            a.set(0, 1);
//            //中间赋值
//            for (int j = 1; j < i; j++) {
//                Integer b = ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j);
//                a.set(j, b);
//            }
//            //为每一行的最后一个位置赋值
//            a.set(i, 1);
//
//        }
//        return ret;






//        //动态创建一个二维数组
//        Integer[][] ret = new Integer[numRows][];
//        for (int i = 0; i < numRows; i++) {
//            ret[i] = new Integer[i+1];
//            ret[i][0] = 1;
//            for (int j = 1; j < i; j++) {
//                ret[i][j] = ret[i-1][j-1] + ret[i-1][j];
//            }
//
//            ret[i][i] = 1;
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        for (Integer[] row : ret) {
//            result.add(Arrays.asList(row));
//        }
//        // 返回结果列表
//        return result;
    }
}
public class Main {
    public static void main(String[] args) {
        int a = 3;
        List<List<Integer>> arr = Solution.generate(a);
//        }
//        int a = 10;
//        List<Integer> mylist = new ArrayList<>(4);
//        mylist.add(1);
//        mylist.add(2);

        int[] c = new int[4];
        System.out.println(c[2]);
    }

}
