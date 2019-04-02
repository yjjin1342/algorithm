package algorithm.bruteforce;

import java.util.Scanner;
import java.util.Stack;

public class TravelingSalesmanProblem {

	/**
	 * 도시 수  
	 */
	private int n;
	
	private int[][] distance; 
	
	public TravelingSalesmanProblem() {
		Scanner sc = new Scanner(System.in);
		this.n = sc.nextInt();
		this.distance = new int[n][n];
		for(int i=0; i< this.distance.length; i++) {
			for(int j=0; j< this.distance[i].length; j++) {
				int nextInt = sc.nextInt();
				this.distance[i][j] = nextInt;
			}
			
		}
	}
	
	public int shortestPath(Stack<Integer> path, boolean[] visited, int currentLength) {
		
		if(path.size()==n) {
			int x = currentLength + this.distance[path.peek()][path.firstElement()];
			return x;
		}
		
		int result = 9999;
		
		for(int i=0; i<n; i++) {
			int here = path.isEmpty()?0:path.peek();
			if(this.distance[here][i]==0) {
				continue;
			}
			
			if(visited[i]) {
				continue;
			}
			path.push(i);
			visited[i] = true;
			
			int cand = this.shortestPath(path, visited, currentLength + this.distance[here][i]);
			
			result = Math.min(result, cand);
			visited[i] = false;
			path.pop();
		}
		
		return result;
	}
	
}
