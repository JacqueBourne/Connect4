package game;
import java.util.Scanner;
public class HumanPlayer extends Player{

    public HumanPlayer(char symbol, Board board, String name) {
        super(symbol, board, name);
    }

    private Scanner  playerMove =new Scanner((System.in));

    @Override
    public void makeMove(Board board){
        System.out.println(name+", please input your move:");
        while (true){
            int move=playerMove.nextInt()-1;
            int row=board.availableMove(move);
            if (row!=-1){
                board.moveOnBoard(row, move, symbol);
                break;
            }
            System.out.println("This board is full, please make a valid move.");
        }
    }
}
