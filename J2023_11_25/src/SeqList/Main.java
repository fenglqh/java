package SeqList;

public class Main {
    public static void main(String[] args) {
        MyArraylist myArraylist = new MyArraylist();
        myArraylist.add(0);
        myArraylist.add(1);
        myArraylist.add(2);
        myArraylist.add(3);
        myArraylist.add(4);
        myArraylist.add(5);
        myArraylist.add(6);
        myArraylist.add(7);
        myArraylist.add(8);
        myArraylist.add(9);
        myArraylist.display();
        myArraylist.remove(0);
        myArraylist.display();
    }
}
