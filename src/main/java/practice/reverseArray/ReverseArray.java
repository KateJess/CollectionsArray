package practice.reverseArray;

public class ReverseArray {

    public static String[] reverse(String[] strings) {
        int length = strings.length;

        String[] reverse = new String[length];

        for (int i = 0; i < length; i++) {
            reverse[i] = strings[length - 1 - i];
        }

        for (int i = 0; i < length; i++) {
            strings[i] = reverse[i];
        }

        return strings;
    }
}