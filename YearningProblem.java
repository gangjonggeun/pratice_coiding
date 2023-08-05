package ploblem;

import java.util.*;

public class YearningProblem {
	public static void main(String[] args) {
		String[] name = { "may", "kein", "kain", "radi" };
		int[] yearning = { 5, 10, 1, 3 };
		String[][] photo = { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" },
				{ "kon", "kain", "may", "coni" } };

		int[] answer = {};
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < name.length; i++)
			map.put(name[i], yearning[i]);
		
		
		int sum =0;
		
		for (int i = 0; i < photo.length; i++) {
			for (String p : photo[i]) {
				if(map.containsKey(p)) {
					sum+=map.get(p);
				}
			}
			answer[i] = sum;
			sum =0;
		}

	}
}
