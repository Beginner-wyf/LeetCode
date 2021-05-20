package simple;

public class 二叉树的镜像 {
    /**
     * 剑指 Offer 27. 二叉树的镜像
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * 示例 1：
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     */
    public static void main(String[] args) {

    }
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return root;
        }
        mirror(root);
        return root;
    }
    public static void mirror(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        if (node.left != null){
            mirror(node.left);
        }
        if (node.right != null){
            mirror(node.right);
        }

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
