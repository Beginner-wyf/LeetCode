package middle;

import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author wangyifan
 * @create 2021/4/16 11:20
 */
public class 重建二叉树 {
    /**
     * 剑指 Offer 07. 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如，给出
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
       int[] preorder = {3,9,20,15,7};
       int[] inorder = {9,3,15,20,7};
       TreeNode treeNode = buildTree2(preorder, inorder);
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //设置递归结束条件
        if (preorder == null || preorder.length == 0){
            return null;
        }

        //获取根节点value
        TreeNode root = new TreeNode(preorder[0]);
        //构建左子树和右子树
        int index = findIndex(preorder, inorder);
        //root.left = buildTree(左子树前序数组，左子树中序数组);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        //root.right = buildTree(右子树前序数组，右子树中序数组);
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));

        return null;
    }
    public static int findIndex(int[] preorder, int[] inorder){
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]){
                return i;
            }
        }
        return 0;
    }

    /************************************/
    public static HashMap<Integer,Integer> map = new HashMap<>();
    public static int[] pre;
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        pre = preorder;
        for(int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return rec(0,inorder.length-1,0);
    }
    //left,right指在inorder中的子树边界，root表示在preorder中当前根节点的索引
    public static TreeNode rec(int left, int right, int root){
        if(left>right) {
            return null;
        }
        TreeNode node = new TreeNode(pre[root]);
        //i表示当前根节点所在inorder的索引
        int i = map.get(pre[root]);
        node.left = rec(left,i-1,root+1);
        node.right = rec(i+1,right,i-left+root+1);//i-left等于
        return node;
    }
}
