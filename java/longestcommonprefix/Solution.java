package com.skymoney.longcommonprefix;

import java.util.ArrayList;

public class Solution {
	class Node{
		public char content;
		public int count;
		
		Node[] child;
		
		public Node(char content){
			this.content = content;
		}
	}
	/**
	 * 找出最长公共前缀
	 * trie树
	 * */
	public String longestCommonPrefix(String[] strs) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        
        if(strs.length == 0)
        	return null;
        if(strs.length == 1)
        	return strs[0];
        
        //build node chain
        for(int i=0;i<strs[0].length();i++){
        	Node n = new Node(strs[0].charAt(i));
        	n.count += 1;
        	nodes.add(n);
        }
        //System.out.println(nodes.size());
        for(int i=1;i<strs.length;i++){
        	for(int j=0;j<strs[i].length();j++){
        		if(nodes.size()>j){
        			if(nodes.get(j).content == strs[i].charAt(j)){
        				//System.out.println(nodes.get(j).content + " vs " + strs[i].charAt(j));
        				nodes.get(j).count += 1;
        			}
        		}else{
        			//new node build
        			Node n = new Node(strs[i].charAt(j));
        			n.count += 1;
        			nodes.add(n);
        		}
        	}
        }
        
        String result = "";
        int length = 0;
        while(length<nodes.size()){
        	if(nodes.get(length).count == strs.length){
        		result += nodes.get(length).content;
        	}else{
        		break;
        	}
        	
        	length++;
        }
        return result;
    }
	
	public static void main(String[] args){
		String[] strs = {"aca", "acd"};
		System.out.println(new Solution().longestCommonPrefix(strs));
		//new Solution().longestCommonPrefix(strs);
	}
}
