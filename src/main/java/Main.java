import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScreenLock sl = new ScreenLock();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the starting node (A-I): ");
        char startChar = scanner.next().toUpperCase().charAt(0);

        if (startChar < 'A' || startChar > 'I') {
            System.out.println("Invalid starting node. Please enter a character between A and I.");
            return;
        }

        System.out.print("Enter the pattern length (1-9): ");
        int patternLength = scanner.nextInt();

        if (patternLength < 1 || patternLength > 9) {
            System.out.println("Invalid pattern length. Please enter a number between 1 and 9.");
            return;
        }

        int combinations = sl.calculateCombinations(startChar, patternLength);
        System.out.println("Number of combinations: " + combinations);
    }
}
