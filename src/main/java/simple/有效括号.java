package simple;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author wangyifan
 * @create 2021/2/22 11:51
 */
public class 有效括号 {
    public static void main(String[] args) {

        String s = "){";

        //System.out.println(solution1(s));
        System.out.println(solution2(s));
    }

    public static boolean solution1(String s){
        //字符串长度为奇数，返回false
        if (s.length() % 2 == 1) {return false;}

        HashMap<Character, Character> charMap = new HashMap<Character, Character>() {
            {
                put(')','(');
                put('}','{');
                put(']','[');
            }
        };
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (charMap.containsKey(ch)){
                //如果栈内元素为空，或者根据key值获取的value不等于栈顶元素，返回false
                if (characters.isEmpty() || !characters.peek().equals(charMap.get(ch))){
                    return false;
                }
                characters.pop();
            }else {
                //当获取的字符不存在于{')',']','}'}中时，将其存入栈中
                characters.push(ch);
            }
        }
        if (characters.isEmpty()) {return true;}
        return false;
    }

    public static boolean solution2(String s){
        if (s.length() % 2 == 1){return false;}
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch){
                case '(':
                    characters.push(ch);
                    break;
                case '[':
                    characters.push(ch);
                    break;
                case '{':
                    characters.push(ch);
                    break;
                case '}':
                    if (characters.isEmpty() || !characters.peek().equals('{')) {
                        return false;
                    }
                    characters.pop();
                    break;
                case ']':
                    if (characters.isEmpty() || !characters.peek().equals('[')) {
                        return false;
                    }
                    characters.pop();
                    break;
                case ')':
                    if (characters.isEmpty() || !characters.peek().equals('(')) {
                        return false;
                    }
                    characters.pop();
                    break;
            }
        }
        if (characters.isEmpty()){return true;}
        return false;
    }
}
