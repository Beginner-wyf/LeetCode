package simple;

public class 二进制中1的个数 {
    /**
     * 剑指 Offer 15. 二进制中1的个数
     * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
     *
     * 示例 1：
     * 输入：00000000000000000000000000001011
     * 输出：3
     * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
     *
     * 示例 2：
     * 输入：00000000000000000000000010000000
     * 输出：1
     * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
     *
     * 示例 3：
     * 输入：11111111111111111111111111111101
     * 输出：31
     * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
     *
     * 提示：
     * 输入必须是长度为 32 的 二进制串 。
     */
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
    public static int hammingWeight(int n) {
        int res = 0;
        String s = Integer.toBinaryString(n);
        String[] split = s.split("");
        for (String s1 : split) {
            if (s1.equals("1")) {
                res++;
            }
        }
        return res;
    }

    /**
     * 返回指定int值的二进制补码二进制表示形式中的一位数。 有时将此功能称为人口计数。
     * 参数：
     * i –要计数其位的值
     * 返回值：
     * 指定的int值的二进制补码二进制表示形式中的一位数。
     * 自从：
     * 1.5
     */
    public static int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }
}
