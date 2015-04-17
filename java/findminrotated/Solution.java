package com.skymoney.findminrotated;

public class Solution {
	public int findMin(int[] num) {
		if(num.length == 0)
			return 0;
		int i = 0;
        while(i<num.length-1){
        	if(num[i]>num[i+1])
        		return num[i+1];
        	i++;
        }
        return num[0];
    }
	
	public static void main(String[] args){
		int[] num = {1, 2, 4, 5, 6, 7};
		System.out.println(new Solution().findMin(num));
	}
}
