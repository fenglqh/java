class Test1{
    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }
}


public class Test {
    public static void main(String[] args) {
        Test1 test = new Test1();
        System.out.println(test);
    }
}
