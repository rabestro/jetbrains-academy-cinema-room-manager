import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // put your code here
        final var scanner = new Scanner(System.in);
        final var arraysCount = scanner.nextInt();
        final var arraysLength = scanner.nextInt();
        int arrayNumber = 0;
        int arrayOperations = 0;

        for (int i = 1; i <= arraysCount; i++) {
            int operations = selectionSort(scanner.tokens().limit(arraysLength).mapToInt(Integer::parseInt).toArray());
            if (operations > arrayOperations) {
                arrayNumber = i;
                arrayOperations = operations;
            }
        }
        System.out.println(arrayNumber);
    }

    public static int selectionSort(int[] array) {
        int operations = 0;
        for (int i = 0; i < array.length - 1; i++) {
            int index = i; // the index of the found min

            /* Iterating over the unsorted subarray to find the min */
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[index]) {
                    operations++;
                    index = j;
                }
            }

            /* Exchanging the found min and the current element */
            int min = array[index];
            array[index] = array[i];
            array[i] = min;
            operations++;
        }

        return operations;
    }
}