package ploblem;

import java.util.Arrays;

class Solution1 {
	public int solution(int n, int m, int[] section) {
		boolean[] paintedSection = new boolean[n + 1];
		Arrays.fill(paintedSection, true);
		int answer = 0;

		for (int s : section) {
			paintedSection[s] = false;
		}

		for (int i = 1; i <= n / 2; i++) {
			if (!paintedSection[i]) {
				answer++;
				for (int j = i; j < i + m; j++)
					paintedSection[j] = true;
			}
			if (!paintedSection[n - i + 1]) {
				answer++;
				for (int j = n - i + 1; j > n - i + 1 - m; j--)
					paintedSection[j] = true;
			}
		}

		return answer;
	}

}

public class paintPrloble {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int n[] = { 2, 3, 6 };

		System.out.println(s.solution(8, 4, n));
	}
}
