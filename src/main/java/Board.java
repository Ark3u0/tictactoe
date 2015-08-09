
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

    public boolean checkDiagonalForWinner() {
        boolean diagonal159 = (locations.get(0) == locations.get(4) && locations.get(4) == locations.get(8) && locations.get(0) != " ");
        boolean diagonal357 = (locations.get(2) == locations.get(4) && locations.get(4) == locations.get(6) && locations.get(2) != " ");
        return diagonal159 || diagonal357;
    }

    public boolean checkRowForWinner() {
        boolean row123 = (locations.get(0) == locations.get(1) && locations.get(1) == locations.get(2) && locations.get(0) != " ");
        boolean row456 = (locations.get(3) == locations.get(4) && locations.get(4) == locations.get(5) && locations.get(3) != " ");
        boolean row789 = (locations.get(6) == locations.get(7) && locations.get(7) == locations.get(8) && locations.get(6) != " ");
        return row123 || row456 || row789;
    }

    public boolean checkColumnForWinner() {
        boolean column147 = (locations.get(0) == locations.get(3) && locations.get(3) == locations.get(6) && locations.get(0) != " ");
        boolean column258 = (locations.get(1) == locations.get(4) && locations.get(4) == locations.get(7) && locations.get(1) != " ");
        boolean column369 = (locations.get(2) == locations.get(5) && locations.get(5) == locations.get(8) && locations.get(2) != " ");
        return column147 || column258 || column369;
    }

    public boolean hasWinner() {
        return checkDiagonalForWinner() || checkRowForWinner() || checkColumnForWinner();
    }
}
