package com.ashu.examples;

public class VowelOrder {

	public static void main(String[] args) {
		String alphabets = "abeciiiigoooou";
		String onlyVowels = "";
		String vowel = "aeiou";
		boolean permit = false;
		for(int i=0 ; i<alphabets.length(); i++){
			String vowelChar = alphabets.substring(i, i+1);
			if(permit){
				if(vowel.contains(vowelChar)){
					if(vowelChar.compareTo(onlyVowels.substring(onlyVowels.length()-1))>=0){
						onlyVowels += vowelChar;
					}
				}
			}
			else if(vowelChar.equals("a")){
				permit = true;
				onlyVowels += vowelChar;
			}
		}
		System.out.println(onlyVowels);  
	}
}
