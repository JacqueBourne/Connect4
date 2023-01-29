package game;
import java.util.Random;
public class AIPlayer extends Player{
    private int moveTime=0;
    private final int NUM_OF_COLUMNS=board.getColumn();
    private final int NUM_OF_ROW=board.getRow();
    private char opponent=' ';

    public AIPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    private boolean win(Board board){
        for (int column=0; column<NUM_OF_COLUMNS; column++){
            int row=board.availableMove(column);
            if (row==-1) continue;
            board.moveOnBoard(row, column, symbol);
            if (board.containsWin()==true) return true;
            board.moveOnBoard(row, column, ' ');
        }
        return false;
    }

    private boolean Block(char opponent,Board board){
        for (int column=0; column<NUM_OF_COLUMNS; column++){
            int row=board.availableMove(column);
            if (row==-1) continue;
            board.moveOnBoard(row, column, opponent);
            if (board.containsWin()==true){
                board.moveOnBoard(row, column, symbol);
                return true;
            }
            board.moveOnBoard(row, column, ' ');;
        }
        return false;
    }

    @Override
    public void makeMove(Board board) {
        boolean winnable=false;
        boolean needBlock=false;
        if (moveTime==2){
            for (int row=NUM_OF_ROW-1; row>-1; row--){
                for (int column=0; column<NUM_OF_COLUMNS; column++){
                    if (board.getItem(row, column).equals((""+this.symbol))==false){
                        if (board.getItem(row, column).equals(" ")==false){
                            opponent=board.getItem(row, column).charAt(0);
                            break;
                        }
                    }
                }
            }
        }
        
        if (moveTime>=2){
            winnable=this.win(board);
            if (winnable==false){
                needBlock=this.Block(opponent, board);
            }
        }

        if ((winnable==false) && (needBlock==false)){
            int row=-1;
            int column=-1;
            Random rand = new Random();
            while(row==-1){
                column=rand.nextInt(NUM_OF_COLUMNS);
                row=board.availableMove(column);
            }
            board.moveOnBoard(row, column, symbol);
        }
        moveTime++;
    }
}
