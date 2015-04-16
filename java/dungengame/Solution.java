package com.skymoney.dungengame;

public class Solution {
	/**
	 * 动态规划
	 * h[i][j]为穿过i*j 格子最少的生命值
	 * h[0][0] = 1 if dungeon[0][0]>=0 else 1-dungeon[0][0]
	 * h[i][j+1] = h[i][j] if dungeon[i][j+1]>=0 else 
	 * h[i+1][j] = h[i][j]
	 * 向后扩展不可行，本例为向前扩展
	 * h[M-1][N-1] = Max{1, 1-dungeon[M-1][N-1]}
	 * h[i][N-1] = Max{h[i+1][N-1]-dungeon[i][N-1], 1}
	 * h[M-1][j] = Max{h[M-1][j+1]-dungeon[M-1][j], 1}
	 * 
	 * h[i][j] = Min{Max{h[i+1][j]-dungeon[i][j], 1}, Max{h[i][j+1]-dungeon[i][j], 1}}
	 * */
	public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length == 0)
        	return 1;
        int M = dungeon.length;
        int N = dungeon[0].length;
        
        int[][] health = new int[M][N];
        
        health[M-1][N-1] = Math.max(1 - dungeon[M-1][N-1], 1);
        System.out.println(health[M-1][N-1]);
        for(int i=M-2;i>=0;i--){
        	health[i][N-1] = Math.max(health[i+1][N-1]-dungeon[i][N-1], 1);
        }
        for(int j=N-2;j>=0;j--){
        	health[M-1][j] = Math.max(health[M-1][j+1]-dungeon[M-1][j], 1);
        }
        
        for(int i=M-2;i>=0;i--){
        	for(int j=N-2;j>=0;j--){
        		int result1 = Math.max(health[i+1][j]-dungeon[i][j], 1);
        		int result2 = Math.max(health[i][j+1]-dungeon[i][j], 1);
        		health[i][j] = Math.min(result1, result2);
        	}
        }
        
        return health[0][0];
    }
	
	public static void main(String[] args){
		//int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		int[][] dungeon = {{-200}};
		System.out.println(new Solution().calculateMinimumHP(dungeon));
	}
}
