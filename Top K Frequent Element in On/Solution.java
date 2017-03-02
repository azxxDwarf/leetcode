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
    	/*ˮͰ�ǣ�Ϊ��װnum���ֵ�Ƶ��
    	 * ��ʱ��ֻ��Ҫ����ȥ���ݣ�addAll to list��ok��
    	 * �����ͱ���������ֻ��ҪO(n)
    	 */
    	List<Integer>[] buckets = new List[nums.length + 1];
    	
    	List<Integer> list = new ArrayList<Integer>();
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	//��map
    	for (int key : nums) {
    		if (map.containsKey(key))
    			map.put(key, map.get(key) + 1);
    		else
    			map.put(key, 1);
    	}
    	
    	//����һ��map��װˮͰ
    	for (Integer key : map.keySet()) {
    		int freq = map.get(key);
    		if (buckets[freq] == null)
    			buckets[freq] = new ArrayList<Integer>();
    		buckets[freq].add(key);
    	}
    	
    	//�����ˮͰ��������ʢ��list�з���
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
