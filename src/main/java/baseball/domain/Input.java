package baseball.domain;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputStringNumber() {
        return scanner.next();
    }

    public static int inputIntNumber() {
        return scanner.nextInt();
    }

}
