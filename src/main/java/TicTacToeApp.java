import javafx.util.Pair;

import java.io.PrintStream;
import java.util.List;

public class TicTacToeApp {
    private List<Player> players;
    private int playerTurn = 0;
    private boolean gameInPlay = true;
    private Board board;
    private PrintStream printstream;

    public TicTacToeApp(Board board, List<Player> players, PrintStream printstream) {
        this.board = board;
        this.players = players;
        this.printstream = printstream;
    }


    private void switchTurn() {
        if (playerTurn == 0) {
            playerTurn = 1;
        } else {
            playerTurn = 0;
        }
    }

    public void start() {
        board.generateBoard();
        while (gameInPlay) {
            Pair<Turn, Integer> playerMove = players.get(playerTurn).makeAMove();
            board.updateBoard(playerMove);
            board.generateBoard();
            if (board.isThereAWinner()) {
                gameInPlay = false;
                printstream.println("Player " + (playerTurn + 1) + " Wins!");
            }
            if (board.boardIsFull()) {
                gameInPlay = false;
                printstream.println("Game is a draw.");
            }
            switchTurn();
        }

    }
}
