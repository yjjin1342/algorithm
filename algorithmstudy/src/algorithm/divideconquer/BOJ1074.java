package algorithm.divideconquer;

import java.util.Scanner;

public 
class BOJ1074 {
	private int count=0;
	private int r = 0;
	private int c = 0;
	public BOJ1074() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		this.r = sc.nextInt();
		this.c = sc.nextInt();

		int size = 1;
		for (int i = 0; i < n; i++) {
			size = size * 2;
		}

		this.getVisitCount(size, 0, 0);
		
	}

	public void getVisitCount(int size, int r, int c) {

		if (size == 2) {
			if(r==this.r && c==this.c) {
				System.out.println(this.count++);
				return;
			}
				count++;
			if(r==this.r && c+1==this.c) {
				System.out.println(this.count++);
				return;
			}
			count++;
			if(r+1==this.r && c==this.c) {
				System.out.println(this.count++);
				return;
			}
			count++;
			if(r+1==this.r && c+1==this.c) {
				System.out.println(this.count++);
				return;
			}
			count++;
			return;
			
		} else {
			getVisitCount(size/2, r,c);
			getVisitCount(size/2, r, c+size/2);
			getVisitCount(size/2, r+size/2, c);
			getVisitCount(size/2, r+size/2, c+size/2);
		}

	}
}
