import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Helper {
    private static final int GRID_LENGTH = 7;
    private static final int GRID_SIZE = 49;
    private static final int MAX_ATTEMPTS = 200;
    private static int numOfShips = 0;
    private static final int HORIZONTAL_INCREMENT = 1;
    private static final int VERTICAL_INCREMENT = 7;
    private Random random = new Random();
    private int[] grid = new int[GRID_SIZE];
    private static final String ALPHA = "abcdefgh";
    private static Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        System.out.print("What is your guess:   ");
        return scanner.nextLine().toLowerCase();
    }

    public ArrayList<String> getBattleshipLocations(int size) {
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
                success = checkAvailableCoords(locations);
                if (success) {
                    populateGrid(locations);
                }
            }
            // System.out.println("Locations are " + Arrays.toString(locations));
            // System.out.println("Grid looks like " + Arrays.toString(grid));

        }

        // Convert numeric locations to alphaNumeric
        ArrayList<String> alphaNumLocations = getAlphaLoc(locations, increment);
        // System.out.println("Alpha locations are " + alphaNumLocations);
        return alphaNumLocations;
    }


    private ArrayList<String> getAlphaLoc(int[] locations, int increment) {
        // Convert from numerical to alphaNumerical, ex. 9 to b1, 23 to c3, etc.
        ArrayList<String> resultingList = new ArrayList<String>();
        int row;
        String rowConverted;
        int column;
        for (int loc : locations) {
            row = checkRow(loc);
            rowConverted = ALPHA.substring(row, row + 1);
            column = loc % GRID_LENGTH;
            resultingList.add(rowConverted + column);
        }
        return resultingList;
    }


    private void populateGrid(int[] locations) {
        for (int loc : locations) {
            grid[loc] = 1;
        }
    }

    private boolean checkAvailableCoords(int[] locations) {
        for (int loc : locations) {
            if (grid[loc] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLocationsAreInGridBoundaries(int[] locations, int increment) {
        int finalLocation = locations[locations.length - 1];
        // System.out.println("FinalLocation is " + finalLocation);
        if ((finalLocation < GRID_SIZE) && 
            (increment == VERTICAL_INCREMENT)) {
            // System.out.println("Check 1");
            return true;
        }
        else if ((finalLocation < GRID_SIZE) &&
                 (increment == HORIZONTAL_INCREMENT) && 
                 (checkRow(locations[0]) == checkRow(finalLocation))) {
            // System.out.println("Check 2");
            return true;
        } else {
            // System.out.println("Check 3");
            return false;
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
