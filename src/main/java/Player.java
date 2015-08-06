import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public abstract class Player {
    protected Turn turn;
    protected static Map<Turn, Integer> playerMoveHistory = new HashMap<>();

    public abstract Pair<Turn, Integer> makeAMove();
}
