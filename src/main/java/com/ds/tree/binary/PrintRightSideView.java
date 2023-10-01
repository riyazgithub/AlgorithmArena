package com.ds.tree.binary;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return retList;
        q.offer(root); q.offer(null);
        TreeNode prev = q.peek();
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null)
            {
                if(prev != null) {
                    retList.add(prev.val);
                    q.offer(curr);
                }
            } else {
                if(curr.left!=null) {
                    q.offer(curr.left);
                }
                if(curr.right!=null) {
                    q.offer(curr.right);
                }
            }
            prev = curr;
        }
        return retList;
    }
    public static void main(String[] args) {
        Integer[] treeArr = {-10,9,20,null,null,15,7,null,null,null,null,3,null};
        TreeNode root = TreeUtils.arrayToTree(treeArr);
        TreeUtils.printTreeGraphics(root);;
        PrintRightSideView pr = new PrintRightSideView();
        System.out.println(pr.rightSideView(root));
    }
}
