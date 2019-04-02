package algorithm.bruteforce;

public class BOJ1165 {

	private int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
	private int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

	private String[][] board = new String[5][5];

	public BOJ1165(String[][] board) {
		super();
		this.board = board;
	}

	public boolean hasWord(int x, int y, String word) {

		if (inRange(x, y) == false) {
			return false;
		}

		if (word.startsWith(board[x][y]) == false) {
			return false;
		}

		if (word.length() == 1) {
			return true;
		}

		for (int direction = 0; direction < 8; direction++) {
			int nextX = x+dx[direction];
			int nextY = y+dy[direction];
			
			if(this.hasWord(nextX, nextY, word.substring(1))==true) {
				return true;
			}
		}
		return false;
	}

	/**
	 * x,y가 해당 범위에 존재하는지 여부 판단
	 * 
	 * @param x x좌표 값
	 * @param y y좌표 값
	 * @return 판단여부
	 */
	private boolean inRange(int x, int y) {
		if (x < 0 || x > 4) {
			return false;
		}
		if (y < 0 || y > 4) {
			return false;
		}
		return true;
	}
}
