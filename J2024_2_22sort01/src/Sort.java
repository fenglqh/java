
import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import java.util.Arrays;
import java.util.Stack;

public class Sort {

    /**
     * 直接插入排序
     * @param array
     */
    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int tmp = array[i];//待插入数据
            int j = i-1;
            for (; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j+1] = array[j];//大的数据往后挪
                } else {
//                    array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;//j=-1的情况

        }
    }


    /**
     * 希尔排序
     * 1.分组，对每一组进行排序
     * @param array
     */
    public static void shellSort(int[] array) {
        int gap = array.length/2;
        while (gap > 1) {
            gap = gap/2;
            shell(gap,array);

        }
       // shell(1,array);
    }

    /**
     * 对每组进行插入排序
     * @param gap
     * @param array
     */
    public static void shell(int gap,int[] array) {
        for (int i = gap; i < array.length; i++) {
            int temp = array[i];
            int j = i-gap;
            for (; j >= 0; j-=gap) {
                //这里加不加等号和稳定性有关系
                //本身是一个稳定的排序，可以实现为不稳定的排序
                //本身是一个不稳定的排序，不可以实现为稳定的排序
                if (array[j] >= temp) {
                    swap(array,j,j+gap);
                } else {
                    break;
                }
            }
            array[j+gap] = temp;
        }
    }

    private static void swap(int[] array, int j, int i) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    /**
     * 选择排序
     * 一趟趟找最小值
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < array.length ; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    /**
     * 双向选择排序
     * @param array
     */
    public static void selectSortDou(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int maxIndex = left;
            int minIndex = left;
            for (int i = left+1; i <= right; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            swap(array,minIndex,left);
            if (maxIndex == left) {
                maxIndex = minIndex;

            }
            swap(array,maxIndex,right);
            left++;
            right--;
        }
    }
    /**
     * 堆排序
     * @param array
     */
    public static void heapSort(int[] array) {

    }


    /**
     * 冒泡排序
     * 可以进行优化，当没有交换发生时就代表已经有序了
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {//排序的趟数
            boolean flag = false;//代表wu交换
            for (int j = 0; j < array.length-1-i ; j++) {
                if (array[j] > array[j+1]) {
                    swap(array,j,j+1);
                    flag = true;
                }
            }
            if(!flag) {
                break;
            }
        }
    }

    /**
     * Hoare快速排序
     * @param array
     */
    public static void quickSort(int[] array) {

    }

    /**
     * 找到基准值的位置
     * 根据二叉树结构，必须保证中间的数字在根节点
     * @param array
     * @return
     */
    public static int middleNumber(int[] array,int start,int end) {
        int mid = (start + end) / 2;
        if (array[start] > array[end]) {
            if (array[start] > array[mid]) {
                return start;
            } else if (array[end] < array[mid]) {
                return end;
            } else {
                return mid;
            }
        } else {
            if (array[end] > array[mid]) {
                return mid;
            } else if(array[start] < array[mid]) {
                return end;
            } else {
                return mid;
            }
        }
    }


    /**
     * 霍尔排序，就是以最左边的为基准进行拍
     * @param array
     */
    public static void quickHoare(int[] array) {
        Hoare(array,0,array.length-1);
    }

    public static void Hoare(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partitionHoare(array,start,end);
        Hoare(array,start,pivot-1);
        Hoare(array,pivot+1,end);
    }
    /**
     * hoare进行分组
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int partitionHoare(int[] array,int start, int end) {
        if (start >= end) {
            return -1;
        }
        int left = start+1;
        int right = end;
        int privo = array[start];
        while (left < right) {
            //在小范围里面还要重新判断一下范围
            while (left<right && array[left] <= privo) {
                left++;
            }
            while (left<right && array[right] >= privo) {
                right--;
            }
            swap(array,right,left);
        }
        //注意点，等号取不取
        if (left >= 1 && array[left] >= privo) {
            swap(array,start,--left);
        } else {
            swap(array,start,left);
        }
        return left;
    }


    /**
     * 挖坑法
     * @param array
     */
    public static void quickHole(int[] array) {
        
    }

    public static void quickSortNor(int[] array) {
        int start = 0;
        int end = array.length - 1;
        Stack<Integer> stack = new Stack<>();
        int pivot = partition(array,start,end);
        if ((pivot - 1) > start) {
            stack.add(start);
            stack.add(pivot-1);
        }
        if ((pivot + 1) < end) {
            stack.add(pivot+1);
            stack.add(end);//先放右边
        }
        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();
            pivot = partition(array,left,right);
            //先看看右边
            if ((pivot - 1) > start) {
                stack.push(left);
                stack.push(pivot-1);
            }
            if ((pivot + 1) < end) {
                stack.push(pivot+1);
                stack.push(right);

            }
        }
    }

    private static int partition(int[] array, int start, int end) {
        return -1;
    }
}
