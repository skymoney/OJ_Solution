package com.skymoney.singlenum;

public class Solution {
    public int singleNumber(int[] A) {
        int[] bits = new int[32];
        int result = 0;
        
        for(int i=0;i<A.length;i++){
        	for(int j=0;j<32;j++){
        		bits[j] += (A[i]>>j) & 1;
        	}
        }
        
        for(int i=0;i<bits.length;i++){
        	if(bits[i]%3 != 0)
        		result += 1<<i;
        }
        
        return result;
    }
    
    public static void main(String[] args){
    	int[] data = {2, 2, 2, 3, 3, 3, 1};
    	System.out.println(new Solution().singleNumber(data));
    }
}
