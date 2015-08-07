import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    private PrintStream printstream;
    private Board board;

    @Before
    public void setup() {
        printstream = mock(PrintStream.class);
        board = new Board(printstream);
    }

    @Test
    public void shouldDrawEmptyBoardWhenGenerateBoardIsCalled() {
        board.generateBoard();

        verify(printstream).print("  |   |  \n" + "---------\n" + "  |   |  \n" + "---------\n" + "  |   |  \n");
    }

    @Test
    public void shouldUpdateBoardWhenMoveIsProvided() {
        board.updateBoard(new Pair<>(Turn.X, 2));
        board.generateBoard();

        verify(printstream).print("  | X |  \n" + "---------\n" + "  |   |  \n" + "---------\n" + "  |   |  \n");
    }

    @Test
    public void shouldDrawCorrectXInGridSpaceFiveWhenGenerateColumnsIsCalledAfterUpdateBoardWithMoveFive() {
        board.updateBoard(new Pair<>(Turn.X, 5));
        board.generateBoard();

        verify(printstream).print("  |   |  \n" + "---------\n" + "  | X |  \n" + "---------\n" + "  |   |  \n");
    }

    @Test
    public void shouldDrawRowsIndependentlyWhenGenerateColumnsIsCalledAfterUpdateBoardIsCalledTwiceInDifferentRows() {
        board.updateBoard(new Pair<>(Turn.X, 5));
        board.updateBoard(new Pair<>(Turn.X, 1));
        board.generateBoard();

        verify(printstream).print(
                "X |   |  \n" +
                        "---------\n" +
                        "  | X |  \n" +
                        "---------\n" +
                        "  |   |  \n");
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {
        board.updateBoard(new Pair<>(Turn.X, 5));
        assertEquals(false, board.boardIsFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        board.updateBoard(new Pair<>(Turn.X, 1));
        board.updateBoard(new Pair<>(Turn.X, 2));
        board.updateBoard(new Pair<>(Turn.X, 3));
        board.updateBoard(new Pair<>(Turn.X, 4));
        board.updateBoard(new Pair<>(Turn.X, 5));
        board.updateBoard(new Pair<>(Turn.X, 6));
        board.updateBoard(new Pair<>(Turn.X, 7));
        board.updateBoard(new Pair<>(Turn.X, 8));
        board.updateBoard(new Pair<>(Turn.X, 9));
        assertEquals(true, board.boardIsFull());
    }

    @Test
     public void shouldReturnTrueWhenThereIsARowWinCondition() {
        board.updateBoard(new Pair<>(Turn.X, 1));
        board.updateBoard(new Pair<>(Turn.X, 2));
        board.updateBoard(new Pair<>(Turn.X, 3));
        assertEquals(true, board.isThereAWinner());
    }

    @Test
    public void shouldReturnTrueWhenThereIsADiagonalWinCondition() {
        board.updateBoard(new Pair<>(Turn.X, 1));
        board.updateBoard(new Pair<>(Turn.X, 5));
        board.updateBoard(new Pair<>(Turn.X, 9));
        assertEquals(true, board.isThereAWinner());
    }

    @Test
    public void shouldReturnTrueWhenThereIsAColumnWinCondition() {
        board.updateBoard(new Pair<>(Turn.X, 1));
        board.updateBoard(new Pair<>(Turn.X, 4));
        board.updateBoard(new Pair<>(Turn.X, 7));
        assertEquals(true, board.isThereAWinner());
    }

    @Test
    public void shouldReturnSpacesFiveThroughNineWhenCheckingForAvailableSpaces() {
        board.updateBoard(new Pair<>(Turn.X, 1));
        board.updateBoard(new Pair<>(Turn.X, 2));
        board.updateBoard(new Pair<>(Turn.X, 3));
        board.updateBoard(new Pair<>(Turn.X, 4));
        List<Integer> availableSpaces = board.availableSpaces();
        assert(availableSpaces.contains(5));
        assert(availableSpaces.contains(6));
        assert(availableSpaces.contains(7));
        assert(availableSpaces.contains(8));
        assert(availableSpaces.contains(9));
    }

    @Test
    public void shouldReturnTrueWhenThereIsAWinConditionOnTheBoard() {
        board.updateBoard(new Pair<>(Turn.X, 1));
        board.updateBoard(new Pair<>(Turn.X, 6));
        board.updateBoard(new Pair<>(Turn.X, 8));
        assertEquals(false, board.isThereAWinner());
    }
}
