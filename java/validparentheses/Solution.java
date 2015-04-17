package com.skymoney.validparentheses;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	
    	for(int i=0; i<s.length(); i++){
    		if (s.charAt(i) == '(' || s.charAt(i) == '{' || 
    				s.charAt(i) == '[') stack.add(s.charAt(i));
    		try{
    		if (s.charAt(i) == ')' && stack.pop() != '(') {
    			return false;
    		}
    		
    		if (s.charAt(i) == '}' && stack.pop() != '{'){
    			return false;
    		}
    		
    		if (s.charAt(i) == ']' && stack.pop() != '['){
    			return false;
    		}
    		}catch(EmptyStackException e){
    			return false;
    		}
    	}
    	
    	if(stack.size()>0)
    		return false;
        return true;
    }
    
    public static void main(String[] args){
    	System.out.println(new Solution().isValid("()[]"));
    }
}
