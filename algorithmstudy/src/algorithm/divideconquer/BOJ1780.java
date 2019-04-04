package algorithm.divideconquer;

import java.util.Scanner;

public class BOJ1780 {

	private int n;
	private int a;
	private int b;
	private int c;
	
	private int[][] paper;
	
	public BOJ1780() {
		Scanner sc = new Scanner(System.in);
		this.a=0;
		this.b=0;
		this.c=0;
		this.n= sc.nextInt();
		this.paper = new int[this.n][this.n];
		for(int i=0; i<this.paper.length; i++) {
			for(int j=0; j<this.paper[i].length; j++) {
				this.paper[i][j] = sc.nextInt();
			}
		}
		this.paperCount(0, 0, this.n);
		System.out.println(this.a);
		System.out.println(this.b);
		System.out.println(this.c);
		sc.close();
		
	}
	
	public void paperCount(int y, int x, int tri) {
		
		if(this.checkDividable(y, x, tri)==false) {
			this.countPaper(y, x);
			return;
		}
		int div = tri/3;
		
		this.paperCount(y, x, div);
		this.paperCount(y, x+div, div);
		this.paperCount(y, x+(div*2), div);

		this.paperCount(y+div, x, div);
		this.paperCount(y+div, x+div, div);
		this.paperCount(y+div, x+(div*2), div);
		
		this.paperCount(y+(div*2), x, div);
		this.paperCount(y+(div*2), x+div, div);
		this.paperCount(y+(div*2), x+(div*2), div);
	}

	private boolean checkDividable(int y, int x, int tri) {
		for(int i=y; i<y+tri; i++) {
			for(int j=x; j<x+tri; j++) {
				if(this.paper[y][x] != this.paper[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

	private void countPaper(int y, int x) {
		if(this.paper[y][x]== -1) {
			a++;
		}else if(this.paper[y][x]==0) {
			b++;
		}else if(this.paper[y][x]==1) {
			c++;
		}
	}
	
}
