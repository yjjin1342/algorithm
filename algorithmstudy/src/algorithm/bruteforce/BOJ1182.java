package algorithm.bruteforce;

import java.util.Scanner;

public 
class BOJ1182 {

	private int[] numbers;
	private int[] flags;
	private int arrCount;
	private int sum;
	private int count = 0;

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	public int[] getFlags() {
		return flags;
	}

	public void setFlags(int[] flags) {
		this.flags = flags;
	}

	public int getArrCount() {
		return arrCount;
	}

	public void setArrCount(int arrCount) {
		this.arrCount = arrCount;
	}

	public int getCount() {
		return count;
	}

	public BOJ1182() {
		Scanner sc = new Scanner(System.in);

		this.arrCount = sc.nextInt();
		this.flags = new int[arrCount];
		this.numbers = new int[arrCount];
		this.sum = sc.nextInt();

		for (int i = 0; i < arrCount; i++) {
			int nextInt = sc.nextInt();
			this.numbers[i] = nextInt;
		}
	}

	public void powerSet(int n, int depth, int sum) {

		if (depth == n) {
			int checkValue = 0;
			for (int i = 0; i < n; i++) {
				if (this.flags[i] == 1) {
					checkValue += this.numbers[i];
				}
			}
			if(checkValue == sum) {
				this.count += 1;
			}
			
			return;
		}

		flags[depth] = 1;
		this.powerSet(n, depth + 1, sum);
		flags[depth] = 0;
		this.powerSet(n, depth + 1, sum);
	}
}
