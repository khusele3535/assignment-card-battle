package io;
import java.util.Scanner;

public class InputReader {
    private Scanner scanner = new Scanner(System.in);

    public int getIntInput(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Буруу оролт! Тоо оруулна уу: ");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
}
