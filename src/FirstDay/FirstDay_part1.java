package FirstDay;

import java.io.File;
import java.util.Scanner;

public class FirstDay_part1 {

    // First Part
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("./src/FirstDay/calories.txt"));

        int max = 0;
        int thisNum = 0;

        while (sc.hasNextLine()) {
            String temp = sc.nextLine();

            if (!temp.isEmpty()) {
                thisNum += Integer.parseInt(temp);
            }
            else {
                if (thisNum > max) max = thisNum;
                thisNum = 0;
            }
        }
        System.out.println("Final result: "+max);
    }
}
