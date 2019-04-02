package algorithm.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ6603 {

	private List<Integer> lotto = new ArrayList<Integer>();
	private int count = 0;

	public List<Integer> getLotto() {
		return lotto;
	}

	public void setLotto(List<Integer> lotto) {
		this.lotto = lotto;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BOJ6603() {

	}

	public void getLottoNumber(int size, Stack<Integer> picked, int toPick) {

		if (toPick == 0) {
			for (Integer integer : picked) {
				System.out.print(this.lotto.get(integer) + " ");
			}
			System.out.println();
			return;
		}

		int index = picked.isEmpty() ? 0 : picked.peek() + 1;

		for (int i = index; i < size; i++) {
			picked.push(i);
			this.getLottoNumber(size, picked, toPick - 1);
			picked.pop();
		}
	}

}
