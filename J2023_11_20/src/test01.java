
//输入"BAaB"
//输出“BAa”
public class test01 {
    public String setstring (String str) {
        // write code here
        // 如果字符在字符串内第一次出现的索引和下标一样就加进新数组，不一样·就·不加·
        char[] str1 = str.toCharArray();
        char[] str2 = new char[str1.length];
        int j = 0;
        for (int i = 0; i < str1.length; i++) {
            char a = str1[i];
            int ret = str.indexOf(a);
            if(str.indexOf(a) == i) {
                str2[j++] = a;
            }
        }
        String back = String.valueOf(str2);
        return back.trim();
    }

    public static void main(String[] args) {
        test01 t = new test01();
        String a = "B";
        String b = t.setstring(a);
        System.out.println(b);
    }
}
