import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class PlayerTest {
    private Player player;
    private Input input;
    private PrintStream printStream;
    private Board board;
    private final static String DEFAULT_LOCATION = "1";
    private final static String INVALID_LOCATION = "10";

    @Before
    public void setup() {
        input = mock(Input.class);
        printStream = mock(PrintStream.class);
        board = mock(Board.class);
        player = new Player(printStream, input, Symbol.X, board);
    }

    @Test
    public void shouldScanForInputFromUserWhenMakingAMove() {
        when(input.scan()).thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(true);
        player.makeAMove();
        verify(input).scan();
    }

    @Test
    public void shouldPrintEnterALocationBetween1And9WhenMakingAMove() {
        when(input.scan()).thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(true);
        player.makeAMove();
        verify(printStream).println("Enter a location between 1 and 9: ");
    }

    @Test
    public void shouldRescanForInputWhenUserProvidesAnInvalidLocation() {
        when(input.scan()).thenReturn(INVALID_LOCATION).thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(true);
        player.makeAMove();
        verify(input, times(2)).scan();
    }

    @Test
    public void shouldCatchNumberFormatExceptionWhenUserDoesNotProvideAnInteger() {
        when(input.scan()).thenReturn("string").thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(true);
        player.makeAMove();
        verify(input, times(2)).scan();
    }

    @Test
    public void shouldMarkBoardWhenAMoveIsProvided() {
        when(input.scan()).thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(true);
        player.makeAMove();
        verify(board).update(anyString(), anyInt());
    }

    @Test
    public void shouldUpdateBoardWithPlayersSymbolWhenAMoveIsMade() {
        when(input.scan()).thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(true);
        Player player = new Player(printStream, input, Symbol.O, board);
        player.makeAMove();
        verify(board).update("O", 1);
    }

    @Test
    public void shouldPrintLocationAlreadyTakenWhenLocationIsAlreadyTaken() {
        when(input.scan()).thenReturn(DEFAULT_LOCATION).thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(false).thenReturn(true);
        player.makeAMove();
        verify(printStream).println("Location already taken.");
    }

    @Test
    public void shouldRescanUserInputWhenLocationIsAlreadyTaken() {
        when(input.scan()).thenReturn(DEFAULT_LOCATION).thenReturn(DEFAULT_LOCATION);
        when(board.locationIsAvailable(anyInt())).thenReturn(false).thenReturn(true);
        player.makeAMove();
        verify(input, times(2)).scan();
    }


}
