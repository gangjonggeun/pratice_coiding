package ploblem;

public class greedAlgorthm {
	public static void main(String[] args) {
		 int answer = 0;
	        int n= 8;
	        int m =4;
		 	int section[] = { 2, 3, 6 };

		 
	        int start = section[0];
	        answer++;
	        
	        for (int item : section) {
	            if (start+m > item) {
	            	//System.out.println(start+m+" "+item);
	                continue;
	            }
	            System.out.println(item);
	            start = item;
	            answer++;
	        }
	        
	       System.out.println(answer);
	}
}
