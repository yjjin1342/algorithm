package algorithm.bruteforce;

import java.util.Stack;

public class Recursion {

	/**
	 * 1부터 n까지의 합을 반
	 * 
	 * @param n 합을 구할 범위숫자
	 * @return 합반
	 */
	public int sum(int n) {
		int result = 0;

		for (int i = 1; i <= n; i++) {
			result += i;
		}
		return result;
	}

	/**
	 * 재귀함수로 구현
	 * 
	 * @param n 합을 구할 범위숫자
	 * @return 1부터 n까지의
	 */
	public int recursiveSum(int n) {

		if (n == 1) {
			return n;
		}

		return n + this.recursiveSum(n - 1);
	}

	/**
	 * 재귀함수를 사용해 0부터 n까지 범위에서 m개 원소를 구함
	 * 
	 * @param n      원소갯수 설정
	 * @param picked 이미선택된 원소
	 * @param toPick 골라야할 남은 숫자
	 */
	public void pick(int n, Stack<Integer> picked, int toPick) {
		if (toPick == 0) {
			this.printPicked(picked);
			return;
		}

		int smallest = picked.isEmpty() ? 0 : picked.peek() + 1;

		for (int i = smallest; i < n; i++) {
			picked.push(i);
			this.pick(n, picked, toPick - 1);
			picked.pop();
		}
	}

	private void printPicked(Stack<Integer> picked) {
		System.out.print("[");
		for (Integer pick : picked) {
			System.out.print(pick + " ");
		}
		System.out.println("]");
	}

}
