package SecondDay;

import java.io.File;
import java.util.Scanner;

public class SecondDay_part1 {

    /*
    o / u : o ==> opponent, u ==> user
    -----
    A / X = Rock (for the user, grants one point)
    B / Y = Paper (for the user, grants two points)
    C / Z = Scissors (for the user, grants three points)
     */

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/SecondDay/input.txt"));
        int score = 0;
        String s;
        String enemyAction;
        String userAction;

        while (sc.hasNextLine()) {
            s = sc.nextLine();
            enemyAction = s.substring(0, 1);
            userAction = s.substring(2, 3);

            score += findScore(userAction, enemyAction);

        }

        System.out.println(score);
    }

    private static int findScore(String userAction, String enemyAction) {
        /*
        lose ==> 0 points
        draw ==> 3 points
        win  ==> 6 points
         */

        int result = 0;

        // rock
        if (userAction.equalsIgnoreCase("X")) {
            result += 1;
            switch (enemyAction) {
                // rock
                case "A" -> result += 3;
                // scissors
                case "C" -> result += 6;
            }
        }

        // paper
        if (userAction.equalsIgnoreCase("Y")) {
            result += 2;
            switch (enemyAction) {
                // paper
                case "B" -> result += 3;
                // rock
                case "A" -> result += 6;
            }
        }

        // scissors
        if (userAction.equalsIgnoreCase("Z")) {
            result += 3;
            switch (enemyAction) {
                // scissors
                case "C" -> result += 3;
                // paper
                case "B" -> result += 6;
            }
        }
        return result;
    }

}
