package algorithm.bruteforce;

public class BOJ1748 {

	public void getResult(int number) {
		int length = String.valueOf(number).length();
		int rule = 9;
		int result = 0;
		for (int i = 1; i < length; i++) {
			result += i * rule;
			rule *= 10;
		}
		result += (number - Math.pow(10.0, Double.parseDouble(String.valueOf(length - 1))) + 1) * length;

		System.out.println(result);
	}
}
