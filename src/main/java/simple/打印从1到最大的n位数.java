package simple;

import java.util.ArrayList;
import java.util.Arrays;

public class 打印从1到最大的n位数 {
    /**
     * 剑指 Offer 17. 打印从1到最大的n位数
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     * <p>
     * 说明：
     * 用返回一个整数列表来代替打印
     * n 为正整数
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(printNumbers(2)));
    }

    public static int[] printNumbers(int n) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 1; i < Math.pow(10,n); i++) {
            integers.add(i);
        }
        return integers.stream().mapToInt(x -> x).toArray();
    }
    public static int[] printNumbers2(int n) {
        int end = (int) Math.pow(10,n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
