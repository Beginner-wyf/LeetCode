package simple;

public class 二叉树的深度 {
    /**
     * 剑指 Offer 55 - I. 二叉树的深度
     * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
     * <p>
     * 例如：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     */
    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);
        return Math.max(rightDepth,leftDepth);
    }
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归左子树与右子树
        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);
        //如果子树为空则则直接跳过
        if (root.left == null) {
            return leftDepth + 1;
        }
        if (root.left == null) {
            return rightDepth + 1;
        }
        return Math.min(rightDepth,leftDepth);
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
