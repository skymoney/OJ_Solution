package com.skymoney.addtwonums;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		if(l1 == null)
			return l1;
		if(l2 == null)
			return l2;
		
		ListNode resultHead = null;
		ListNode last = null;
		ListNode current = null;
		
		int flag = 0;
		int result = 0;
		boolean head = true;
		
		//先计算第一个保存为head

		do{
			result = l1.val + l2.val;
			
			if(flag == 1){
				result += flag;
				flag = 0;
			}
			
			if(result > 9){
				flag = 1;
				result = result - 10;
			}
			
			current = new ListNode(result);
			if(head){
			resultHead = current;
			head = false;
			last = resultHead;
			}else{
			last.next = current;
			last = current;
			}
			
			l1 = l1.next;
			l2 = l2.next;
		}while(l1 != null && l2 != null);
		
		
		
		if(l1 == null && l2 != null){
			// l1 empty l2 not empty
			while(l2 != null){
				if((l2.val + flag) > 9){
					current = new ListNode(l2.val + flag - 10);
					flag = 1;
				}else{
					current = new ListNode(l2.val + flag);
					flag = 0;
				}
				last.next = current;
				last = current;
				
				l2 = l2.next;
			}
			if(flag == 1){
				current = new ListNode(1);
				last.next = current;
				last = current;
			}
		}else if(l1 != null && l2 == null){
			//l1 not empty l2 empty
			while(l1 != null){
				if((l1.val + flag) > 9){
					current = new ListNode(l1.val + flag - 10);
					flag = 1;
				}else{
					current = new ListNode(l1.val + flag);
					flag = 0;
				}
				last.next = current;
				last = current;
				
				l1 = l1.next;
			}
			if(flag == 1){
				current = new ListNode(1);
				last.next = current;
				last = current;
			}
		}else{
			//all empty
			if(flag == 1){
				ListNode highest = new ListNode(1);
				last.next = highest;
			}
		}
		return resultHead;
	}
	
	public static void main(String[] args){
		ListNode l1 = new ListNode(1);
		//ListNode l12 = new ListNode(4);
		//ListNode l13 = new ListNode(3);
		//l1.next = l12;
		//l12.next = l13;
		
		ListNode l2 = new ListNode(9);
		ListNode l22 = new ListNode(9);
		//ListNode l23 = new ListNode(6);
		//ListNode l24 = new ListNode(1);
		l2.next = l22;
		//l22.next = l23;
		//l23.next = l24;
		
		ListNode r = new Solution().addTwoNumbers(l1, l2);
		
		while(r != null){
			System.out.print(r.val + "->");
			r = r.next;
		}
	}
}
