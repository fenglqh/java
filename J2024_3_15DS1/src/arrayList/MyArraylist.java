package arrayList;

import exception.PosError;

import java.util.Arrays;

public class MyArraylist {

    public int[] elem;//顺序表的底层
    public int usedSize;//数组被使用的大小
    //默认容量
    private static final int DEFAULT_SIZE = 10;

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        //注意i的终止条件
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //1.判断满不满，满了的话要扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
        //2.在数组最后添加元素
        this.elem[this.usedSize++] = data;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }

    //检查指定为增加的位置是否合法
    private boolean checkPosInAdd(int pos) throws PosError{
        return pos >= 0 && pos <= this.usedSize;
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
//        1.先判断插入位置合不合法
        if (!checkPosInAdd(pos)) {
            throw new PosError("位置信息错误！");
        }
//          2.先判断元素满不满，满就要扩容
        if (isFull()) {
            this.elem = Arrays.copyOf(this.elem,this.elem.length*2);
        }
//        3.在指定位插入，后移其他元素
//        但是从pos位元素开始移动会覆盖后面未移动元素
//        所以从后往前移
        for (int i = this.usedSize-1; i >= pos ; i--) {//i==pos?
            this.elem[i+1] = this.elem[i];
        }
        this.elem[pos] = data;
//        增加完之后不用忘记把usedSize加一下
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) return true;
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) return i;
        }
        return -1;
    }
// 获取pos位置中pos是否合法
    private boolean checkPosInGet(int pos) throws PosError{
        return pos >= 0 && pos < this.usedSize;//注意或者还是并且
    }
    // 获取 pos 位置的元素
    public int get(int pos) {
//        1.pos是否合法
        if (!checkPosInGet(pos)) {
            throw new PosError("pos非法!");
//            return -1;抛出异常就不会往下执行了
        };
        return this.elem[pos];
    }

    private boolean isEmpty() {
        return this.usedSize == 0;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
//        1.pos合法？
        if (!checkPosInGet(pos)) {
            throw new PosError("更新pos下标元素pos非法!");
        }
        this.elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
//        !!
//        1.判断是不是空
        if (isEmpty()) {
            System.out.println("顺序表为空");
        }
//        2.找到key第一次出现的位置
        int pos = indexOf(key);
//        3.如果元素不存在
        if (pos == -1) {
            return;
        }
//        pos后的元素往前移动
        for (int i = pos; i < this.usedSize-1; i++) {
            this.elem[i] = this.elem[i+1];
        }
        this.usedSize--;
    }

    // 获取顺序表长度
    public int size() {
        return this.usedSize;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }
}