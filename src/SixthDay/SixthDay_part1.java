package SixthDay;

import java.io.File;
import java.util.Scanner;

public class SixthDay_part1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("src/SixthDay/signal.txt"));
        int i = 4;
        String s = sc.nextLine();
        String workingSubString;
        boolean hasFoundMarker = false;

        while (!hasFoundMarker) {
            // 4 characters
            workingSubString = s.substring(i-4, i);

            if (containsAllDiverseChars(workingSubString)) {
                hasFoundMarker = true;
            }
            else {
                //System.out.println(i + " - " + workingSubString);
                i++;
            }
        }
        System.out.println(i);
    }


    private static boolean containsAllDiverseChars(String s) {
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if ( i != j && s.charAt(i)==s.charAt(j)) result = false;
            }
        }
        return result;
    }
}
