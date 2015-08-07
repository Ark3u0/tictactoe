import javafx.util.Pair;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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

    public boolean boardIsFull() {
        return turnCount == 9;
    }

    public void updateBoard(Pair<Turn, Integer> move) {
        boardSpaces[move.getValue() - 1] = move.getKey();
        turnCount++;
    }


    private boolean checkForWinnerOnDiagonals() {
        if (boardSpaces[0] == boardSpaces[4] && boardSpaces[4] == boardSpaces[8] && boardSpaces[0] != Turn.EMPTY) {
            return true;
        } else if (boardSpaces[2] == boardSpaces[4] && boardSpaces[4] == boardSpaces[6] && boardSpaces[2] != Turn.EMPTY) {
            return true;
        }
        return false;
    }

    private boolean checkForWinnerOnRows() {
        if (boardSpaces[0] == boardSpaces[1] && boardSpaces[1] == boardSpaces[2] && boardSpaces[0] != Turn.EMPTY) {
            return true;
        } else if (boardSpaces[3] == boardSpaces[4] && boardSpaces[4] == boardSpaces[5] && boardSpaces[3] != Turn.EMPTY) {
            return true;
        } else if (boardSpaces[6] == boardSpaces[7] && boardSpaces[7] == boardSpaces[8] && boardSpaces[6] != Turn.EMPTY) {
            return true;
        }
        return false;
    }

    private boolean checkForWinnerOnColumns() {
        if (boardSpaces[1] == boardSpaces[4] && boardSpaces[4] == boardSpaces[7] && boardSpaces[1] != Turn.EMPTY) {
            return true;
        } else if (boardSpaces[0] == boardSpaces[3] && boardSpaces[3] == boardSpaces[6] && boardSpaces[0] != Turn.EMPTY) {
            return true;
        } else if (boardSpaces[2] == boardSpaces[5] && boardSpaces[5] == boardSpaces[8] && boardSpaces[2] != Turn.EMPTY) {
            return true;
        }
        return false;
    }

    public List<Integer> availableSpaces() {
        List<Integer> availableSpaces = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (boardSpaces[i] == Turn.EMPTY) {
                availableSpaces.add(i + 1);
            }
        }
        return availableSpaces;
    }

    public boolean isThereAWinner() {
        return checkForWinnerOnDiagonals() || checkForWinnerOnRows() || checkForWinnerOnColumns();
    }


}
