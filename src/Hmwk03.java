public class Hmwk03 {
    public static void main() {
        String[] test = {"one", "two", "three"};
        String[] added = addItem(test, "four");
        for (String item : added) {
            System.out.println(item);
        }
    }
    private static String[] addItem(String[] array, String add) {
        int newLength = array.length+1;
        String[] result = new String[newLength];

        for (int i = 0; i < array.length; i++) {
            result[i] = array[i];
        }

        result[newLength] = add;

        return result;
    }
}
