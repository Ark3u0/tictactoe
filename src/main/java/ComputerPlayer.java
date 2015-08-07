import javafx.util.Pair;

import java.util.List;

public class ComputerPlayer extends Player {
    public ComputerPlayer(Turn turn) {
        super.turn = turn;
    }

    @Override
    public Pair<Turn, Integer> makeAMove(List<Integer> availableSpaces) {
        for (Integer possibleMoves : availableSpaces) {
            return new Pair<>(turn, possibleMoves);
        }
        return null;
    }
}
