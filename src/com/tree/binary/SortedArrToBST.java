package com.tree.binary;

import java.util.List;

public class SortedArrToBST {
    /**
     * Given an integer array nums where the elements are sorted in ascending order, convert it to a
     * height-balanced
     *  binary search tree.
     */

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums.length == 0)
            return null;
        return sortedArrayToBSTHelp(nums, 0, nums.length -1);
    }

    private TreeNode sortedArrayToBSTHelp(int[] nums, int s, int e) {
        if(s>e)
            return null;
        if(s==e)
            return new TreeNode(nums[s]);
        int mid = s+ (e-s)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left  = sortedArrayToBSTHelp(nums, s, mid-1);
        root.right  = sortedArrayToBSTHelp(nums, mid+1, e);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        SortedArrToBST sb = new SortedArrToBST();
        TreeNode root = sb.sortedArrayToBST(nums);
        System.out.println();
        TreeUtils.printInOrder(root);
        List<TreeNode> arr = TreeUtils.treeToArrBFS(root);
        System.out.println();
        System.out.println(arr);
}
}
