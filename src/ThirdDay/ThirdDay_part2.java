package ThirdDay;

import java.io.File;
import java.util.Scanner;

public class ThirdDay_part2 {
    private static final int REMOVE_TO_LOWERCASE = 96;
    private static final int REMOVE_TO_UPPERCASE = 64-26;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/ThirdDay/rucksacks.txt"));
        String[] s = new String[3];
        String tempChars = "";
        boolean foundThatChar;
        // cps : count populated string
        int cps = 0;
        int sum = 0;

        while (sc.hasNextLine()) {
            if (cps < 3) s[cps++] = sc.nextLine();
            else {
                for (int i = 0; i < s[0].length(); i++) {
                    if (s[1].contains(s[0].charAt(i)+"")) {
                        tempChars += s[0].charAt(i)+"";
                    }
                }

                foundThatChar = false;
                for (int i = 0; i < tempChars.length(); i++) {
                    if (s[2].contains(tempChars.charAt(i)+"") && !foundThatChar) {
                        sum += findTotalValue(tempChars.charAt(i));
                        foundThatChar = true;
                    }
                }
                cps = 0;
                tempChars = "";
            }
        }
        System.out.println(sum);
    }

    private static int findTotalValue(char c) {
        int temp = c;
        if (temp > 96) temp -= REMOVE_TO_LOWERCASE;
        else temp -= REMOVE_TO_UPPERCASE;
        return temp;
    }

}
