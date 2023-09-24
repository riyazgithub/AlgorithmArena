package com.ds.tree.binary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    public static List<TreeNode> treeToArrBFS(TreeNode root) {
        List<TreeNode> arr = new ArrayList<>();
        treeToArrBFSHelp(root, arr);

        return arr;
    }

    private static void treeToArrBFSHelp(TreeNode root, List<TreeNode> arr) {
        if(root == null)
        {
            arr.add(null);
        }
        Queue<TreeNode> ql = new LinkedList<>();
        ql.add(root);
        arr.add(root);
        while (!ql.isEmpty()) {
            TreeNode curr = ql.poll();
            if(curr != null) {
                ql.add(curr.left);ql.add(curr.right);
                if(curr.left!=null || curr.right!=null)
                    arr.add(curr.left);arr.add(curr.right);
            }
        }
    }

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

    public static TreeNode arrayToTree(Integer[] array) {
        if (array == null || array.length == 0 || array[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;
        while (!queue.isEmpty() && index < array.length) {
            TreeNode current = queue.poll();

            if (array[index] != null) {
                current.left = new TreeNode(array[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < array.length && array[index] != null) {
                current.right = new TreeNode(array[index]);
                queue.offer(current.right);
            }
            index++;
        }

        return root;
    }

    /**
     * Print tree in graphical format
     * @param root
     */
    public static void printTreeGraphics(TreeNode root) {
        printTreeGraphics(root, "", true);
    }

    private static void printTreeGraphics(TreeNode node, String prefix, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.val);
            printTreeGraphics(node.left, prefix + (isLeft ? "│   " : "    "), true);
            printTreeGraphics(node.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static boolean isBST(TreeNode node){
        if (node == null)
        {
            return true;
        }
        return isBSTHelp(node);
    }

    private static boolean isBSTHelp(TreeNode node) {
        if(node.left == null && node.right == null)
            return true;
        boolean isRightBST = true;
        boolean isLeftBST = true;
        if(node.left !=null)
            isLeftBST = (node.val >= node.left.val) && isBSTHelp(node.left);
        if(node.right !=null)
            isRightBST = (node.val <= node.right.val) && isBSTHelp(node.right);
        return isLeftBST && isRightBST;

    }
}
