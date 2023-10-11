package com.ds.tree.binary;


public class BSTUtil {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelp(root, null , null);
    }
    private boolean isValidBSTHelp(TreeNode root, Integer min, Integer max) {
        if(root == null){
            return true;
        }
        if((min != null && root.val < min) || (max!=null && root.val>max)) {
            return false;
        }
        return isValidBSTHelp(root.left, min, root.val) &&
                isValidBSTHelp(root.left, root.val, max);
    }

}
