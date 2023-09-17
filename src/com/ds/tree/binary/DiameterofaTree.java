package com.ds.tree.binary;

public class DiameterofaTree {

    public int diameterOfBinaryTree(TreeNode root) {
        if(root ==null)
            return 0;
        diameterOfBinaryTree_Help(root);
        System.out.println("Max Diameter of BST "+ maxD);
        return maxD;
    }

    public int diameterOfBinaryTree_Help(TreeNode node) {
        if(node.left== null &&
                node.right == null) return 0;
        int lH =0;
        int rH =0;
        if(node.left!=null)
            lH = diameterOfBinaryTree_Help(node.left) +1;
        if(node.right!=null)
            rH = diameterOfBinaryTree_Help(node.right) +1;
        int currD = lH+rH;
        maxD = Math.max(currD, maxD);
        if (lH>rH)
            return lH;
        return rH;
    }
    int maxD =0;
    public int diameterofaTree1(TreeNode root) {
        if(root==null)
            return 0;
        diameterofaTreeHelp1(root);
        return maxD;

    }
    private int diameterofaTreeHelp1(TreeNode node) {
        // leaf node
        if(node.left== null &&
                node.right == null) return 0;
        int lH =0;
        int rH =0;
        if(node.left !=null) {
            lH = diameterofaTreeHelp1(node.left) + 1;
        }
            rH = diameterofaTreeHelp1(node.right) + 1;
        int currD = lH+rH;
        maxD = Math.max(currD,maxD);
        if (lH>rH)
            return lH;
        return rH;
    }

    public static void main(String[] args) {

        TreeNode root1 = TreeUtils.arrayToTree(new int[]{1,2,3,4,5}, 0);
        System.out.println();
        TreeUtils.printTreeGraphics(root1);

        DiameterofaTree dt = new DiameterofaTree();
        System.out.println(dt.diameterOfBinaryTree(root1));
        dt.maxD =0;
        System.out.println(dt.diameterofaTree1(root1));
    }
}
