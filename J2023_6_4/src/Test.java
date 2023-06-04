
public class Test {
    //计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值
    public static void main(String[] args) {
        double count = 0;
        int a = 1;
        for (int i = 1; i <= 100; i++) {
            count = count + (1.0/i) * a;
            if(a == 1) {
                a = -1;
            }else {
                a = 1;
            }
        }
        System.out.println(count);
    }
}
/**
 * 被类和对象搞得迷迷糊糊，县来波简单的循环结构放松一下吧
 */
//class Animal{
//    public int name;
//    public int age;
//    public void speak() {
//        System.out.println(this.name + "正在叫");
//    }
//
//    public int getName() {
//        return name;
//    }
//
//    public void setName(int name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
//class a extends Animal{
//
//}
//class b extends Animal{
//
//}
//class c{
//
//}
//public class Test {
////    public static void main(String[] args) {
////        Animal a = new c();
//    }
//}
