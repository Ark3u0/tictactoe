import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) {
       List<Player> players = new ArrayList<>();
       Input input = new Input();
       players.add(new Player(System.out, input, Turn.O));
       players.add(new Player(System.out, input, Turn.X));
       new TicTacToeApp(new Board(System.out), players, System.out).start();
   }
}
