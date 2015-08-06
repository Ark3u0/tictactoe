import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.tools.corba.se.idl.InvalidArgument;
import javafx.util.Pair;

import java.io.PrintStream;

public class Player {
    private Input input;
    private PrintStream printstream;
    private Turn turn;

    public Player(PrintStream printstream, Input input, Turn turn) {
        this.input = input;
        this.printstream = printstream;
        this.turn = turn;
    }

    public Pair<Turn, Integer> makeAMove() {
        while (true) {
            try {
                int providedNumber = Integer.parseInt(input.getInput());
                if (providedNumber < 1 || providedNumber > 9) {
                    throw new InvalidArgumentException(null);
                }
                return new Pair<>(turn, providedNumber);
            } catch (NumberFormatException | InvalidArgumentException e) {
                printstream.println("Invalid Input: enter a number 1-9.");
            }
        }
    }
}
