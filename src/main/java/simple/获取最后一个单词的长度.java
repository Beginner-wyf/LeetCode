package simple;

/**
 * @author wangyifan
 * @create 2021/3/10 15:51
 */
public class 获取最后一个单词的长度 {
    public static void main(String[] args) {
        String s = "ad asdf ";
        System.out.println(lengthOfLastWord(s));
        //System.out.println(s.lastIndexOf(" "));

    }

    public static int lengthOfLastWord(String s) {
        //字符为空
        if ("".equals(s) || " ".equals(s)) {
            return 0;
        }
        //字符不为空，包含空格“ ”且空格位置不为末位
        if (s.contains(" ")) {
            if ((s.length()-1) > s.lastIndexOf(" ")){
                return s.substring(s.lastIndexOf(" ") + 1).length();
            }else {
                return lengthOfLastWord(s.substring(0,s.lastIndexOf(" ")));
            }
        }
        //不包含空格且字符不为空
        return s.length();
    }
    public static int lengthOfLastWord2(String s) {
        //计算字符串的末位索引下标
        int end = s.length() - 1;
        //查找不等于空格的末位索引下标
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        //计算最后一个单词的第一个字母的索引下标
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        //返回单词长度
        return end - start;
    }

}
