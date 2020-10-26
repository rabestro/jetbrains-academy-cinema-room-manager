import java.util.Scanner;

public class Cinema {
    private static Scanner scanner = new Scanner(System.in);
    private static ScreenRoom screenRoom;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        final var rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        final var cols = scanner.nextInt();
        screenRoom = new ScreenRoom(rows, cols);

        Menu.create()
                .add("Show the seats", () -> System.out.println(screenRoom))
                .add("Buy a ticket", Cinema::buyTicket)
                .addExit()
                .run();

    }

    private static void buyTicket() {
        System.out.println("Enter a row number:");
        final var row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        final var col = scanner.nextInt();

        final var price = screenRoom.book(row, col);
        System.out.println("Ticket price: $" + price);
    }
}