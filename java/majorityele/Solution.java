package com.skymoney.majorityele;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int ele = 0;
        int ele_count = 0;
        
        for(int n: num){
        	count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        for(int key: count.keySet()){
        	if(count.get(key) > ele_count){
        		ele = key;
        		ele_count = count.get(key);
        	}
        }
        
        return ele;
    }
}
