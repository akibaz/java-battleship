import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Helper {
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private static final int MAX_ATTEMPTS = 200;
    private static int numOfShips = 0;
    private static final int HORIZONTAL_INCREMENT = 1;
    private static final int VERTICAL_INCREMENT = 7;
    private Random random = new Random();

    public void getBattleshipLocations(int size) {
        //* Get location of ships cells on a grid, 0-48
        int[] locations = new int[size];
        boolean success = false;
        int attempts = 0;
        
        // Increment numOfShips because it determinates increment value
        numOfShips++;

        // Calculate increment 
        int increment = getIncrement();
        // System.out.println("Increment is " + increment);

        while (!success && ++attempts < MAX_ATTEMPTS) {
            int startPoint = random.nextInt(GRID_SIZE);
            // System.out.println("StartPoint is " + startPoint);
            for (int i = 0; i < size; i++) {
                locations[i] = startPoint + increment;
                startPoint += increment;
            }
            // success = true;
            // System.out.println(Arrays.toString(locations));

            if (checkLocationsAreInGridBoundaries(locations, increment)){
                success = true;
            }
            System.out.println(Arrays.toString(locations));
            
        }


    }

    private boolean checkLocationsAreInGridBoundaries(int[] locations, int increment) {
        int finalLocation = locations[locations.length - 1];
        if (finalLocation >= GRID_SIZE) {
            return false;
        }
        else if (increment == HORIZONTAL_INCREMENT && checkRow(locations[0]) == checkRow(finalLocation)) {
            return true;
        } else {
            return true;
        }
    }

    private int checkRow(int location) {
        return location / GRID_LENGTH;
    }

    private int getIncrement() {
        if (numOfShips % 2 == 0) {
            return HORIZONTAL_INCREMENT;
        } else {
            return VERTICAL_INCREMENT;
        }
    }

}
