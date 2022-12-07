package SeventhDay;


import java.io.File;
import java.util.Scanner;

public class SeventhDay_part1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("src/SeventhDay/history.txt"));
        Node tree = new Node("/", true, null);
        Node currentDir = tree;
        String s;
        int i;
        int sum;

        // Let's make the tree
        while (sc.hasNextLine()) {
            s = sc.nextLine();

            // Check if line is user command
            if (s.charAt(0) == '$') {
                s = s.substring(2);
                System.out.println(s);

                // Command cd
                if (s.substring(0, 2).equalsIgnoreCase("cd")) {
                    // Checking cd syntax
                    s = s.substring(3);
                    if (s.equalsIgnoreCase("/")) {
                        currentDir = tree;
                    }
                    else if (s.equalsIgnoreCase("..")) {
                        currentDir = currentDir.getParent();
                    }
                    else currentDir = currentDir.getChildByName(s);
                    System.out.println("Guardo ora: " + currentDir);

                }
            }
            else { // ls case
                System.out.println(s);
                if (s.substring(0, 3).equalsIgnoreCase("dir")) {
                    s = s.substring(4);
                    System.out.println("Creo dir con nome: " + s);
                    currentDir.createNewChild(new Node(s, true, currentDir));
                }
                else {
                    i = 0;
                    while (s.charAt(i) != ' ') {
                        i++;
                    }
                    currentDir.createNewChild(new Node(
                            s.substring(i+1), false, Integer.parseInt(s.substring(0, i)), currentDir));

                }
            }
        }
        tree.findTotalSize();
        //System.out.println(tree.getSize());

        // Now we can do everything we want
        sum = tree.numbersDirWithLessThan100000();
        System.out.println(sum);
    }

}
