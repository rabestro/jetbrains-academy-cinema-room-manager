import java.util.BitSet;

import static java.util.Objects.checkIndex;

public class ScreenRoom {
    public static final int MAX_ROWS = 9;
    public static final int MAX_COLS = 9;

    private final int rows;
    private final int cols;
    private final BitSet seats;

    public ScreenRoom(int rows, int cols) {
        checkIndex(rows - 1, MAX_ROWS);
        checkIndex(cols - 1, MAX_COLS);
        this.rows = rows;
        this.cols = cols;
        seats = new BitSet(rows * cols);
    }
}
