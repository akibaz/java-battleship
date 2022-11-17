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
        battleships.add(two);
        battleships.add(three);
        ArrayList<String> locations;

        System.out.println();
        System.out.println("Welcome to Battleships!");
        System.out.println();
        System.out.println("The goal is to sink all three battleships.");
        System.out.println("The fewer guesess, the better.");
        System.out.println("The ships are named: ");
        int counter = 0;
        for (Battleship battleship : battleships) {
            System.out.println("\t\t" + ++counter + ") " + battleship.getName());
        }
        System.out.println();
        System.out.println();

        for (Battleship battleship : battleships) {
            locations = helper.getBattleshipLocations(3);
            battleship.setShipLocations(locations);
            System.out.println("Battleship " + battleship.getName() + " location is " + battleship.getShipLocations());
        }

        
    }
}
