package SecondDay;

import java.io.File;
import java.util.Scanner;

public class SecondDay_part2 {

    /*
    A = Rock (for the user, grants one point)
    B = Paper (for the user, grants two points)
    C = Scissors (for the user, grants three points)

    -----

    X = must lose
    Y = must draw
    Z = must win

     */

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/SecondDay/input.txt"));
        int score = 0;
        String s;
        String enemyAction;
        String userStrategy;

        while (sc.hasNextLine()) {
            s = sc.nextLine();
            enemyAction = s.substring(0, 1);
            userStrategy = s.substring(2, 3);

            score += findScore(userStrategy, enemyAction);

        }

        System.out.println(score);
    }

    private static int findScore(String userAction, String enemyAction) {
        /*
        lose ==> 0 points
        even ==> 3 points
        win  ==> 6 points

        -----

        rock     ==> 1 point
        paper    ==> 2 points
        scissors ==> 3 points
         */

        int result = 0;

        // lose case
        if (userAction.equalsIgnoreCase("X")) {
            switch (enemyAction) {
                // if they use rock, lose with scissors
                case "A" -> result += 3;
                // if they use paper, lose with rock
                case "B" -> result += 1;
                // if they use scissors, lose with paper
                case "C" -> result += 2;
            }
        }

        // draw case
        if (userAction.equalsIgnoreCase("Y")) {
            result += 3;
            switch (enemyAction) {
                // if they use rock, draw with rock
                case "A" -> result += 1;
                // if they use paper, draw with paper
                case "B" -> result += 2;
                // if they use scissors, draw with scissors
                case "C" -> result += 3;
            }
        }

        // win case
        if (userAction.equalsIgnoreCase("Z")) {
            result += 6;
            switch (enemyAction) {
                // if they use rock, win with paper
                case "A" -> result += 2;
                // if they use paper, win with scissors
                case "B" -> result += 3;
                // if they use scissors, win with rock
                case "C" -> result += 1;
            }
        }
        return result;
    }

}
