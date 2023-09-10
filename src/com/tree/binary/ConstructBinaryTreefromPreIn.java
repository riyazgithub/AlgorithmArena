package com.tree.binary;

import java.util.HashMap;

public class ConstructBinaryTreefromPreIn {
    int preOrderIndex =0;
    HashMap<Integer, Integer> ioMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // construct ioMap

        for (int i = 0; i< inorder.length; i++) {
            ioMap.put(inorder[i], i);
        }
        return buildTreeHelp(preorder, 0, inorder.length-1);
    }

    private TreeNode buildTreeHelp(int[] preorder, int left, int right) {
        if(left > right)
            return null;
        int inIndex = ioMap.get(preorder[preOrderIndex]);
        TreeNode root = new TreeNode(preorder[preOrderIndex]);
        preOrderIndex++;

        root.left = buildTreeHelp(preorder, left, inIndex-1);
        root.right = buildTreeHelp(preorder, inIndex+1, right);
        return root;
    }

    public static void main(String[] args) {

        int[] ino = {9,3,15,20,7};
        int[] po = {3,9,20,15,7};
        ConstructBinaryTreefromPreIn cbt = new ConstructBinaryTreefromPreIn();
        TreeNode root = cbt.buildTree(po, ino);
        System.out.println();
        TreeUtils.printInOrder(root);
    }

}
