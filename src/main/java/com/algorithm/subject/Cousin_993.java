package com.mahongbin.subject;

import com.mahongbin.bean.BinaryTree;
import com.mahongbin.bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 表亲
 *
 *          1
 *     2         3
 * 4      5   6     7
 *
 * 4 和 6 是表亲，一样的层数，不同的父亲
 */
public class Cousin_993 {

    private static int xVal;

    private static int yVal;

    private static Integer xParent;

    private static Integer yParent;

    private static boolean xfind;

    private static boolean yfind;

    private static int xlevel;

    private static int ylevel;

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7};
        int x = 2;
        int y = 3;
        TreeNode root = BinaryTree.getBinaryTree(array);

        //深度优先遍历
        boolean dfsResult = DFS(root, x, y);

        clearStaticVal();

        //广度优先遍历
        boolean bfsResult = BFS(root, x, y);

        System.out.println(String.format("dfsResult: %s, bfsResult: %s", dfsResult, bfsResult));
    }

    /**
     * 清空静态属性
     */
    private static void clearStaticVal() {
        xVal = -1;

        yVal = -1;

        xParent = -1;

        yParent = -1;

        xfind = false;

        yfind = false;

        xlevel = -1;

        ylevel = -1;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    private static boolean BFS(TreeNode root, int x, int y) {
        xVal = x;
        yVal = y;

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> levelQueue = new LinkedList<Integer>();

        nodeQueue.offer(root);
        levelQueue.offer(0);

        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            Integer level = levelQueue.poll();

            packageBfsVal(node.getLeftNode(), node.getVal(), level+1);

            if(xfind && yfind) break;

            nodeQueue.offer(node.getLeftNode());
            levelQueue.offer(level+1);

            packageBfsVal(node.getRightNode(), node.getVal(), level+1);

            if(xfind && yfind) break;

            nodeQueue.offer(node.getRightNode());
            levelQueue.offer(level+1);

        }

        return xlevel == ylevel && (xParent != yParent);
    }

    /**
     * 广度遍历封装属性
     * @param node
     * @param parent
     * @param n
     */
    private static void packageBfsVal(TreeNode node, Integer parent, int n) {
        if(null == node) return;

        if(node.getVal() == xVal) {
            xParent = parent;
            xfind = true;
            xlevel = n;
        } else if(node.getVal() == yVal) {
            yParent = parent;
            yfind = true;
            ylevel = n;
        }
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    private static boolean DFS(TreeNode root, int x, int y) {
        xVal = x;
        yVal = y;

        dfsSearch(root,null, 0);


        return xlevel == ylevel && (xParent != yParent);
    }

    /**
     * 深度遍历递归函数
     * @param node
     * @param n
     */
    private static void dfsSearch(TreeNode node, Integer parent, int n) {
        if(null == node) return;

        if(node.getVal() == xVal) {
            xParent = parent;
            xfind = true;
            xlevel = n;
        } else if(node.getVal() == yVal) {
            yParent = parent;
            yfind = true;
            ylevel = n;
        }

        if(xfind && yfind) return;

        dfsSearch(node.getLeftNode(), node.getVal(), n+1);

        if(xfind && yfind) return;

        dfsSearch(node.getRightNode(), node.getVal(), n+1);
    }
}
