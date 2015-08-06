import org.junit.Test;

import static org.mockito.Mockito.*;

public class PlayerTest {
    @Test
    public void shouldAskForInputWhenPlayerMakesAMove() {
        Input input = mock(Input.class);
        Player player = new Player();

        player.makeAMove();

        verify(input, times(1)).getInput();
    }

    @Test
    public void shouldAskForInputAgainWhenInvalidInputIsEntered() {
        Input input = mock(Input.class);
        Player player = new Player();

        when(input.getInput).thenReturn();
    }
}
