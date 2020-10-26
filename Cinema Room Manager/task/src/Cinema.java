import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        final var scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        final var rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        final var cols = scanner.nextInt();

        final var screenRoom = new ScreenRoom(rows, cols);
        System.out.println(screenRoom);

        final var seats = rows * cols;

        final var income = seats > 60
                ? 8 * seats + 2 * (rows / 2 * cols)
                : 10 * seats;

        System.out.println("Total income:");
        System.out.println("$" + income);
    }
}