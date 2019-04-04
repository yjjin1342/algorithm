package algorithm.dynamicprogramming;

import java.util.LinkedList;
import java.util.Scanner;

public class Lis {

	private int n;
	private int[] cache;
	private int[] s;
	
	public Lis() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Integer> inputs = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			int nextInt = sc.nextInt();
			inputs.add(nextInt);
		}
		int lis = this.lis(inputs);
		System.out.println(lis);
	}
	
	public int lis(LinkedList<Integer> a) {
		if(a.isEmpty()) {
			return 0;
		}
		
		int res = 0;
		
		for(int i=0; i<a.size();i++) {
			LinkedList<Integer> b = new LinkedList<Integer>();
			for(int j=i+1; j<a.size(); j++) {
				if(a.get(i) < a.get(j)) {
					b.push(a.get(j));
				}
			}
			res = Math.max(res, 1 + this.lis(b));
		}
		return res;
	}
	
	public int lis2(int start) {
		int res = cache[start];
		if(res != -1) {
			return res;
		}
		
		res = 1;
		for(int next = start+1; next<this.n; next++) {
			if(s[start] < s[next]) {
				res = Math.max(res, lis2(next)+1);
			}
		}
		return res;
	}
}
