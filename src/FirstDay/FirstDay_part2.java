package FirstDay;

import java.io.File;
import java.util.Scanner;

public class FirstDay_part2 {

    // Second Part
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("./src/FirstDay/calories.txt"));

        int[] max = new int[3];
        int thisNum = 0;
        int result = 0;

        while (sc.hasNextLine()) {
            String temp = sc.nextLine();

            if (!temp.isEmpty()) {
                thisNum += Integer.parseInt(temp);
            }
            else {
                if (thisNum > max[findMinimumIndex(max)]) {
                    max[findMinimumIndex(max)] = thisNum;
                }
                thisNum = 0;
            }
        }

        for (int j : max) {
            System.out.println(j);
            result += j;
        }
        System.out.println("Final result: "+result);

    }

    /**
     * @param max an array of integers
     * @return the index of the minimum value of param max
     */
    public static int findMinimumIndex(int[] max) {
        int minimum_i = 0;
        for (int i = 0; i < max.length; i++) {
            if (max[i] < max[minimum_i]) {
                minimum_i = i;
            }
        }
        return minimum_i;
    }
}
