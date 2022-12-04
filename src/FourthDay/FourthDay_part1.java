package FourthDay;

import java.io.File;
import java.util.Scanner;

public class FourthDay_part1 {

    // Input: 17-99,18-24
    public int firstInitNum;   // ==> 17
    public int firstEndNum;    // ==> 99
    public int secondInitNum;  // ==> 18
    public int secondEndNum;   // ==> 24

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/FourthDay/sections.txt"));
        String s; // 17-99,18-24
        FourthDay_part1 numbersRow = new FourthDay_part1();
        int count = 0;

        while (sc.hasNextLine()) {
            s = sc.nextLine();

            // Initialize numbers;
            numbersRow.initializeNumbers(s);
            if (numbersRow.contained()) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    public void initializeNumbers(String s) {
        boolean foundFirstInitNum = false;
        String tempS = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='-') {
                if (!foundFirstInitNum) {
                    foundFirstInitNum = true;
                    firstInitNum = Integer.parseInt(tempS);
                }
                else {
                    secondInitNum = Integer.parseInt(tempS);
                }
                tempS = "";
            }
            else if (s.charAt(i)==',') {
                firstEndNum = Integer.parseInt(tempS);
                tempS = "";
            }
            else {
                tempS += s.charAt(i)+"";
            }
        }
        secondEndNum = Integer.parseInt(tempS);
    }

    public boolean contained() {
        boolean result = false;

        if (firstInitNum <= secondInitNum && firstEndNum >= secondEndNum) result = true;

        // Second contains first
        if (secondInitNum <= firstInitNum && secondEndNum >= firstEndNum) result = true;

        return result;
    }

}
