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

        System.out.println("Enter a row number:");
        final var row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        final var col = scanner.nextInt();

        final var price = screenRoom.book(row, col);
        System.out.println("Ticket price: $" + price);
        System.out.println(screenRoom);

    }
}