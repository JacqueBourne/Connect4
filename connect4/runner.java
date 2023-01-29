import game.*;
public class runner {
    public static void main(String[] arg){
        Board b= new Board();
        ConnectFour c4= new ConnectFour(b);
        HumanPlayer p1= new HumanPlayer('0', b,"Peter");
        AIPlayer ai= new AIPlayer('1', b, "AI");
        c4.setPlayer1(p1);
        c4.setPlayer2(ai);
        c4.playGame();
    }
}
