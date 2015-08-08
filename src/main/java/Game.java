import java.io.PrintStream;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private PrintStream printStream;
    private int currentPlayer;

    public Game(Board board, List<Player> players, PrintStream printstream) {
        this.board = board;
        this.players = players;
        this.printStream = printstream;
        this.currentPlayer = 0;
    }

    private void switchPlayer() {
        switch (currentPlayer) {
            case 0:
                currentPlayer = 1;
                return;
            case 1:
                currentPlayer = 0;
                return;
            default:
                return;
        }
    }

    public void start() {
        boolean gameInPlay = true;
        while (gameInPlay) {
            board.generate();
            players.get(currentPlayer).makeAMove();
            switchPlayer();
            if (board.isFull()) {
                board.generate();
                printStream.println("Game is a draw.");
                gameInPlay = false;
            }
        }
    }
}
