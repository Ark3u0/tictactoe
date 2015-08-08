import com.sun.javaws.exceptions.InvalidArgumentException;
import javafx.util.Pair;

import java.io.PrintStream;

public class Player {
    private Input input;
    private PrintStream printStream;
    private Symbol symbol;
    private Board board;

    public Player(PrintStream printStream, Input input, Symbol symbol, Board board) {
        this.input = input;
        this.printStream = printStream;
        this.symbol = symbol;
        this.board = board;
    }

    public void makeAMove() {
        int enteredLocation;
        while (true) {
            printStream.println("Enter a location between 1 and 9: ");
            try {
                enteredLocation = Integer.parseInt(input.scan());
                if (enteredLocation < 1 || enteredLocation > 9) {
                    continue;
                }
                if (!board.locationIsAvailable(enteredLocation)) {
                    printStream.println("Location already taken.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        board.update(symbol.toString(), enteredLocation);
    }
}
