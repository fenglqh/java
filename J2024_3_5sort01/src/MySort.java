public class MySort {
    // 插入排序

    /**
     * 就是从后往前开始慢慢有序
     * 从小到大
     * @param array
     */
    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            for (; j >= 0; j--) {
//                加不加等号和稳定性有关
               if (array[j] >= temp) {
//                   swap(array,j,j+1);  这里不是交换,而是向后移动,就相当于要插入的数据的位置当做空位置
                   array[j+1] = array[j];
               } else {
                   break;
               }
            }
            array[j+1] = temp;
        }

    }
    private static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


        // 希尔排序

    /**
     * 在直接排序的基础设施进行分组排序
     * @param array
     */
    public static void shellSort(int[] array){
        int gap = (array.length) / 2;//要注意[3,-1]
        while (gap > 0) {
            shell(array,gap);
            gap = gap / 2;
        }
//        shell(array,gap);
    }

    private static void shell(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {//保证每一组都要排到
            int temp = array[i];
            int j = i-gap;
            for (; j >= 0 ; j-=gap) {
                if (array[j] >= temp) {
                    array[j+gap] = array[j];
                } else {
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] array){
        boolean flag = false;//代表没有交换
        for (int i = 0; i < array.length-1; i++) {//可以再优化,如果没有交换就代表已经排好了
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    swap(array, j, j+1);
                    flag = true;
                }
                if (!flag) {
                    return;
                }
            }
        }
    }

// 快速

    /**
     * 霍尔法快速排序
     * @param array
     */
    public static void quickSort1(int[] array){
        partionHoare(array,0,array.length-1);
    }

    public static void partionHoare(int[] array,int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = Hoare(array, start,end);
        partionHoare(array,start,mid-1);
        partionHoare(array,mid+1,end);
    }
    private static int Hoare(int[] array, int start, int end) {
        int pivot = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            //如果先走left有可能把比pivot大的移动到最前面。
            while (left < right && array[right] >= pivot) {
                right--;
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            swap(array,right,left);
        }
        swap(array,start,left);
        return left;
    }

    /**
     * 双指针法快速排序，思路是来自算法视频的第一季
     * @param array
     */
    public static void quickSort2(int[] array) {
        partitionP(array,0,array.length-1);
    }

    public static void partitionP(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = pointer(array, start,end);
        partitionP(array,start,mid-1);
        partitionP(array,mid+1,end);
    }
    public static int pointer(int[] array,int start, int end) {
        int temp = array[start];
        int dest = start;
        for (int cur = start+1; cur <= end; cur++) {
            if (array[cur] <= temp) {
                swap(array,dest+1,cur);
                swap(array,dest,dest+1);
                dest++;
            }
//注意在for循环的开始cur已经加过了，没必要在处理了。
        }

          return dest;

    }
}
