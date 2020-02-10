package com.java.ashu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;

public class ParaProgram {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testcase = Integer.parseInt(scn.nextLine());
		List<String>  highestChar = new ArrayList<String>();
		while(testcase > 0){
		String s1 = scn.nextLine();
		String s2 = "";
		char c;
		Map<String, Integer> map = new HashMap<>();
		for (int k = 0; k < s1.length(); k++) {
			c = s1.charAt(k);
			if (s2.indexOf(c) == -1) {
				int number = getCount(s1, c);
				String cr = c + "";
				map.put(cr, number);
				s2 += c;
			}
		}
		
		Map<String, Integer> concurrentMap = new ConcurrentHashMap<String, Integer>(map);
		String maxKey = concurrentMap.keySet().iterator().next();
		Integer max = concurrentMap.get(maxKey);
		
		for(String key : concurrentMap.keySet()){
			Integer currValue = concurrentMap.get(key);
			if(max<currValue){
				concurrentMap.remove(maxKey);
				max = concurrentMap.get(key);
				maxKey = key;
			}else if(max>currValue){
				concurrentMap.remove(key);
			}
		}

		List<String> list = new ArrayList<String>(concurrentMap.keySet());
		
		String temp;
		if (list.size() > 1) {
			for (int h = 0; h < list.size() - 1; h++) {
				for (int b = 0; b < list.size() - 1 - h; b++) {
					if (list.get(b).toString().compareTo(list.get(b+1).toString()) > 0) {
						temp = list.get(b);
						list.set(b,list.get(b+1));
						list.set(b+1,temp);
					}
				}
			}
		}
		highestChar.add(list.get(list.size()-1));
		testcase--;
	 }
		for(String cr: highestChar){
			System.out.println(cr);
		}
	}

	public static int getCount(String s, char cr) {
		return s.length() - s.replace(cr + "", "").length();
	}

}
