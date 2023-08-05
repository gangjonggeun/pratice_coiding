package ploblem;

import java.util.HashMap;
import java.util.Map;

public class HashProblem {

	public static void main(String[] args) {
		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };

		Map<String, Integer> map = new HashMap<>();

		// 등수를 해쉬에 저장
		for (int i = 0; i < players.length; i++)
			map.put(players[i], i);

		for (String c : callings) {
			// 등수 찾기
			int grade = map.get(c);

			// 앞선 플레이어 저장
			String fowardCalling = players[grade - 1];

			// 이전 등수를 현재 불린 선수로 변경 후 맵에 저장
			players[grade - 1] = c;
			map.put(c, grade);

			// 앞선 플레이러를 현재에 변경 후 맵에 저장
			players[grade] = fowardCalling;
			map.put(fowardCalling, grade);

		}

	}
}
