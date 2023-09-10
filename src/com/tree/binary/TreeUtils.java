package com.tree.binary;

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

    public TreeNode sortedArrayToBST(int[] nums) {
        List<Integer> convert = new ArrayList<>();
        return null;
    }
}
