//Riley Flint

//This program takes in two commandline arguments. The first argument is the file name (defaults to common.txt) and
//the second argument is the maximum number of passwords that you wish to read in from the file (defaults to 100).
//The program will take a user input after reading the file and will ask them to enter a password. After the user
//enters the password, it will check if it is contained in the array of strings read from the file. The program will
//endlessly continue to ask the user to enter passwords until the user enters the word "stop."

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hmwk03 {
    public static void main(String[] args) {
        File inputFile = new File(fetchFileName(args));
        int max = fetchMaximumSize(args);
        String[] passwords = new String[max];
        int count = readFromFile(passwords, inputFile);

        checkPasswords(passwords, count);
    }

    private static int readFromFile(String[] passwords, File inputFile) {
        int count = 0;
        int max = passwords.length;

        try {
            Scanner input = new Scanner(inputFile);
            if (input.hasNext()) {
                while ((count < max) && input.hasNext()) {
                    passwords[count] = input.next().trim();
                    count++;
                }
            } else {
                System.out.printf("File \"%s\" is empty.\n", inputFile);
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File \"%s\" not found.\n", inputFile);
            System.exit(1);
        }


        return count;
    }

    private static String fetchFileName(String[] args) {
        String result = "common.txt";
        if (args.length > 0) {
            result = args[0];
        }
        return result;
    }

    private static int fetchMaximumSize(String[] args) {
        int result = 100;
        if (args.length > 1) {
            try {
                result = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) {
                System.out.printf("\"%s\" is not a valid integer.\n", args[1]);
                System.exit(1);
            }
        }
        return result;
    }

    private static String getPassword() {
        System.out.print("Please enter your password: ");
        Scanner input = new Scanner(System.in);
        String password = input.next().trim();
        return password;
    }

    private static boolean containsPassword(String password, String[] passwords, int count) {
        boolean found = false;
        int current = 0;
        while(!found && (current < count)) {
            found = passwords[current].equalsIgnoreCase(password);
            current++;
        }
        return found;
    }

    private static void checkPasswords(String[] passwords, int count) {
        boolean stopped = false;

        System.out.println();

        System.out.println("Type \"Stop\" to end search.");

        while (!stopped) {
            String password = getPassword();
            stopped = password.equalsIgnoreCase("stop");
            if (stopped) {
                System.out.println("Ending search.");
            } else {
                if (containsPassword(password, passwords, count)) {
                    System.out.println("\""+password+"\" is in the list of common passwords.");
                } else {
                    System.out.println("\""+password+"\" is not in the list of common passwords.");
                }
            }
        }
    }
}
