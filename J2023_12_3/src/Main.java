public class Main {
    public static void main(String[] args) {
        SingleLinkedList mySingleList  = new SingleLinkedList();
        mySingleList.addLast(0);
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(3);


        mySingleList.display();
        mySingleList.remove(9);
        mySingleList.display();

        System.out.println(mySingleList.contains(2));
    }
}
