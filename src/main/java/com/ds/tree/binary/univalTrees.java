package com.ds.tree.binary;

public class univalTrees {

    public boolean isUniVal(TreeNode root){
        if(root == null)
            return true;
        return isUniVal_Help(root);
    }

    private boolean isUniVal_Help(TreeNode node) {
        if(node.left == null && node.right == null)
            return true;
        boolean isRightUni = true;
        boolean isLeftUni = true;
        if(node.left !=null)
            isLeftUni = (node.val == node.left.val) && isUniVal_Help(node.left);
        if(node.right !=null)
            isRightUni = (node.val == node.right.val) && isUniVal_Help(node.right);
        return isLeftUni && isRightUni;
    }

    public static void main(String[] args) {
        Integer[] array = {5, 5, 5, 5, 5, null, 5};
        TreeNode root = TreeUtils.arrayToTree(array);
        TreeUtils.printTreeGraphics(root);
        univalTrees ut = new univalTrees();
        System.out.println("Is Unival : "+ut.isUniVal(root));
        System.out.println("Is BST : "+TreeUtils.isBST(root));
//        array = new Integer[]{1,2,3,4,5,6,7};
//        root = TreeUtils.arrayToTree(array);
//        TreeUtils.printTreeGraphics(root);
//        System.out.println(ut.isUniVal(root));
//        System.out.println(TreeUtils.isBST(root));
        array = new Integer[]{7,1,10,-1,5,null,20};
        root = TreeUtils.arrayToTree(array);
        TreeUtils.printTreeGraphics(root);
        System.out.println("Is Unival : "+ut.isUniVal(root));
        System.out.println("Is BST : "+TreeUtils.isBST(root));

    }
}
