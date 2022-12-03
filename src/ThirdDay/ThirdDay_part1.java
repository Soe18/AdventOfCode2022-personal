package ThirdDay;

import java.io.File;
import java.util.Scanner;

public class ThirdDay_part1 {
    private static final int REMOVE_TO_LOWERCASE = 96;
    private static final int REMOVE_TO_UPPERCASE = 64-26;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/ThirdDay/rucksacks.txt"));
        String s;
        String s1;
        String s2;
        int sum = 0;
        boolean foundThatChar;

        while (sc.hasNextLine()) {
            s = sc.nextLine();
            s1 = s.substring(0, s.length()/2);
            s2 = s.substring(s.length()/2);

            foundThatChar = false;

            for (int i = 0; i < s1.length(); i++) {
                if (s2.contains(s1.charAt(i)+"") && !foundThatChar) {
                    sum += findTotalValue(s1.charAt(i));
                    foundThatChar = true;

                    //System.out.println(s1.charAt(i) + " " + findTotalValue(s1.charAt(i)));
                }
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
