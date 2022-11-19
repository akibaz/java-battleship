import java.util.ArrayList;


public class BattleshipGame {
    private static Helper helper = new Helper();
    private static ArrayList<Battleship> battleships = new ArrayList<Battleship>();
    private static int numOfGuesses = 0;

    public static void main(String[] args) {
        setUpGame();
        startPlaying();
        finishGame();
    }

    private static void finishGame() {
        System.out.println();
        if (numOfGuesses < 15) {
            System.out.println("Excellent sailor!");
        } else if (numOfGuesses < 20) {
            System.out.println("Not bad gunner.");
        } else if(numOfGuesses < 25) {
            System.out.println("Mediocre...");
        } else {
            System.out.println("More practice....");
        }
    }

    private static void startPlaying() {
        boolean isFinished = false;
        String userGuess;
        String result = "miss";
        int index;

        while (!isFinished) {
            numOfGuesses++;
            userGuess = helper.getUserInput();
            for (Battleship battleship : battleships) {
                result = battleship.checkYourself(userGuess);
                if (result.equals("hit")) {
                    System.out.println("hit");
                    break;
                }
                else if (result.equals("kill")) {
                    index = battleships.indexOf(battleship);
                    battleships.remove(index);
                    break;
                }
            }
            if (result.equals("miss")) {
                System.out.println("miss");
            }
            if (battleships.isEmpty()) {
                isFinished = true;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("You destroyed all battleships!");
        System.out.println("It took you " + numOfGuesses + " guesses.");
    }

    private static void setUpGame() {
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
            // Create and insert locations
            locations = helper.getBattleshipLocations(3);
            battleship.setShipLocations(locations);
            // Print for easier testing
            // System.out.println("Battleship " + battleship.getName() + " location is " + battleship.getShipLocations());
        }

        
    }
}
