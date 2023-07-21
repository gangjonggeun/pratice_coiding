package hash_practice;

import java.util.*;

// 2개의 원소의 합이 target 값이 되는 원소 찾기

public class hash1 {

	// 주먹 구구 방식으로 풀이
	public static void findPair(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i; j < nums.length; j++) {
				if ((nums[i] + nums[j]) == target) {
					System.out.println("Pair Found (" + nums[i] + ", " + nums[j] + ")");

					if (!((i == nums.length - 2) & (j == nums.length - 1)))
						System.out.println("or");

				}
			}
		}
	}

	// 해쉬
	public static void hash_findPair(int[] nums, int target) {
		// 빈 HashMap 생성
		Map<Integer, Integer> map = new HashMap<>();

		// 각 요소에 대해 수행
		for (int i = 0; i < nums.length; i++) {
			// 쌍(nums[i], target-nums[i])이 존재하는지 확인

			System.out.println(map.keySet());
			// target 값 - nums 값 이 존재하는지 확인
			if (map.containsKey(target - nums[i])) {
				System.out.printf("Pair found (%d, %d)", nums[map.get(target - nums[i])], nums[i]);
				System.out.println();
			}
				
			// 맵에 현재 요소의 인덱스 저장
			map.put(nums[i], i);
		}

		// 쌍을 찾지 못하면 여기에 도달합니다.
		//System.out.println("Pair not found");

	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 4, 7, 6, 8, 5, 9, 11 };
		int target = 10;

		hash_findPair(nums, target);

	}
}
