package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 二叉树的层序遍历 {
    /**
     * 102. 二叉树的层序遍历
     * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层序遍历结果：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node_1 = new TreeNode(-1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node11 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        root.left = node2;
        node2.left = node1;
        node1.left = node5;
        node1.right = node11;
        root.right = node4;
        node4.left = node3;
        node3.right = node6;
        node4.right = node_1;
        node_1.right = node8;
        levelOrder(root);


    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        HashMap<Integer, List<Integer>> resMap = new HashMap<>();
        resMap.put(1, Arrays.asList(root.val));
        resMap.put(2, new ArrayList<Integer>());
        getLevel(root, resMap, 2);
        for (Integer key : resMap.keySet()) {
            if (resMap.get(key).size() > 0) {
                res.add(resMap.get(key));
            }
        }
        return res;
    }

    private static void getLevel(TreeNode root, HashMap<Integer, List<Integer>> resMap, int level) {
        List<Integer> levelList = resMap.get(level);
        if (root.left != null || root.right != null) {
            if (!resMap.containsKey(level + 1)){
                resMap.put(level + 1, new ArrayList<Integer>());
            }
            if (root.left != null) {
                levelList.add(root.left.val);
                getLevel(root.left, resMap, level + 1);
            }
            if (root.right != null) {
                levelList.add(root.right.val);
                getLevel(root.right, resMap, level + 1);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
