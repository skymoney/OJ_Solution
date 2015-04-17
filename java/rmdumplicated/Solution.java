package com.skymoney.rmdumplicated;

public class Solution {
	class ListNode {
		     int val;
		     ListNode next;
		     ListNode(int x) {
		         val = x;
		         next = null;
		     }
		     public String toString(){
		    	 return "ListNode[val= " + val + "]";
		     }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null)
			return head;
        ListNode current = head;
        ListNode flag = head;
        
        while(current!=null){
        	while(flag!=null && flag.val == current.val)
        		flag = flag.next;
        	current.next = flag;
        	current = flag;
        }
        return head;
    }
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		ListNode a = s.new ListNode(1);
		ListNode b = s.new ListNode(1);
		ListNode c = s.new ListNode(2);
		ListNode d = s.new ListNode(3);
		ListNode e = s.new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		
		s.deleteDuplicates(a);
		while(a!=null){
			System.out.print(a.val + " -> ");
			a = a.next;
		}
		
	}
}
