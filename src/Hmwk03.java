import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hmwk03 {
    public static void main(String[] args) {
        File inputFile = new File(fetchFileName(args));
        String[] passwords = readFromFile(inputFile);

        for (String password : passwords) {
            System.out.println(password);
        }
    }

    private static String[] readFromFile(File inputFile) {
        String[] result = new String[0];

        try {
            Scanner input = new Scanner(inputFile);
            if (input.hasNext()) {
                while (input.hasNext()) {
                    result = addString(result, input.next());
                }
            } else {
                System.out.printf("File \"%s\" is empty.\n", inputFile);
                System.exit(1);
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File \"%s\" not found.\n", inputFile);
            System.exit(1);
        }

        return result;
    }

    private static String fetchFileName(String[] args) {
        String result = "common.txt";
        if (args.length > 0) {
            result = args[0];
        }
        return result;
    }

    private static String[] addString(String[] array, String add) {
        String[] result = new String[array.length+1];
        System.arraycopy(array, 0, result, 0, array.length);
        result[array.length] = add;
        return result;
    }
}
