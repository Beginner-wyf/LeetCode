package simple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author wangyifan
 * @create 2021/4/1 16:11
 */
public class 笨蛋阶乘clumsy {
    /**
     * * 通常，正整数 n 的阶乘是所有小于或等于 n 的正整数的乘积。例如，factorial(10) = 10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1。
     * * 相反，我们设计了一个笨阶乘 clumsy：在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)。
     * * 例如，clumsy(10) = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1。然而，这些运算仍然使用通常的算术运算顺序：我们在任何加、减步骤之前执行所有的乘法和除法步骤，并且按从左到右处理乘法和除法步骤。
     * * 另外，我们使用的除法是地板除法（floor division），所以 10 * 9 / 8 等于 11。这保证结果是一个整数。
     * * 实现上面定义的笨函数：给定一个整数 N，它返回 N 的笨阶乘。
     * *
     * * 示例 1：
     * *
     * * 输入：4
     * * 输出：7
     * * 解释：7 = 4 * 3 / 2 + 1
     * * 示例 2：
     * *
     * * 输入：10
     * * 输出：12
     * * 解释：12 = 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     * *
     * * 提示：
     * *
     * * 1 <= N <= 10000
     * * -2^31 <= answer <= 2^31 - 1  （答案保证符合 32 位整数。）
     */
    public static void main(String[] args) {
        System.out.println("数字" + 4 + "计算得出：" + clumsy2(4));
        System.out.println("数字" + 5 + "计算得出：" + clumsy2(5));
        System.out.println("数字" + 6 + "计算得出：" + clumsy2(6));
        System.out.println("数字" + 7 + "计算得出：" + clumsy2(7));
        System.out.println("数字" + 8 + "计算得出：" + clumsy2(8));
        System.out.println("数字" + 9 + "计算得出：" + clumsy2(9));
        System.out.println("数字" + 10 + "计算得出：" + clumsy2(10));
        System.out.println("数字" + 11 + "计算得出：" + clumsy2(11));
        System.out.println("数字" + 12 + "计算得出：" + clumsy2(12));
        System.out.println("数字" + 13 + "计算得出：" + clumsy(13));
        System.out.println("数字" + 14 + "计算得出：" + clumsy(14));
        System.out.println("数字" + 15 + "计算得出：" + clumsy(15));
    }

    /**
     * 解法思路：
     * 从题目的表达式可以明显看出，四个数可以凑成一组，然后就按照四个四个的计算方式来完成题目
     * 如：10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1 = 12
     * 可以看成(10 * 9 / 8 + 7)-(6 * 5 / 4 - 3)-2，这样就好拆分并将其公式化
     * 具体代码如下
     */
    public static Integer clumsy(Integer num) {
        int n = num / 4;
        int m = num % 4;
        ArrayList<Integer> res = new ArrayList<>();
        if (n >= 1) {
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    res.add(-(num * (num - 1) / (num - 2) - (num - 3)));
                } else {
                    res.add(num * (num - 1) / (num - 2) + (num - 3));
                }
                num = num - 4;
            }
            switch (num) {
                case 3:
                    res.add(-6);
                    break;
                case 2:
                    res.add(-2);
                    break;
                case 1:
                    res.add(-1);
                    break;
                default:
                    return res.stream().reduce((n1, n2) -> n1 + n2).get();
            }
        } else {
            switch (m) {
                case 3:
                    return 6;
                case 2:
                    return 2;
                case 1:
                    return 1;
            }
        }
        return res.stream().reduce((n1, n2) -> n1 + n2).get();
    }


    public static Integer clumsy2(Integer num) {
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else if (num == 3) {
            return 6;
        } else if (num == 4) {
            return 7;
        }

        if (num % 4 == 0) {
            return num + 1;
        } else if (num % 4 <= 2) {
            return num + 2;
        } else {
            return num - 1;
        }
    }

}
