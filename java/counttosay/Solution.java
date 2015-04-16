package com.skymoney.counttosay;

public class Solution {
	public String say(String countStr){
		//format 111 22 same char seq
		String say = String.valueOf(countStr.length());
		int a = countStr.charAt(0) - 48;
		
		return say + String.valueOf(a);
	}
	
	public String countAndSay(int n) {
        String toReturn = "1";
        int round = 1;
        int currentLen = 0;
        char current;
        int idx = 0;
        String temp = "";
        String nowStr = "";
        
        while(round<n){
        	while(currentLen<toReturn.length()){
        		current = toReturn.charAt(currentLen);
        		while(idx < toReturn.length() && toReturn.charAt(idx) == current){
        			temp += toReturn.charAt(idx++);
        		}
        		nowStr += say(temp);
        		temp = "";
        		currentLen = idx;
        	}
        	toReturn = nowStr;
        	nowStr = "";
        	currentLen = 0;
        	idx=0;
        	
        	round++;
        }
        
        return toReturn;
    }
	
	public static void main(String[] args){
		System.out.println(new Solution().countAndSay(1));
	}
}
