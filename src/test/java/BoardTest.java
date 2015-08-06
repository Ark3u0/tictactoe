import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    @Test public void shouldDrawColumnLinesWhenGenerateColumnsIsCalled() {
        PrintStream printstream = mock(PrintStream.class);
        Board board = new Board(printstream);

        board.generateColumns();

        verify(printstream).println("  |   |   ");
    }

    @Test public void shouldDrawRowLinesWhenGenerateColumnsIsCalled() {
        PrintStream printstream = mock(PrintStream.class);
        Board board = new Board(printstream);

        board.generateRows();

        verify(printstream).println("---------");
    }
}
