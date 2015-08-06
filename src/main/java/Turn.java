
public enum Turn {
    X("X"), O("O"), EMPTY(" ");

    private String printValue;


    Turn(String printValue) {
        this.printValue = printValue;
    }

    @Override
    public String toString() {
        return this.printValue;
    }
}
