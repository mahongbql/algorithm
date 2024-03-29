package com.algorithm.bean;

public class TreeNode {

    public TreeNode(TreeNode leftNode, TreeNode rightNode, Integer val) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.val = val;
    }

    private TreeNode leftNode;

    private TreeNode rightNode;

    private Integer val;

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }
}
