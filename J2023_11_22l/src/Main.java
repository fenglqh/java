public class Main {
    public static void main(String[] args) {
        MySingelList mySingelList = new MySingelList();
        mySingelList.addLast(2);
        mySingelList.addLast(2);
        mySingelList.addLast(3);
        mySingelList.addLast(2);
        mySingelList.addLast(3);

        mySingelList.display();
        mySingelList.removeAllkey(3);
        mySingelList.display();
    }
}
