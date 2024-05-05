package oj;

public class TestOj3 {
    public static void main(String[] args) {
        // 当oj返回类型是String时怎么办
//        首先得来个可变字符串，然后拼接，最后再转成字符串类型返回
        StringBuilder builder = new StringBuilder();
        builder.append('a');
        builder.append('b');
        builder.append('c');
//        builder.charAt()
        String s = String.valueOf(builder);
        System.out.println(s);
    }

    public static void main2(String[] args) {
        String s = "A";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }
    public static String convert(String s, int numRows) {
//  第一步算公差
        int d = numRows * 2 - 2;
        // 返回值
        StringBuilder ss = new StringBuilder();
        // 每一行
        for (int i = 0; i < numRows; i++) {
            if(i == 0 || i == numRows-1) {
                for (int j = i; j < s.length(); j+=d) {
                    ss.append(s.charAt(j));
                }
                continue;
            }
            for (int j = i; j < s.length();j+=d) {
                ss.append(s.charAt(j));
                if (j > i) {
                    ss.append(s.charAt(j-2*i));
                };
            }
        }
        return String.valueOf(ss);
    }
}
