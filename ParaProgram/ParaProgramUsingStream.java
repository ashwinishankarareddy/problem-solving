package com.java.ashu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class ParaProgramUsingStream {
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int testcase = Integer.parseInt(scn.nextLine());
		List<String> highestChar = new ArrayList<String>();
		while (testcase > 0) {
			String str = scn.nextLine();
			//creates Map of Letter and number of its occurances.
			Map<String, Long> map = str.chars().mapToObj(c -> Character.toString((char) c))
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

			Long max = Collections.max(map.values());
			
			//Get list of Letters with maximum occurances.
			List<String> listOfMax = map.entrySet().stream().filter(entry -> entry.getValue() == max)
					.map(Map.Entry::getKey).collect(Collectors.toList());
			
			//Letter with maximum ASCII Value.
			String maxChar = listOfMax.stream().max(Comparator.comparing(String::valueOf)).get();

			highestChar.add(maxChar);
			testcase--;
		}
		highestChar.forEach(System.out::println);
	}
}