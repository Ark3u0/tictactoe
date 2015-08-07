import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
    @Test
    public void shouldProvideMoveOneWhenMakingAMoveOnEmptyBoard() {
        ComputerPlayer cpu = new ComputerPlayer(Turn.O);
        int spaceNumber = cpu.makeAMove().getValue();
        assertEquals(1, spaceNumber);
    }

    @Test
    public void shouldProvideMoveTwoWhenSpaceOneHasBeenOccupied() {
        ComputerPlayer cpu = new ComputerPlayer(Turn.O);
        cpu.makeAMove();
        int spaceNumber = cpu.makeAMove().getValue();
        assertEquals(2, spaceNumber);
    }

}
