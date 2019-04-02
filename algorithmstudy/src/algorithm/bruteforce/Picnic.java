package algorithm.bruteforce;

public class Picnic {

	private int n;
	
	/**
	 * 친구 쌍 을저장
	 */
	private boolean[][] areFriends = new boolean[10][10];
	
	public Picnic() {
		this.n = 4;
		
		for(int i=0; i<this.areFriends.length; i++) {
			for(int j=0; j<this.areFriends[i].length; j++) {
				this.areFriends[i][j] = true;
			}
		}
		
	}
	
	public int countParings(boolean[] taken) {
		boolean finished = true;
		
		for(int i=0; i<n ;i++) {
			if(taken[i] == false) {
				finished = false;
			}
		}
		
		if(finished==true) {
			return 1;
		}
		
		int result = 0;
		for(int i=0; i< n; i++) {
			for(int j=0; j<n; j++) {
				if(areFriends[i][j] && !taken[i] && !taken[j]) {
					taken[i] = true;
					taken[j] = true;
					result += countParings(taken);
					taken[i] = false;
					taken[j] = false;
				}
			}
		}
		return result;
	}
	
}
