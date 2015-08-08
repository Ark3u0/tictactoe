import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class GameTest {
    private Board board;
    private Player player1;
    private Player player2;
    private Game game;
    private PrintStream printStream;

    @Before
    public void setup() {
        board = mock(Board.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        printStream = mock(PrintStream.class);
        game = new Game(board, asList(player1, player2), printStream);
    }

    @Test
    public void shouldDrawBoardWhenRunningATurn() {
        game.runTurn();
        verify(board).generate();
    }

    @Test
    public void shouldPromptPlayerToMakeAMoveWhenRunningATurn() {
        game.runTurn();
        verify(player1).makeAMove();
    }

    @Test
    public void shouldSecondPlayerShouldMakeAMoveAfterFirstPlayersMove() {
        game.runTurn();
        game.runTurn();
        verify(player2).makeAMove();
    }

    @Test
    public void shouldCheckIfBoardIsFullWhenRunningATurn() {
        game.runTurn();
        verify(board).isFull();
    }

    @Test
    public void shouldPrintGameIsDrawWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);
        game.runTurn();
        verify(printStream).println("Game is a draw.");
    }

    @Test
    public void shouldNotPrintGameIsDrawWhenBoardIsNotFull() {
        when(board.isFull()).thenReturn(false);
        game.runTurn();
        verify(printStream, never()).println("Game is a draw.");
    }

    @Test
    public void shouldCheckIfGameHasWinnerWhenRunningATurn() {
        game.runTurn();
        verify(board).hasWinner();
    }

    @Test
    public void shouldPrintPlayerOneWinsWhenPlayerOneWins() {
        when(board.hasWinner()).thenReturn(true);
        game.runTurn();
        verify(printStream).println("Player 1 Wins!");
    }

    @Test
    public void shouldNotPrintPlayerOneWinsWhenPlayerOneHasNotWon() {
        when(board.hasWinner()).thenReturn(false);
        game.runTurn();
        verify(printStream, never()).println("Player 1 Wins!");
    }
}
