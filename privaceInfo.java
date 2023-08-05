package ploblem;

import java.util.*;
import java.util.stream.Stream;

public class privaceInfo {
	public int[] solution(String today, String[] terms, String[] privacies) {
		ArrayList<Integer> answerArrayList = new ArrayList<Integer>();

		int year = 0, month = 1, day = 2;

		Integer[] todayInteger = Stream.of(today.split("\\.")).mapToInt(Integer::parseInt).boxed()
				.toArray(Integer[]::new);
		int[] todayInt = Arrays.stream(todayInteger).mapToInt(i -> i).toArray();

		HashMap<String, Integer> termMap = new HashMap<String, Integer>();
		ArrayList<String> privaciesArray = new ArrayList<String>();

		for (String t : terms) {
			String[] termTemp = t.split(" ");
			termMap.put(termTemp[0], Integer.parseInt(termTemp[1]));
		}
		for (String p : privacies) {
			String[] temp = p.split(" ");
			privaciesArray.add(temp[0]);
			privaciesArray.add(temp[1]);
		}

		for (int i = 0; i < privaciesArray.size(); i += 2) {
			String t = privaciesArray.get(i);
			Integer[] privaciesInt = Stream.of(t.split("\\.")).mapToInt(Integer::parseInt).boxed()
					.toArray(Integer[]::new);
			Integer[] resultprivacies = privaciesInt;

			int addMonth = termMap.get(privaciesArray.get(i + 1));

			// 유효기간 더하기
			resultprivacies[year] += addMonth / 12;

			int m = resultprivacies[month] + (addMonth % 12);

			if (m > 12) {
				resultprivacies[year]++;
				resultprivacies[month] = m % 12;
			} else {
				resultprivacies[month] = m;
			}

			if (resultprivacies[day] - 1 == 0) {
				if (resultprivacies[month] - 1 == 0) {
					resultprivacies[year] -= 1;
					resultprivacies[month] = 12;
					resultprivacies[day] = 28;
				} else {
					resultprivacies[month] -= 1;
					resultprivacies[day] = 28;
				}
			} else {
				resultprivacies[day] -= 1;
			}

			if (todayInt[year] > resultprivacies[year]) {
				answerArrayList.add((i / 2) + 1);
			} else if (todayInt[year] == resultprivacies[year]) {
				if (todayInt[month] > resultprivacies[month]) {
					answerArrayList.add((i / 2) + 1);
				} else if (todayInt[month] == resultprivacies[month]) {
					if (todayInt[day] > resultprivacies[day]) {
						answerArrayList.add((i / 2) + 1);
					}
				}
			}

		}

		int[] answer = new int[answerArrayList.size()];

		int cnt = 0;
		for (int a : answerArrayList) {
			answer[cnt++] = a;
		}

		return answer;
	}

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = { "A 6", "B 12", "C 3", "D 12", "F 1" };
		String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C", "2022.12.01 D",
				"2022.12.01 D", "2022.01.01 D", "2022.01.02 D" };

		privaceInfo p = new privaceInfo();
		System.out.println(p.solution(today, terms, privacies));
	}
}