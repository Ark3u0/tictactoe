import javafx.util.Pair;

public class ComputerPlayer extends Player {
    public ComputerPlayer(Turn turn) {
        super.turn = turn;
    }

    @Override
    public Pair<Turn, Integer> makeAMove() {
        for (int move = 1; move < 10; move++) {
            if (!playerMoveHistory.containsValue(move)) {
                playerMoveHistory.put(turn, move);
                return new Pair<>(turn, move);
            }
        }
        return null;
    }
}
