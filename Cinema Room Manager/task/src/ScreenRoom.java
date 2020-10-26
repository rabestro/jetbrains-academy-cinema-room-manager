import java.util.BitSet;

import static java.lang.System.lineSeparator;
import static java.util.Objects.checkIndex;

public class ScreenRoom {
    public static final int MAX_ROWS = 9;
    public static final int MAX_COLS = 9;
    public static final int SMALL_ROOM = 60;
    public static final int HIGH_PRICE = 10;
    public static final int LOW_PRICE = 8;
    public static final int EXTRA_PRICE = HIGH_PRICE - LOW_PRICE;

    private final int rows;
    private final int cols;
    private final BitSet seats;
    private final int expensiveSeats;

    public ScreenRoom(int rows, int cols) {
        checkIndex(rows - 1, MAX_ROWS);
        checkIndex(cols - 1, MAX_COLS);
        this.rows = rows;
        this.cols = cols;
        seats = new BitSet(rows * cols);
        expensiveSeats = isSmallRoom() ? totalSeats() : rows / 2 * cols;
    }

    public int book(int row, int col) {
        seats.set(index(row, col));
        return isSmallRoom() || (row <= rows / 2) ? HIGH_PRICE : LOW_PRICE;
    }

    public SeatState getSeatState(int row, int col) {
        if (row < 1 || row > rows || col < 1 || col > cols) {
            return SeatState.WRONG;
        }
        return seats.get(index(row, col)) ? SeatState.BOOKED : SeatState.SEAT_FREE;
    }

    private int index(int row, int col) {
        return (row - 1) * cols + col - 1;
    }

    public int ticketsSold() {
        return seats.cardinality();
    }

    public int totalSeats() {
        return rows * cols;
    }

    public double getPercentage() {
        return (double) ticketsSold() / totalSeats();
    }

    public boolean isSmallRoom() {
        return totalSeats() <= SMALL_ROOM;
    }

    public int incomeCurrent() {
        return ticketsSold() * LOW_PRICE + seats.get(0, expensiveSeats).cardinality() * EXTRA_PRICE;
    }

    public int incomeTotal() {
        return totalSeats() * LOW_PRICE + expensiveSeats * EXTRA_PRICE;
    }

    @Override
    public String toString() {
        final var result = new StringBuilder("Cinema:");
        result.append(lineSeparator()).append("  1 2 3 4 5 6 7 8 9", 0, 1 + cols * 2);
        for (int row = 1; row <= rows; row++) {
            result.append(lineSeparator()).append(row);
            for (int col = 1; col <= cols; col++) {
                result.append(" ").append(getSeatState(row, col).name().charAt(0));
            }
        }
        return result.append(lineSeparator()).toString();
    }

    public enum SeatState {
        SEAT_FREE, BOOKED, WRONG
    }
}
