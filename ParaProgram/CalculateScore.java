package com.ashu.examples;

import java.util.Scanner;

public class CalculateScore {

	public static void main(String[] args) {
		
		String text = "nothing";
		String prefixString = "exeno";
		String suffixString = "hingoo";
		String prefix = "";
		String suffix = "";
		
		if(text != null && prefixString != null){
			for(int i = 1; i <= prefixString.length(); i++){
				String temp = prefixString.substring(prefixString.length()-i, prefixString.length());	
				if(text.contains(temp)){
					prefix = temp; 
				}
			}
		}

		if(text != null && suffixString != null){
			for(int i = 1; i <= suffixString.length(); i++){
				String temp = suffixString.substring(0,i);	
				if(text.contains(temp)){
					suffix = temp; 
				}
			}
		}
		System.out.println(text.indexOf(suffix));
		System.out.println(text.substring(text.indexOf(prefix), text.indexOf(suffix) + suffix.length()));
	}
}
