package com.algorithm.everyDay;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 *
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class DiameterOfBinaryTree {

    /**
     * 节点最大个数
     */
    public static int nodeNum = 0;

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n1.left = n2;
        n1.right = n3;

        n2.left = n4;
        n2.right = n5;


        System.out.println(diameterOfBinaryTree(n1));
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        nodeNum = 1;
        fun(root);
        return nodeNum - 1;
    }

    private static int fun(TreeNode root) {
        if(root == null) {//无节点
            return 0;
        }
        int L = fun(root.left);
        int R = fun(root.right);

        //当前计算节点以及它子树的节点个数 L+R+1
        //找出最多节点分支，防止先计算了多的节点数然后被少的节点数目覆盖
        nodeNum = Math.max(nodeNum, L+R+1);

        //当前分支节点最多的分支 + 1
        return Math.max(L, R) + 1;
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
