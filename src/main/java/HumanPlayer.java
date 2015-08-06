import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.util.Pair;

import java.io.PrintStream;

public class HumanPlayer extends Player {

    private PrintStream printstream;
    private Input input;

    public HumanPlayer(PrintStream printstream, Input input, Turn turn) {
        this.printstream = printstream;
        this.input = input;
        super.turn = turn;
    }

    @Override
    public Pair<Turn, Integer> makeAMove() {
        while (true) {
            try {
                int providedNumber = Integer.parseInt(input.getInput());
                if (providedNumber < 1 || providedNumber > 9) {
                    throw new InvalidArgumentException(null);
                } else if (playerMoveHistory.containsValue(providedNumber)) {
                    printstream.println("Location already taken: enter an unoccupied space.");
                    continue;
                }
                playerMoveHistory.put(turn, providedNumber);
                return new Pair<>(turn, providedNumber);
            } catch (NumberFormatException | InvalidArgumentException e) {
                printstream.println("Invalid Input: enter a number 1-9.");
            }
        }
    }
}
