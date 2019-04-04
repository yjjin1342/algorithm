package algorithm.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;
/**
 * boj1932
 */
public class TrianglePath {

	private int n;
	private int[][] triangle;
	private int[][] cache;
	
	public TrianglePath() {
		Scanner sc = new Scanner(System.in);
		this.n = sc.nextInt();
		this.triangle = new int[this.n][this.n];
		for(int i=0; i<this.n;i++) {
			int j=0;
			for(int k = j; k<=i; k++) {
				this.triangle[i][k] = sc.nextInt();
			}
		}
		this.solve();
		
		sc.close();
	}
	
	public int path1(int y, int x) {
		if(y== n-1) {
			return this.triangle[y][x];
		}
		int res = this.cache[y][x];
		if(res != -1) {
			return res;
		}
		
		
		
		return this.cache[y][x] = Math.max(this.path1(y+1, x), this.path1(y+1, x+1)) + this.triangle[y][x];
	}
	
	public void solve() {
		this.cache = new int[this.n][this.n];
		for (int[] arr: cache) {
			Arrays.fill(arr, -1);
		}
		
		int path1 = this.path1(0, 0);
		System.out.println(path1);
	}
	
}
