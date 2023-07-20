package ploblem;

import java.util.*;

public class HashPractice {
	public static void main(String[] args) {
		Map<String, Integer> map= new HashMap<>();
		
		map.put("멜론", 10000);
		map.put("사과", 5000);
		map.put("배", 3000);
		map.put("수박", 10000);
		
		System.out.println("해쉬 출력 -> "+map);
		
		System.out.println("사과의 가격은? "+map.get("사과"));
		
		//예제
		
	}
}
