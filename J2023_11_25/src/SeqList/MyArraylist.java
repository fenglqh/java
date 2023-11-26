package SeqList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArraylist {

    public int[] elem;//顺序表底层是数组
    public int usedSize;//数组被使用的大小，也就是顺序表的长度

    //默认容量
    private static final int DEFAULT_SIZE = 10;//顺序表的默认最大容量

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    /**
     * 打印顺序表:
     * 根据usedSize判断即可
     */
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //扩容
    private void resize() {
        this.elem = Arrays.copyOf(this.elem, this.elem.length*2);
    }
    // 新增元素,默认在数组最后新增
    public void add(int data) {
        //如果数组满了则进行动态扩容
        if(isFull()) {
            resize();
        }
        this.elem[this.usedSize] = data;
        this.usedSize++;
    }

    /**
     * 判断当前的顺序表是不是满的！
     *
     * @return true:满   false代表空
     */
    public boolean isFull() {
        return (this.usedSize == this.elem.length);
    }


    private boolean checkPosInAdd(int pos) {
        if (pos < 0 || pos > this.usedSize){
            return false;
        }
        return true;//合法
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) {
        boolean ret = checkPosInAdd(pos);
        if (!ret) {
            System.out.println("索引非法");
            return;
        }
        if(isFull()) {
            resize();
        }
        int ret2 = this.usedSize;
        while (pos < ret2) {//不可以相等
            this.elem[ret2] = this.elem[ret2-1];
            ret2--;
        }
        this.elem[pos] = data;
        this.usedSize++;

    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //判断pos合不合法
    private boolean checkPosInGet(int pos) {
        if (pos < 0 || pos > this.usedSize-1) {
            return false;
        }
        return true;
    }
    // 获取 pos 位置的元素
    public int get(int pos) {
        boolean flag = checkPosInGet(pos);
        if (!flag) {
            System.out.println("位置不合法");
            return -1;
        }
        int ret = this.elem[pos];
        return ret;
    }

    private boolean isEmpty() {
        if (this.usedSize == 0) {
            return true;
        }
        return false;
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) {
        boolean flag = checkPosInGet(pos);
        if(!flag) {
            System.out.println("位置不合法");
            return;
        }
        this.elem[pos] = value;
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        int pos = indexOf(key);
        if (pos == -1) {
            return;
        }
        while (pos < this.usedSize-1) {
            this.elem[pos] = this.elem[pos+1];
            pos++;
        }
        elem[usedSize] = 0;
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

