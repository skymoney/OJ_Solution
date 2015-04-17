package com.skymoney.longestparentthess;

/**
 * 找出最长的正确括号子字符串
 * 使用dp实现
 * d[i] 为 s[i](包含) 到s[s.length-1]的字符串中有效括号的长度
 * 则：
 * 1，d[s.length-1] = 0
 * 2，如果s[i]=='('，j = i+1+d[i+1] 如果 j<s.length && s[j]==')' d[i] = d[i+1] + 2
 * 2.1，并且如果j+1<s.length，d[i] += d[j+1]
 * 最后找出最大的d[i]
 * 
 * 另一种利用stack的解法
 * Stack<Integer> stk = new Stack<Integer>();
        int res = 0;
        char[] ch = s.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i] == '(')
                stk.push(i);
            else{
                if(!stk.isEmpty() && ch[stk.peek()] == '('){
                    stk.pop();
                    res = Math.max(stk.isEmpty()?i+1:i-stk.peek() ,res );
                }
                else
                    stk.push(i);
            }
        }
        return res;
 * */
public class Solution {
	
	public int longestValidParentheses(String s) {
		if(s.length() == 0)
			return 0;
        int[] d = new int[s.length()];
        d[s.length()-1] = 0;
        int j= 0;
        int max = 0;
        for(int i=s.length()-2;i>=0;i--){
        	if(s.charAt(i)=='('){
        		j = i + 1 + d[i+1];
        		if(j<s.length() && s.charAt(j)==')'){
        			d[i] = 2 + d[i+1];
        			if((j+1)<s.length())
        				d[i] += d[j+1];
        		}
        	}
        	
        	max = max>d[i]?max:d[i];
        }
        
        return max;
    }
	
	public static void main(String[] args){
		System.out.println(new Solution().longestValidParentheses("("));
	}
}
