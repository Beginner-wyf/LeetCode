package middle;

public class 矩阵中的路径 {
    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * 示例 1：
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * <p>
     * 示例 2：
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     * <p>
     * 提示：
     * 1 <= board.length <= 200
     * 1 <= board[i].length <= 200
     * board 和 word 仅由大小写英文字母组成
     */
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));
    }

    /**
     * 思路：
     * 深度优先搜索搭配剪枝回退
     * 1、首先获取word的字符数组，用于确定循环的深度
     * 2、确定二维字符矩阵的边界，用于遍历矩阵中的字符
     * 3、设定剪枝条件与递归出口
     */
    public static boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        //建立上下左右数组,x代表横向，y代表纵向
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, x, y, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Depth-First-Search深度优先搜索
     */
    private static boolean dfs(char[][] board, char[] words, int i, int j, int[] x, int[] y, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || words[k] != board[i][j]) {
            return false;
        }
        //递归结束标志位
        if (k == words.length - 1) {
            return true;
        }
        //匹配成功 将当前位置字符置为''，防止二次使用
        char temp = board[i][j];
        board[i][j] = '\0';
        boolean res = false;
        for (int n = 0; n < 4; n++) {
            //如果递归成功，说明查询完毕，找到了目标单词word的路径
            if (dfs(board, words, i + y[n], j + x[n], x, y, k + 1)) {
                res = true;
                break;
            }
        }
        //复原当前位置的字符
        board[i][j] = temp;
        return res;
    }

}
