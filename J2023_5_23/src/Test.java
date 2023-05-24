public class Test {
    /**
    实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
     */
    public static void printArray(int[] array) {
        for (int x: array
             ) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void printArray(char[] array) {
        for (char x: array
        ) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void main3(String[] args) {
        int[] array1 = new int[]{1,2,3,4,5,6,7,7,8};
        char[] array2 = new char[]{'a','b','c','d'};
        printArray(array1);
        printArray(array2);
    }
    /**
     * 创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
     */
    public static void main2(String[] args) {
        int[] array = new int[100];
        int i = 1;
        for (int j = 0; j < array.length; j++) {
            array[j] = i++;
        }
        for (int x: array
             ) {
            System.out.print(x + " ");
        }
    }
    //试图用foreach来改变数组里面的值。原来，foreach只是把值取出来，并没有把这个元素搞出来。
    /**
     * 解决汉诺塔问题
     * @param args
     */
    public static void move1(int n, char pos1, char pos2, char pos3) {
        if(n == 1) {
            System.out.print(pos1 +"->" +pos3+ "　");
        } else {
            move1(n-1,pos1, pos3, pos2);
            System.out.print(pos1 +"->" +pos3+ "　");
            move1(n-1, pos2, pos1, pos3);
        }
    }

    public static void main(String[] args) {
        move1(4, 'A', 'B', 'C');

    }




}