import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    private PrintStream printStream;
    private Board emptyBoard;
    private List<String> emptyLocations;
    private List<String> numberedLocations;
    private Board numberedBoard;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        emptyLocations = asList(" ", " ", " ", " ", " ", " ", " ", " ", " ");
        numberedLocations = asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        emptyBoard = new Board(printStream, emptyLocations);
        numberedBoard = new Board(printStream, numberedLocations);

    }

    @Test
    public void shouldDrawEmptyBoardWhenEmptyBoardIsGenerated() {
        emptyBoard.generate();
        verify(printStream).println(
                "  |   |  \n" +
                        "---------\n" +
                        "  |   |  \n" +
                        "---------\n" +
                        "  |   |  ");
    }

    @Test
    public void shouldUpdateBoardWhenMoveIsProvided() {
        emptyBoard.update("X", 2);
        assertEquals(emptyLocations.get(1), "X");
    }

    @Test
    public void shouldDrawNumbersInListWhenNumberedBoardIsGenerated() {
        numberedBoard.generate();
        verify(printStream).println(
                "1 | 2 | 3\n" +
                        "---------\n" +
                        "4 | 5 | 6\n" +
                        "---------\n" +
                        "7 | 8 | 9");
    }

    @Test
    public void shouldReturnFalseWhenLocationIsNotAvailable() {
        assertEquals(false, numberedBoard.locationIsAvailable(1));
    }

    @Test
    public void shouldReturnTrueWhenLocationIsAvailable() {
        assertEquals(true, emptyBoard.locationIsAvailable(1));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {
        assertFalse(emptyBoard.isFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        assertTrue(numberedBoard.isFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardHasWinnerOnDiagonal() {
        List<String> diagonal = asList(".", " ", " ", " ", ".", " ", " ", " ", ".");
        Board diagonalBoard = new Board(printStream, diagonal);
        assertTrue(diagonalBoard.hasWinner());
    }

    @Test
    public void shouldReturnTrueWhenBoardHasWinnerOnRow() {
        List<String> row = asList("", " ", "$", ".", ".", ".", " ", "$", " ");
        Board rowBoard = new Board(printStream, row);
        assertTrue(rowBoard.hasWinner());
    }

    @Test
    public void shouldReturnTrueWhenBoardHasWinnerOnColumn() {
        List<String> column = asList("$", " ", "$", ".", ".", ".", "$", " ", " ");
        Board columnBoard = new Board(printStream, column);
        assertTrue(columnBoard.hasWinner());
    }

    @Test
    public void shouldNotReturnTrueWhenBoardDoesNotHaveWinner() {
        List<String> noWin = asList(".", "$", ".", " ", "$", ".", " ", ".", " ");
        Board noWinBoard = new Board(printStream, noWin);
        assertFalse(noWinBoard.hasWinner());
    }
}
