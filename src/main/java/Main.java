import static java.util.Arrays.asList;

public class Main {
   public static void main(String[] args) {
       Board board = new Board(System.out, asList(" ", " ", " ", " ", " ", " ", " ", " ", " "));
       Input input = new Input();
       new Game(board,
               asList(new Player(System.out, input, Symbol.O, board),
               new Player(System.out, input, Symbol.X, board)),
               System.out).start();
   }
}
