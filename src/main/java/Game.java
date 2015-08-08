import java.io.PrintStream;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private PrintStream printStream;
    private int currentPlayer;
    private boolean gameInPlay;

    public Game(Board board, List<Player> players, PrintStream printstream) {
        this.board = board;
        this.players = players;
        this.printStream = printstream;
        this.currentPlayer = 0;
        this.gameInPlay = true;
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
        while (gameInPlay) {
            runTurn();
        }
    }

    public void runTurn() {
        board.generate();
        players.get(currentPlayer).makeAMove();
        if (board.hasWinner()) {
            board.generate();
            printStream.println("Player " + (currentPlayer + 1) + " Wins!");
            gameInPlay = false;
            return;
        }
        if (board.isFull()) {
            board.generate();
            printStream.println("Game is a draw.");
            gameInPlay = false;
            return;
        }
        switchPlayer();
    }
}
