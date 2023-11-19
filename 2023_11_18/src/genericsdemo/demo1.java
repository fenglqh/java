package genericsdemo;


import java.util.ArrayList;
import java.util.Arrays;

class MyArray<E>{
    public Object[] arr = new Object[10];

    public void setPos(int pos,Object val) {
        this.arr[pos] = val;
    }



    @Override
    public String toString() {
        for (Object x:
             arr) {
            System.out.print(x + " ");
        }
        return "";
    }
}


