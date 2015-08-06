import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class TicTacToeTest {
    private TicTacToeApp app;
    private Board board;
    private Player player1, player2;
    private PrintStream printstream;

    @Before
    public void setup() {
        board = mock(Board.class);
        ArrayList<Player> players = new ArrayList<>();
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        players.add(player1);
        players.add(player2);
        printstream = mock(PrintStream.class);
        app = new TicTacToeApp(board, players, printstream);
    }

    @Test
    public void shouldGenerateBoardWhenApplicationStarts() {
        when(board.boardIsFull()).thenReturn(true);
        when(board.spaceIsEmpty(Matchers.<Pair<Turn, Integer>>anyObject())).thenReturn(true);
        app.start();
        verify(board, atLeastOnce()).generateBoard();
    }

    @Test
    public void shouldAskForPlayerToMakeAMoveWhenGameStarts() {
        when(board.boardIsFull()).thenReturn(true);
        when(board.spaceIsEmpty(Matchers.<Pair<Turn, Integer>>anyObject())).thenReturn(true);
        app.start();
        verify(player1, atLeastOnce()).makeAMove();
    }

    @Test
    public void shouldSwitchPlayerTurnsAfterEachMove() {
        when(board.boardIsFull()).thenReturn(false).thenReturn(true);
        when(board.spaceIsEmpty(Matchers.<Pair<Turn, Integer>>anyObject())).thenReturn(true).thenReturn(true);
        app.start();
        verify(player1, atLeastOnce()).makeAMove();
        verify(player2, atLeastOnce()).makeAMove();
    }

    @Test
    public void shouldPrintGameIsDrawWhenBoardIsFull() {
        when(board.boardIsFull()).thenReturn(true);
        when(board.spaceIsEmpty(Matchers.<Pair<Turn, Integer>>anyObject())).thenReturn(true);
        app.start();
        verify(printstream).println("Game is a draw.");
    }
}
