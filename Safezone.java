package ploblem;

public class Safezone {
	   public int solution(int[][] board) {
	        int answer = 0;
	        int[][] danger = new int[board.length][board.length]; // 0안전 1 위험
	            
	        for(int i=0; i < board.length; i++){
	            for(int j=0; j < board[0].length; j++){
	                if(board[i][j] == 1){
	                    danger[i][j] = 1;
	                    //좌우
	                    if(j != 0)
	                        danger[i][j-1] = 1;
	                    if(j != board[0].length-1)
	                        danger[i][j+1] = 1;
	                    //상하
	                    if(i != 0)
	                        danger[i-1][j] = 1;
	                    if(i != board[0].length-1)
	                        danger[i+1][j] = 1;
	                    //대각선
	                    if((i != 0) & (j != 0))
	                        danger[i-1][j-1] = 1;
	                    if((i != 0)&(j != board[0].length-1))
	                        danger[i-1][j+1] = 1;
	                    if((i != board[0].length-1)&(j != 0))
	                        danger[i+1][j-1] = 1;
	                    if((i != board[0].length-1)&(j != board[0].length-1))
	                        danger[i+1][j+1] = 1;
	                }
	            }
	        }
	        
	        for(int i = 0; i<danger.length; i++){
	            for(int j =0; j<danger[0].length; j++){
	                if(danger[i][j] == 0)
	                    answer++;
	            }
	        }
	        
	        return answer;
	    }
}
