package ploblem;

public class passwordAnswer {
	public static void main(String[] args) {
		String s = "bcdefghijklmnopqrstuvwxyz";
		String skip = "a";
		int index = 1;
		String answer = "";

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			for (int j = 0; j < index; j++) {
				c += 1;
				if (c > 'z') {
					c -= 26;
				}
				if (skip.contains(String.valueOf(c))) {
					j--;
				}
			}
			answer += c;
		}

		System.out.println(answer);
	}
}
