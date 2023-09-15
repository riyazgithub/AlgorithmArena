package com.ds.tree.binary;

public class greaterBinaryTree {
    public static void main(String[] args) {
        int[] binaryTreeArray = {1, 2, 3, 4, -1, 5, 6}; // Example array representation

        TreeNode root = TreeUtils.arrayToTree(binaryTreeArray, 0);

        System.out.println("In-Order Traversal of Constructed Binary Tree:");
        TreeUtils.printInOrder(root);

        System.out.println();
        TreeUtils.bstToGst(root);
        TreeUtils.printInOrder(root);
    }
}
