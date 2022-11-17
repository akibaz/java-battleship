import java.util.ArrayList;

public class HelperTestDrive {
    public static void main(String[] args) {
        Helper helper = new Helper();

        // Test getBattleshipLocations() method
        ArrayList<String> test1 = new ArrayList<String>();
        ArrayList<String> test2 = new ArrayList<String>();
        test1 = helper.getBattleshipLocations(3);
        test2 = helper.getBattleshipLocations(3);
        System.out.println("Battleship1 locations " + test1);
        System.out.println("Battleship2 locations " + test2);
    }
}
