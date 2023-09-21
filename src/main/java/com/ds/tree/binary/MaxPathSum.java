package com.ds.tree.binary;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 */
public class MaxPathSum {
    /**
     * if(null) return 0
     * if(leaf) return nodeVal
     * int leftmax =+ maxsum(node.val)
     * int rightmax =+ maxsum(node.val)
     * acmax = max(acmax, right+left+root)
     *
     */
    int maxPath = 0;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelp(root);
        return maxPath;
    }

    private int maxPathSumHelp(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left ==null && root.right==null)
            return root.val;
        int leftMax =0, rightMax =0;
         leftMax = Math.max(maxPathSumHelp(root.left), 0);
        rightMax = Math.max(maxPathSumHelp(root.right), 0);
        maxPath = Math.max(maxPath, leftMax +rightMax+root.val);
        return Math.max(leftMax+root.val, rightMax+root.val);
    }

    public static void main(String[] args) {

        Integer[] treeArr = {-10,9,20,null,null,15,7};
        TreeNode root = TreeUtils.arrayToTree(treeArr);
        TreeUtils.printTreeGraphics(root);;
        MaxPathSum mps = new MaxPathSum();
        mps.maxPathSum(root);
        System.out.println(mps.maxPath);
    }
}
