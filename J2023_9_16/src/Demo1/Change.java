package Demo1;

public class Change {
    private int a = 1;
    private int b = 2;

    public static void main(String[] args) {
        int c = 3;
        int d = 4;
        int t;
        t = c;
        c = d;
        d = t;
        System.out.println("c="+c);
        System.out.println("d="+ d);
        int t2;
        Change test = new Change();
        t2 = test.a;
        test.a = c;
        c = t2;
        System.out.println(test.a);
        System.out.println(test.b);
    }
}
