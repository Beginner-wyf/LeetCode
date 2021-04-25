package simple;

/**
 * @author wangyifan
 * @create 2021/4/15 18:32
 */
public class 替换空格 {
    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     *
     * 示例 1：
     * 输入：s = "We are happy."
     * 输出："We%20are%20happy."
     */
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace2(s));
    }
    public static String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
    public static String replaceSpace2(String s) {
            int length = s.length();
            char[] array = new char[length * 3];
            int size = 0;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    array[size++] = '%';
                    array[size++] = '2';
                    array[size++] = '0';
                } else {
                    array[size++] = c;
                }
            }
            String newStr = new String(array, 0, size);
            return newStr;
    }
}
