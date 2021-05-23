package com.mahongbin.bean;

public class TreeNode {

    public TreeNode(TreeNode leftNode, TreeNode rightNode, int val) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.val = val;
    }

    private TreeNode leftNode;

    private TreeNode rightNode;

    private int val;

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

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
