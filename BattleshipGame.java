import java.util.ArrayList;


public class BattleshipGame {
    private static Helper helper = new Helper();
    private static ArrayList<Battleship> battleships = new ArrayList<Battleship>();

    public static void main(String[] args) {
        setUpGame();
    }

    public static void setUpGame() {
        Battleship one = new Battleship();
        Battleship two = new Battleship();
        Battleship three = new Battleship();
        one.setName("cabista");
        two.setName("hacqui");
        three.setName("poniez");
        battleships.add(one);

        ArrayList<String> locations = helper.getBattleshipLocations(3);
        one.setShipLocations(null);

        
    }
}
