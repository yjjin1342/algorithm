package algorithm.divideconquer;

import java.util.Scanner;

public class BOJ1992 {

	private int arrSize;
	private int[][] image;

	public int getArrSize() {
		return arrSize;
	}

	public void setArrSize(int arrSize) {
		this.arrSize = arrSize;
	}

	public int[][] getImage() {
		return image;
	}

	public void setImage(int[][] image) {
		this.image = image;
	}

	public BOJ1992() {
		Scanner sc = new Scanner(System.in);
		this.arrSize = sc.nextInt();
		this.image = new int[this.arrSize][this.arrSize];

		for (int i = 0; i < this.image.length; i++) {
			String next = sc.next();
			String[] split = next.split("");

			for (int j = 0; j < this.image[i].length; j++) {
				this.image[i][j] = Integer.parseInt(split[j]);
			}
		}

		sc.close();
	}

	public void compress(int x, int y, int size) {

		if (isDevidable(x, y, size) == false) {
			System.out.print(this.image[x][y]);
			return;
		} else {
			int half = size / 2;
			System.out.print("(");
			this.compress(x, y, half);
			this.compress(x, y + half, half);
			this.compress(x + half, y, half);
			this.compress(x + half, y + half, half);
			System.out.print(")");
		}
	}

	private boolean isDevidable(int x, int y, int size) {
		int base = this.image[x][y];
		boolean isDevidable = false;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (base != this.image[i][j]) {
					isDevidable = true;
					break;
				}
			}
		}
		return isDevidable;
	}

}
