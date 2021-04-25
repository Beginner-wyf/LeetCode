package hard;

/**
 * @author wangyifan
 * @create 2021/3/6 11:47
 */
public class KMP匹配 {
    public static void main(String[] args) {
        String str = "";

        System.out.println(match(str, "abc"));

    }


    //获取next数组

    public static int[] getNextArray(char[] t) {
        int[] next = new int[t.length];
        if (next.length > 1) {
            next[0] = -1;
            next[1] = 0;
            int k;
            for (int j = 2; j < t.length; j++) {
                k=next[j-1];
                while (k!=-1) {
                    if (t[j - 1] == t[k]) {
                        next[j] = k + 1;
                        break;
                    }
                    else {
                        k = next[k];
                    }
                    next[j] = 0;  //当k==-1而跳出循环时，next[j] = 0，否则next[j]会在break之前被赋值
                }
            }
        }else if (next.length == 1){
            next[0] = 0;
        }
        return next;
    }


    public static int match(String str,String pattern){
        if (str.isEmpty()){
            return -1;
        }
        if (pattern.isEmpty()){
            return 0;
        }

        //获取字符数组
        char[] strs = str.toCharArray();
        char[] pats = pattern.toCharArray();
        //根据模式串获取next数组表
        int[] next = getNextArray(pats);

        int i = 0 , j = 0;
        while(i < strs.length && j < pats.length){
            //如果j = -1，说明第一个字符就不匹配，需要后移以为进行比对
            if (j == -1 || strs[i] == pats[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j == pats.length){
            return i -j;
        }
        return -1;

    }
}
