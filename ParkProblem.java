package ploblem;

import java.util.*;

class Solution {
	public int[] solution(String[] park, String[] routes) {
		int[] answer = new int[2];

		String[] direction = new String[routes.length];
		int[] distance = new int[routes.length];
		int startX = 0, startY = 0;

		for (int i = 0; i < routes.length; i++) {
			String[] splitString = routes[i].split(" ");

			direction[i] = splitString[0];
			distance[i] = Integer.parseInt(splitString[1]);
		}

		char[][] parkChar = new char[park.length][park[0].length()];

		// park 2차원 배열로 옮기기
		for (int i = 0; i < park.length; i++) {
			for (int j = 0; j < park[0].length(); j++) {
				parkChar[i][j] = park[i].charAt(j);

				if (parkChar[i][j] == 'S') {
					startX = i;
					startY = j;
				}
			}
		}
		// 현재 위치
		int x = startX, y = startY;
		int answerX = startX, answerY = startY;
		int sumX = 0, sumY = 0;

		for (int i = 0; i < direction.length; i++) {

			System.out.println("현재 위치 " + x + " " + y);
			for (int j = 0; j < distance[i]; j++) {
				try {
					// 남
					if (direction[i].equals("S")) {
						if ((x + distance[i]-sumX >= park.length) || (parkChar[x + 1][y] == 'X')) {
							x -= sumX;
							sumX = 0;
							break;
						} else {
							x += 1;
							sumX += 1;
						}
					}
					// 북
					if (direction[i].equals("N")) {
						if ((x - distance[i]-sumX < 0) || (parkChar[x - 1][y] == 'X')) {
							x -= sumX;
							sumX = 0;
							break;
						} else {
							x -= 1;
							sumX -= 1;
						}
					}
					// 동
					if (direction[i].equals("E")) {
						if ((y + distance[i]-sumY >= park[0].length()) || (parkChar[x][y + 1] == 'X')) {
							y-=sumY;
							sumY = 0;
							break;
						} else {
							y+=1;
							sumY += 1;
						}
					}
					// 서
					if (direction[i].equals("W")) {
						if ((y - distance[i]-sumY < 0) || (parkChar[x][y - 1] == 'X')) {
							y-=sumY;
							sumY = 0;
							break;
						} else {
							y-=1;
							sumY -= 1;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					break;
				}

			}

			answerX=x;
			answerY=y;

			sumX = 0;
			sumY = 0;

		}
		answer[0] = answerX;
		answer[1] = answerY;

		return answer;
	}
}

public class ParkProblem {

	public static void main(String[] args) {
		String[] park = { "SOO","OOO","OOO" };
		String[] routes = { "E 2","S 2","W 1"};

		Solution s = new Solution();
		int[] answer = s.solution(park, routes);

		for (int i = 0; i < answer.length; i++)
			System.out.println(answer[i]);
	}
}
