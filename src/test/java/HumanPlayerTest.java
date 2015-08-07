import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class HumanPlayerTest {
    private Player player;
    private Input input;
    private PrintStream printstream;

    @Before
    public void setup() {
        input = mock(Input.class);
        printstream = mock(PrintStream.class);
        player = new HumanPlayer(printstream, input, Turn.X);
        List<Integer> availableSpaces = new ArrayList<>();
        availableSpaces.add()
    }

    @Test
    public void shouldAskForInputWhenPlayerInputsANumber() {
        when(input.getInput()).thenReturn("1");
        player.makeAMove();
        verify(input).getInput();
    }

    @Test
      public void shouldAskForInputAgainWhenANumberIsNotEntered() {
        when(input.getInput()).thenReturn("Not a number.").thenReturn("1");

        player.makeAMove();
        verify(printstream).println("Invalid Input: enter a number 1-9.");
        verify(input, times(2)).getInput();
    }

    @Test
    public void shouldPrintLocationAlreadyTakenWhenCheckingEmptyOnOccupiedSpace() {
        when(input.getInput()).thenReturn("1").thenReturn("1").thenReturn("2");
        player.makeAMove();
        player.makeAMove();
        verify(printstream).println("Location already taken: enter an unoccupied space.");
    }

    @Test
    public void shouldAskForInputAgainWhenAnInvalidNumberIsEntered() {
        when(input.getInput()).thenReturn("10").thenReturn("1");

        player.makeAMove();
        verify(printstream).println("Invalid Input: enter a number 1-9.");
        verify(input, times(2)).getInput();
    }
}
