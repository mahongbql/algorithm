package com.algorithm.bean;

public class BinaryTree {

    public static TreeNode getBinaryTree(Integer[] array) {
        if(array.length < 1) return null;

        return constructBinaryTree(array, 0);
    }

    private static TreeNode constructBinaryTree(Integer[] array, int n) {
        if(n >= array.length) return null;

        TreeNode leftNode = constructBinaryTree(array, 2*n+1);
        TreeNode rightNode = constructBinaryTree(array, 2*n+2);

        return new TreeNode(leftNode, rightNode, array[n]);
    }
}
