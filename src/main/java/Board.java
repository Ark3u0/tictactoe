import java.io.PrintStream;

public class Board {
    private PrintStream printstream;

    public Board(PrintStream printstream) {
        this.printstream = printstream;
    }

    public void generateColumns() {
        printstream.println("  |   |   ");
    }

    public void generateRows() {
        printstream.println("---------");
    }

    public void generateBoard() {
        generateColumns();
        generateRows();
        generateColumns();
        generateRows();
        generateColumns();
    }
}
