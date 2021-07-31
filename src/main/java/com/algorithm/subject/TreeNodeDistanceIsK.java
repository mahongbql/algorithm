package com.algorithm.subject;

import com.algorithm.bean.BinaryTree;
import com.algorithm.bean.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: mahongbin
 * @Date: 2021-07-28 22:15
 * @Description: 863. 二叉树中所有距离为 K 的结点
 *
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *                         3
 *              5                     1
 *        6           2         0           8
 * null     null   7     4
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *  
 *
 * 提示：
 *
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 *
 */
public class TreeNodeDistanceIsK {
    public static List<Integer> list = new ArrayList<>();
    public static Map<Integer, TreeNode> parentMap = new HashMap<>();

    public static void main(String[] args) {
        Integer[] array = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = BinaryTree.getBinaryTree(array);

        TreeNode target = root.getLeftNode();
        System.out.println(distanceK(root, target, 2));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root == null) return list;

        parentMap.put(root.getVal(), null);
        findParent(root);

        findTargetK(target, null, k, 0);

        return list;
    }

    private static void findTargetK(TreeNode node, TreeNode from, int k, int distance) {
        if(node == null) return;

        if(k == distance && null != node.getVal()) {
            list.add(node.getVal());
            return;
        }

        if(node.getLeftNode() != from) {
            findTargetK(node.getLeftNode(), node, k, distance+1);
        }

        if(node.getRightNode() != from) {
            findTargetK(node.getRightNode(), node, k, distance+1);
        }

        if(parentMap.get(node.getVal()) != from) {
            findTargetK(parentMap.get(node.getVal()), node, k, distance+1);
        }
    }

    private static void findParent(TreeNode node) {
        if(node.getLeftNode() != null) {
            parentMap.put(node.getLeftNode().getVal(), node);
            findParent(node.getLeftNode());
        }

        if(node.getRightNode() != null) {
            parentMap.put(node.getRightNode().getVal(), node);
            findParent(node.getRightNode());
        }
    }
}
