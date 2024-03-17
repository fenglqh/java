package linkList;

import sun.plugin.javascript.navig.LinkArray;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MySingleLinkList m = new MySingleLinkList();
        m.addFirst(1);
        m.addFirst(2);
        m.addFirst(3);
        m.addFirst(4);
        m.addLast(5);
        m.addLast(6);
        m.addLast(7);
        m.addLast(8);
        m.display();

    }
}
