package ploblem;

public class deckOfCard {
	public String solution(String[] cards1, String[] cards2, String[] goal) {
		int point1 = 0, point2 = 0;

		for (int i = 0; i < goal.length; i++) {
			if(point1<cards1.length && goal[i].equals(cards1[point1]))
				point1++;
			else if(point2<cards2.length && goal[i].equals(cards2[point2]))
				point2++;
			else
				return "No";
		}

		return "Yes";
	}

	public static void main(String[] args) {
		String[] cards1 = { "i", "water", "drink" };
		String[] cards2 = { "want", "to" };
		String[] goal = { "i", "want", "to", "drink", "water" };

		deckOfCard d = new deckOfCard();

		System.out.println(d.solution(cards1, cards2, goal));

	}
}
