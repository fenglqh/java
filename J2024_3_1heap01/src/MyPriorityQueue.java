import java.util.Arrays;

/**
 * 优先级队列（堆）的模拟
 * 底层是数组
 */
public class MyPriorityQueue {
    public int[] elem;
    public int usedSize;//记录当前堆中有效数据的个数

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "elem=" + Arrays.toString(elem) +
                '}';
    }

    public MyPriorityQueue() {
        this.elem = new int[15];//初始化一个数组长度
    }

    /**
     * 初始化elem数组
     * @param array
     */
    public void init(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            usedSize++;
        }
    }
    /**
     * 向下调整建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap(int[] array) {
        init(array);
        for (int parent = (usedSize-1-1)/2; parent >= 0; parent--) {
            shiftDown(parent,usedSize);
        }
    }

    /**
     *
     * @param root 是每棵子树的根节点的下标
     * @param len  是每棵子树调整结束的结束条件
     * 向下调整的时间复杂度：O(logn)
     */
    private void shiftDown(int root,int len) {
        int child = root*2+1;//根节点左子树的下标
        while (child < len) {
            //先确定左右节点的最大值下标
            if (child+1 < len && elem[child+1] > elem[child]) {
                child++;
            }
            //与父节点进行判断
            if (elem[child] > elem[root]) {
                swap(elem,child,root);
                //因为从下往上调整，所以和父节点进行交换需要再次调整，而没有交换的树不需要
                //重新调整root和child
                root = child;
                child = root*2+1;
            } else {
                break;
            }

        }
    }


    private void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 向上调整建堆的时间复杂度：
     *
     * @param array
     */
    public void createHeap1(int[] array) {
        init(array);
        for (int child = 1; child < usedSize ; child++) {
            shiftUp(child);
        }

    }
    private void shiftUp(int child) {
        while (child < usedSize) {
            int parent = (child-1)/2;
            if (elem[child] > elem[parent]) {
                swap(elem,child,parent);
                child = parent;
            } else {
                break;
            }
        }
    }
    /**
     * 入队：仍然要保持是大根堆
     * @param val
     */
    public void push(int val) {
        //先判断一下要不要扩容
        if (isFull()) {
            elem = Arrays.copyOf(elem,2*elem.length);
        }
        //把新进来的值放到最后,然后利用向上调整就可以变的有序
        elem[usedSize] = val;
        shiftUp(usedSize);
        usedSize++;
    }



    public boolean isFull() {
        return usedSize==elem.length;
    }

    /**
     * 出队【删除】：每次删除的都是优先级高的元素
     * 仍然要保持是大根堆
     */
    public void pollHeap() {
        //利用向下调整
        //将要删除的元素和最后一个元素交换,然后调整新的第一个元素
        if (isEmpty()) {
            return;
        }
        swap(elem,0,usedSize-1);
        usedSize--;
        shiftDown(0,usedSize);

    }

    public boolean isEmpty() {
        return usedSize==0;
    }

    /**
     * 获取堆顶元素
     * @return
     */
    public int peekHeap() {
        if (isEmpty()) {
            return -1;
        }
        return elem[0];
    }
}