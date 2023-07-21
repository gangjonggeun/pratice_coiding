package hash_practice;

import java.util.*;

public class hash2 {
	public static void hasZeroSumSubarray(int[] nums) {
		Set<Integer> set = new HashSet<>();

		int sum = 0;
		set.add(0);
		for(int n : nums) {
			
			
			sum += n;
			System.out.println("sum 값"+sum);
			
			if(set.contains(sum)) {
			//	System.out.println("합이 0일때");
			}
			
			set.add(sum);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };

		hasZeroSumSubarray(nums);
	}
}
