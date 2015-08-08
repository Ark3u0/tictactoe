import javafx.util.Pair;

import java.io.PrintStream;
import java.util.List;

public class Board {
    private PrintStream printStream;
    private List<String> locations;

    public Board(PrintStream printstream, List<String> locations) {
        this.printStream = printstream;
        this.locations = locations;
    }

    public void generate() {
        printStream.println(
                locations.get(0) + " | " + locations.get(1) + " | " + locations.get(2) + "\n"
                + "---------\n" +
                locations.get(3) + " | " + locations.get(4) + " | " + locations.get(5) + "\n"
                + "---------\n" +
                locations.get(6) + " | " + locations.get(7) + " | " + locations.get(8));
    }

    public boolean locationIsAvailable(int location) {
        if (locations.get(location - 1) == " ") {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        int takenCount = 0;
        for (String location : locations) {
            if (location != " ") {
                takenCount++;
            }
        }
        return takenCount == locations.size();
    }

    public void update(String symbol, int location) {
        locations.set(location - 1, symbol);
    }

    public void hasWinner() {

    }
}
