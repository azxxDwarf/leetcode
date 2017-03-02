package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
    public static List<Integer> topKFrequent(int[] nums, int k) {
    	/*水桶们，为了装num出现的频率
    	 * 到时候只需要倒序去数据，addAll to list就ok了
    	 * 这样就避免了排序，只需要O(n)
    	 */
    	List<Integer>[] buckets = new List[nums.length + 1];
    	
    	List<Integer> list = new ArrayList<Integer>();
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	//存map
    	for (int key : nums) {
    		if (map.containsKey(key))
    			map.put(key, map.get(key) + 1);
    		else
    			map.put(key, 1);
    	}
    	
    	//遍历一次map，装水桶
    	for (Integer key : map.keySet()) {
    		int freq = map.get(key);
    		if (buckets[freq] == null)
    			buckets[freq] = new ArrayList<Integer>();
    		buckets[freq].add(key);
    	}
    	
    	//倒序把水桶倒出来，盛到list中返回
    	for (int i = buckets.length - 1; i >= 0 && list.size() < k; i--) {
    		if (buckets[i] != null)
    			list.addAll(buckets[i]);
    	}
    	
    	return list;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		System.out.println(topKFrequent(nums, 2));
	}

}
