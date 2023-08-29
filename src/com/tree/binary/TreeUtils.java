package com.tree.binary;

public class TreeUtils {
    public static TreeNode arrayToTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);
        node.left = arrayToTree(arr, 2 * index + 1); // Left child
        node.right = arrayToTree(arr, 2 * index + 2); // Right child

        return node;
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static TreeNode bstToGst(TreeNode root) {
        bstToGst(root, new int[]{0});
        return root;
    }

    private static void bstToGst(TreeNode root, int[] sum) {
        if (root == null) {
            return;
        }

        bstToGst(root.right, sum);
        root.val = sum[0] + root.val;
        sum[0] = root.val;
        bstToGst(root.left, sum);
    }
}
