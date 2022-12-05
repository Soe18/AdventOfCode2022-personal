package FifthDay;

import java.io.File;
import java.util.Scanner;

public class FifthDay_part1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/FifthDay/movements.txt"));
        String s;
        String temp;
        int countCurrentStack = 0;
        int howManyToMove;
        int startStack;
        int endStack;
        int j;
        Stack[] stacks = new Stack[9];

        while (sc.hasNextLine()) {
            s = sc.nextLine();

            // Initialize Stacks
            if (countCurrentStack < 9) {
                stacks[countCurrentStack] = new Stack(109);
                for (int i = 0; i < s.length(); i++) {
                    stacks[countCurrentStack].push(s.charAt(i));
                }
                countCurrentStack++;
            }
            else {
                temp = "";
                s = s.substring(5);
                j = 0;
                //System.out.println("1. "+ s);
                do{
                    if (s.charAt(j) != ' ') temp += s.charAt(j)+"";
                } while(s.charAt(j++) != ' ');

                s = s.substring(j);
                howManyToMove = Integer.parseInt(temp);

                s = s.substring(5);
                startStack = Integer.parseInt(s.charAt(0)+"")-1;

                s = s.substring(2);
                endStack = Integer.parseInt(s.substring(3))-1;

                // Finally time to mafs

                for (int i = 0; i < howManyToMove; i++) {
                    stacks[endStack].push(stacks[startStack].pop());
                }
            }

        }
        for (Stack stack : stacks) {
            System.out.print(stack.topElem());
        }
    }
}
