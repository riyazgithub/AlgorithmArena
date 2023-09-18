package com.ds.tree.binary;

public class univalTrees {

    public static void main(String[] args) {
        Integer[] array = {5, 5, 5, 5, 5, null, 5};
        TreeNode root = TreeUtils.arrayToTree(array);
        TreeUtils.printTreeGraphics(root);
        array = new Integer[]{1,2,3,4,5,6,7};
        root = TreeUtils.arrayToTree(array);
        TreeUtils.printTreeGraphics(root);
    }
}
