package game;
public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private String[][] board = new String[NUM_OF_ROW][NUM_OF_COLUMNS];
	
	public Board() {
		for(int row=0; row<NUM_OF_ROW;row++){
			for(int column=0; column<NUM_OF_COLUMNS; column++){
				board[row][column]=" ";
			}
		}
	}
	
	public void printBoard() {
		for (int row=0; row<NUM_OF_ROW; row++){
			System.out.print("|");
			for (int column=0; column<NUM_OF_COLUMNS; column++){
				System.out.print(board[row][column]);
				System.out.print("|");
			}
			System.out.println("");
		}
	}
	
	public boolean containsWin() {
		for (int row=0; row<NUM_OF_ROW; row++){
			for (int column=0; column<(NUM_OF_COLUMNS-3); column++){
				if (board[row][column].equals(board[row][column+1])&& board[row][column].equals(board[row][column+2])&& board[row][column].equals(board[row][column+3])&& board[row][column].equals(" ")==false) return true;
			}
		}
	
		for (int row=0; row<NUM_OF_ROW-3; row++){
			for (int column=0; column<(NUM_OF_COLUMNS); column++){
				if(board[row][column].equals(" ")==false){
					if (board[row][column].equals(board[row+1][column])){
						if(board[row][column].equals(board[row+2][column])){
							if ( board[row][column].equals(board[row+3][column])) return true;
						}
					}
				}
			}
		}
	
		for (int row=0; row<NUM_OF_ROW-3; row++){
			for (int column=0; column<(NUM_OF_COLUMNS-3); column++){
				if (board[row][column].equals(board[row+1][column+1])&& board[row][column].equals(board[row+2][column+2])&& board[row][column].equals(board[row+3][column+3])&& board[row][column].equals(" ")==false) return true;
			}
		}

		for (int row=0; row<NUM_OF_ROW-3; row++){
			for (int column=3; column<(NUM_OF_COLUMNS); column++){
				if (board[row][column].equals(board[row+1][column-1])&& board[row][column].equals(board[row+2][column-2])&& board[row][column].equals(board[row+3][column-3])&& board[row][column].equals(" ")==false) return true;
			}
		}

		return false;
	}
	
	public boolean isTie() {
		for(int row=0; row<NUM_OF_ROW;row++){
			for(int column=0; column<NUM_OF_COLUMNS; column++){
				if (board[row][column].equals(" ")) return false;
			}
		}		
		return true;
	}
	
	public void reset() {
		for(int row=0; row<NUM_OF_ROW;row++){
			for(int column=0; column<NUM_OF_COLUMNS; column++){
				board[row][column]=" ";
			}
		}
	}
	
	public int availableMove(int column){
		for (int i=NUM_OF_ROW-1;i>-1;i--){
			if (board[i][column].equals(" ")) return i;
		}
		return -1;
	}

	public int getColumn(){
		return this.NUM_OF_COLUMNS;
	}
	public int getRow(){
		return this.NUM_OF_ROW;
	}

	public void moveOnBoard(int row,int column, char symbol){
		this.board[row][column]=symbol+"";
	}

	public String getItem(int row, int column){
		return this.board[row][column];
	}
}

