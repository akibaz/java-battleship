import java.util.ArrayList;

public class BattleshipTestDrive {
    public static void main(String[] args) {
        // Create object
        Battleship one = new Battleship();

        // Set its name and print it
        one.setName("poniez");
        System.out.println("The name of the battleship object is " + one.getName() + ".");

        // Create battleship locations on the grid
        ArrayList<String> testLocations = new ArrayList<String>();
        testLocations.add("a1");
        testLocations.add("b1");
        testLocations.add("c1");

        one.setShipLocations(testLocations);
        System.out.println("Acquired ship locations are ");
        ArrayList<String> result = one.getShipLocations();
        System.out.println(result);

        // Test destroying ships locations
        one.checkYourself("c1");
        System.out.println(result);
    }
}