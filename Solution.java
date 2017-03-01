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
	public static int[] productExceptSelf(int[] nums) {
		int len = nums.length;
		int[] res = new int[len];
		res[0] = 1;
		for (int i = 0; i < len; i++) {
			
		}
	}
	
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
        	char key = s.charAt(i);
        	if (map.containsKey(key))
        		map.put(key, map.get(key) + 1);
        	else
        		map.put(key, 1);        	
        }
        
        List<Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character,Integer>>(map.entrySet());
        
        Collections.sort(list, new Comparator<Map.Entry<Character,Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return -(o1.getValue()).compareTo(o2.getValue());
			}
        	
		});
        
        StringBuilder sb = new StringBuilder();
        
        for (Entry<Character, Integer> entry : list) {
			char ch = entry.getKey();
			int num = entry.getValue();
			System.out.println(ch);
			System.out.println(num);
			for (int i = 0; i < num; i++) {
				sb.append(ch);
			}
		}
        
        return sb.toString();
        
    }
	
	public static void main(String[] args) {
		System.out.println(frequencySort("baAA"));
	}

}
