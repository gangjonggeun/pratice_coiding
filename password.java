package ploblem;

public class password {
	public String solution(String s, String skip, int index) {
		char[] sChar = new char[s.length()];
		char[] skipChar = new char[skip.length()];

		for (int i = 0; i < s.length(); i++)
			sChar[i] = s.charAt(i);
		for (int j = 0; j < skip.length(); j++)
			skipChar[j] = skip.charAt(j);

		int addIndex = index;

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < skip.length(); j++) {
				if (sChar[i] < skipChar[j] && skipChar[j] <= sChar[i] + addIndex) {
					addIndex++;
				}
			}
			if (sChar[i] + addIndex > 'z') {
				addIndex = (addIndex - ('z' - sChar[i]));
				sChar[i] = 96;
				i -= 1;
				continue;
			} else
				sChar[i] += addIndex;
			addIndex = index;
		}

		return String.valueOf(sChar);
	}

	public static void main(String[] args) {
		String s = "ybc";
		String skip = "c";
		int index = 0;

		password p = new password();
		System.out.println(s);
		System.out.println(p.solution(s, skip, index));
	}
}
