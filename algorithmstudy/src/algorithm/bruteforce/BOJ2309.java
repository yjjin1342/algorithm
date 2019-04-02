package algorithm.bruteforce;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ2309 {

	private final List<Integer> heightList = new ArrayList<Integer>();

	private final List<Integer> result = new ArrayList<Integer>();
	
	public BOJ2309() {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			int height = sc.nextInt();
			this.heightList.add(height);
		}

	}

	public void findDwarf(Stack<Integer> pickedIndex, int toPick) {
		if(toPick == 0) {
			if(this.validateDwarfs(pickedIndex)) {
				for (Integer integer : pickedIndex) {
					this.result.add(this.heightList.get(integer));
				}

				this.result.sort(new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					};
				});
				
				for (Integer integer : this.result) {
					System.out.println(integer);
				}
				
			}
			return;
		}
		
		int dwarfIndex = pickedIndex.isEmpty()? 0 : pickedIndex.peek()+1;
		for(int i = dwarfIndex; i<9; i++) {
			
			pickedIndex.push(i);
			this.findDwarf(pickedIndex, toPick-1);
			pickedIndex.pop();
		}
	}
	
	private boolean validateDwarfs(Stack<Integer> picked) {
		int sum = 0;
		
		for (Integer pick : picked) {
			sum += this.heightList.get(pick);
		}
		
		if(sum==100) {
			return true;
		}
		return false;
	}
	
}
