
public enum Symbol {
    X("X"), O("O");

    private String printValue;


    Symbol(String printValue) {
        this.printValue = printValue;
    }

    @Override
    public String toString() {
        return this.printValue;
    }
}
