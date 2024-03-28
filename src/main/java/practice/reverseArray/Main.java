package practice.reverseArray;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String example = "Каждый охотник желает знать, где сидит фазан";
        String[] lines = example.split(",?\\s");

        Arrays.stream(ReverseArray.reverse(lines)).forEach(System.out::println);
    }
}
