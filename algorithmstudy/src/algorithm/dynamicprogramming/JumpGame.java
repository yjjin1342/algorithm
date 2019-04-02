package algorithm.dynamicprogramming;

public class JumpGame {

	private int[][] board = new int[100][100];
	private int[][] cache = new int[100][100];
	private int n;

	boolean jump(int y, int x) {
		// board 밖으로 나간 경우
		if (x >= n || y >= n) {
			return false;
		}
		// 도착한 경우
		if (y == n - 1 && x == n - 1) {
			return true;
		}
		// 이동
		int jumpSize = board[y][x];
		return this.jump(y + jumpSize, x) || this.jump(y, x + jumpSize);
	}

	int dpJump(int y, int x) {
		// board 밖으로 나간 경우
		if (x >= n || y >= n) {
			return 0;
		}
		// 도착한 경우
		if (y == n - 1 && x == n - 1) {
			return 1;
		}

		int ret = cache[y][x];
		// 이동

		if (ret != -1) {
			return ret;
		}
		int jumpSize = board[y][x];

		if(this.dpJump(y + jumpSize, x)==0 && this.dpJump(y, x+jumpSize)==0) {
			return 0;
		}
		
		if((this.dpJump(y + jumpSize, x)!=0 || this.dpJump(y, x+jumpSize)!=0) && this.dpJump(y + jumpSize, x)==0) {
			ret = this.dpJump(y, x + jumpSize);
		}else {
			ret = this.dpJump(y+jumpSize, x);
		}
		return ret;
	}

}
