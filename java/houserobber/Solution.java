package com.skymoney.hosuerobber;

public class Solution {
	/**
	 * h[i] 代表每个房子的价值
	 * v[i] 代表前i个房子能偷到的最大价值
	 * v[0] = h[0]
	 * v[1] = max{h[0], h[1]}
	 * v[i] = max{v[i-2] + h[i], v[i-1]}
	 * */
	public int rob(int[] num) {
        int v[] = new int[num.length];
        if(num.length == 1)
        	return num[0];
        if(num.length == 2)
        	return Math.max(num[0], num[1]);
        
        v[0] = num[0];
        v[1] = Math.max(num[0], num[1]);
        for(int i=2;i<num.length;i++){
        	v[i] = Math.max(v[i-2] + num[i], v[i-1]);
        }
        
        return v[v.length-1];
    }
	
	public static void main(String[] args){
		int[] num = {2, 3, 6, 7, 3};
		System.out.println(new Solution().rob(num));
	}
}
