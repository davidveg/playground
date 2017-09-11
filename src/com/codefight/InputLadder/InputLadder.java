package com.codefight.InputLadder;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class InputLadder {
	static int wordLadder(String beginWord, String endWord, String[] wordList) {
		final Map<String, String> map = new HashMap<String, String>();
		for (String word : wordList) {
			map.put(word, word);
		}
		int total = 0;
		String searchWord = beginWord;
		boolean skip = false;
		while (!searchWord.equals(endWord) && !map.isEmpty()) {
			for (char c : searchWord.toCharArray()) {
				for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
					String keyString = searchWord.replace(c, alphabet);
					if (map.containsKey(keyString)) {
 						if(!beginWord.equals(searchWord)){
							total++;
						}
						searchWord = keyString;
						map.remove(keyString);
					}
				}
			}
		}
		if(!searchWord.equalsIgnoreCase(endWord) && map.isEmpty())
			return 0;
		return total;
	}

	public static void main(String[] args) {

		String beginWord = "hot";
		String endWord = "dog";
		String[] wordList = new String[] { "hot", "dog"};
		
		Instant start = Instant.now();
		System.out.println(wordLadder(beginWord, endWord, wordList));
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
		

	}
}
