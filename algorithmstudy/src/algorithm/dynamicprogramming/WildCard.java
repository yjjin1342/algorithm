package algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WildCard {

	private int[][] cache = new int[101][101];
	private List<String> resultList;

	private char[] wChar;
	private char[] sChar;

	public WildCard() {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		this.resultList = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			String pattern = sc.next();
			this.wChar = pattern.toCharArray();
			int wordCount = sc.nextInt();
			for (int j = 0; j < wordCount; j++) {
				String word = sc.next();
				this.resultList.add(word);
			}
		}

		sc.close();
		this.solve();
	}

	// 완전탐색으로 구현
	public boolean match(String w, String s) {

		String[] wSplit = w.split("");
		String[] sSplit = s.split("");

		int pos = 0;
		while (pos < s.length() && pos < w.length()
				&& (("?").equals(wSplit[pos]) || (wSplit[pos]).equals(sSplit[pos]))) {
			pos++;
		}

		if (pos == w.length()) {
			return pos == s.length();
		}

		if (("*").equals(wSplit[pos])) {
			for (int skip = 0; pos + skip <= s.length(); skip++) {
				String subPattern = w.substring(pos + 1);
				String subWord = s.substring((pos + skip));
				if (this.match(subPattern, subWord)) {
					return true;
				}
			}
		}

		return false;
	}

	public int matchMemorized(int w, int s) {

		//cache 확인 후 반환 
		if (cache[w][s] != -1) {
			return cache[w][s];
		}
		//1:1매칭 확인 
		if (w < wChar.length && s < sChar.length) {
			if (wChar[w] == '?' || wChar[w] == sChar[s]) {
				return cache[w][s] = matchMemorized(w + 1, s + 1);
			}
		}
		// 패턴끝에 도달했을때 문자열도 끝났는지 확인 
		if (w == wChar.length) {
			return cache[w][s] = (s == sChar.length) ? 1 : 0;
		}

		// 별표일때 몇글자 대응할지 재귀호출 
		if (wChar[w] == '*') {
			if (matchMemorized(w + 1, s) == 1 || (s < sChar.length && matchMemorized(w, s + 1) == 1)) {
				return cache[w][s] = 1;
			}
		}
		return cache[w][s] = 0;
	}

	public void solve() {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < this.resultList.size(); i++) {
			for (int[] cacheArr : cache) {
				Arrays.fill(cacheArr, -1);
			}
			String word = this.resultList.get(i);
			this.sChar = word.toCharArray();

			if (matchMemorized(0, 0) == 1) {
				result.add(word);
			}
		}

		Collections.sort(this.resultList);
		for (String res : result) {
			System.out.println(res);
		}

	}

}
