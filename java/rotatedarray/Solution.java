package com.skymoney.rotatearray;

public class Solution {
	public void swap(int[] nums, int start, int end){
		int i = start;
		int j = end-1;
		int temp = 0;
		while(i<j){
			temp = nums[i];
			nums[i++] = nums[j];
			nums[j--] = temp;
		}
		
	}
	
	public void rotate(int[] nums, int k) {
		if(nums.length == 0)
			return;
		k = k % nums.length;
		k = nums.length - k;
		swap(nums, 0, k);
		swap(nums, k, nums.length);
		swap(nums, 0, nums.length);
    }
	
	public static void main(String[] args){
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		new Solution().rotate(nums, 3);
		//System.out.println(nums);
		for(int i:nums){
			System.out.print(i + " ");
		}
	}
}
