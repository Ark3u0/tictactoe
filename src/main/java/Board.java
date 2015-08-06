import javafx.util.Pair;

import java.io.PrintStream;

public class Board {
    private PrintStream printstream;
    private Turn[] boardSpaces;
    private int turnCount;

    public Board(PrintStream printstream) {
        this.printstream = printstream;
        this.boardSpaces = new Turn[9];
        this.turnCount = 0;
        for (int i = 0; i < 9 ; i++) {
            boardSpaces[i] = Turn.EMPTY;
        }
    }


    private String generateVerticalLines(int row) {
        String output = null;
        switch (row) {
            case 0:
                output = boardSpaces[0] + " | " + boardSpaces[1] + " | " + boardSpaces[2];
                break;
            case 1:
                output = boardSpaces[3] + " | " + boardSpaces[4] + " | " + boardSpaces[5];
                break;
            case 2:
                output = boardSpaces[6] + " | " + boardSpaces[7] + " | " + boardSpaces[8];
                break;
        }
        return output;
    }

    public void generateBoard() {
        String output = generateVerticalLines(0) + "\n" + "---------\n" + generateVerticalLines(1) + "\n---------\n" + generateVerticalLines(2) + "\n";
        printstream.print(output);
    }

    public boolean spaceIsEmpty(Pair<Turn, Integer> space) {
        if (boardSpaces[space.getValue() - 1] == Turn.EMPTY) {
            return true;
        }
        printstream.println("Location already taken: enter an unoccupied space.");
        return false;
    }

    public boolean boardIsFull() {
        return turnCount == 9;
    }

    public void updateBoard(Pair<Turn, Integer> move) {
        boardSpaces[move.getValue() - 1] = move.getKey();
        turnCount++;
    }
}
