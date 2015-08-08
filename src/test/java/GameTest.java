import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.PrintStream;
import java.util.ArrayList;

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
    public void shouldDrawBoardWhenGameStarts() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(board).generate();
    }

    @Test
    public void shouldPromptPlayerToMakeAMoveWhenGameStarts() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(player1).makeAMove();
    }

    @Test
    public void shouldPromptSecondPlayerToMakeAMoveWhenGameStarts() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        game.start();
        verify(player2).makeAMove();
    }

    @Test
    public void shouldRequireBothPlayerOneToMakeMultipleMovesWhenTheGameStarts() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(true);
        game.start();
        verify(player1, atLeast(3)).makeAMove();
    }

    @Test
    public void shouldRequireBothPlayerTwoToMakeMultipleMovesWhenTheGameStarts() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(true);
        game.start();
        verify(player2, atLeast(3)).makeAMove();
    }

    @Test
    public void shouldPrintGameIsDrawWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(printStream).println("Game is a draw.");
    }
}
