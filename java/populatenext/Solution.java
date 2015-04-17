package com.skymoney.populatenext;



public class Solution {
	public class TreeLinkNode {
		      int val;
		      TreeLinkNode left, right, next;
		      TreeLinkNode(int x) { val = x; }
	}
	
	public void connect(TreeLinkNode root) {
        if(root.left != null && root.right != null){
        	root.left.next = root.right;
        }
        
        if(root.next != null && root.next.left != null){
        	root.right.next = root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
    }
}
