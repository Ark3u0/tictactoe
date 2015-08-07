import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player {
    protected Turn turn;
    public abstract Pair<Turn, Integer> makeAMove(List<Integer> availableSpaces);
}
