package com.ds.tree.binary;

import javax.swing.tree.TreeCellRenderer;

public class LCABinaryTree {
    TreeNode lca;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return root;
        }
        lowestCommonAncestor_help(root, p, q);
        return this.lca;
    }

    public boolean lowestCommonAncestor_help(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }
        int l = lowestCommonAncestor_help(root.left, p, q) ? 1 : 0;
        int r = lowestCommonAncestor_help(root.right, p, q) ? 1 : 0;
        int m = (root.val == p.val || root.val == q.val) ? 1 : 0;
        if(l+r+m >= 2) {
            this.lca = root;
        }
        return (l+r+m > 0);
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode root = TreeUtils.arrayToTree(arr);
        TreeUtils.printTreeGraphics(root);
        LCA
    }
}
