package simple;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author wangyifan
 * @create 2021/3/10 16:44
 */
public class 外观数列 {
    public static void main(String[] args) {
        System.out.println(countAndSay2(5));
    }
    public static String countAndSay(int n) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("1");
        Stack<String> stack = new Stack<>();
        for (int i = 1; i < n; i++) {
            String s = strings.get(i - 1);
            String[] split = s.split("");
            String content = "";
            int num;
            for (String s1 : split) {
                if (stack.isEmpty()||stack.peek().equals(s1)){
                    stack.push(s1);
                }else {
                    String temp = stack.peek();
                    num = stack.size();
                    content = content + num + temp;
                    stack.removeAllElements();
                    stack.push(s1);
                }
            }
            if (!stack.isEmpty()){
                String temp = stack.peek();
                num = stack.size();
                content = content + num + temp;
                stack.removeAllElements();
            }
            strings.add(content);
        }
//        for (String string : strings) {
//            System.out.println(string);
//        }
        return strings.get(strings.size()-1);
    }

    public static String countAndSay2(int n) {
        // 递归终止条件
        if (n == 1) {
            return "1";
        }
        StringBuffer res = new StringBuffer();
        // 拿到上一层的字符串
        String str = countAndSay2(n - 1);
        int length = str.length();
        // 开始指针为0
        int start = 0;
        // 注意这从起始条件要和下面长度统一
        for (int i = 1; i < length + 1; i++) {
            // 字符串最后一位直接拼接
            if (i == length) {
                res.append(i - start).append(str.charAt(start));
                // 直到start位的字符串和i位的字符串不同，拼接并更新start位
            } else if (str.charAt(i) != str.charAt(start) ) {
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }

}
