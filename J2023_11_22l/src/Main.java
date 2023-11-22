public class Main {
    public static void main(String[] args) {
        MySingelList mySingelList = new MySingelList();
        mySingelList.addLast(0);
        mySingelList.addLast(1);
        mySingelList.addLast(2);
        mySingelList.addLast(3);
        mySingelList.addLast(4);

        mySingelList.display();
        mySingelList.remove(6);
        mySingelList.display();
    }
}
