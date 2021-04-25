package simple;

public class 斐波那契数列 {
    /**
     * 剑指 Offer 10- I. 斐波那契数列
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     *
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     */
    public static void main(String[] args) {
        System.out.println(fib(45));
        System.out.println(fib2(45));
    }
    public static int fib(int n) {
        int temp0 = 0;
        int temp1 = 0;
        int temp2 = 1;
        if(n == 0){
            return temp1;
        }
        if(n == 1){
            return temp2;
        }
        for(int i = 1;i < n;i++){
            temp0 = temp1 + temp2;
            temp1 = temp2;
            temp2 = temp0;
        }
        return temp0%1000000007;
    }
    public static int fib2(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fib2(n-1)+fib2(n-2);
    }
}
