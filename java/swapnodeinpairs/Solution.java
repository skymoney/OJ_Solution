package com.skymoney.swapnodeinpairs;

public class Solution {
	public ListNode swapPairs(ListNode head) {
        if(head==null)
        	return null;
        if(head.next == null)
        	return head;
        
        ListNode current = head;
        ListNode currentNext = head.next;
        ListNode nextNode = currentNext.next;
        ListNode lastNode = null;
        head = head.next;
        while(current!=null){
        	current.next = currentNext.next;
        	currentNext.next = current;
        	
        	if(lastNode != null)
        		lastNode.next = currentNext;
        	lastNode = current;
        	
        	//move to next node
        	current = nextNode;
        	if(current==null)
        		break;
        	
        	currentNext = current.next;        	
        	if(currentNext == null)
        		break;
        	
        	nextNode = currentNext.next;        	
        }
        
        return head;
    }
	
	public static void main(String[] args){
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		a.next = b;
		b.next = c;
		//c.next = d;
		
		ListNode head = new Solution().swapPairs(a);
		
		while(head!=null){
			System.out.print(head.val + " -> ");
			head = head.next;
		}
	}
}

class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	}
}
