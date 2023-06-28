import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Inserted array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(" " + array[i]);
        }
        System.out.println();
        var maxValue = new Thread(() -> {
            int max = Arrays.stream(array).max().getAsInt();
            System.out.println("Max value - " + max);
            var threadName = Thread.currentThread().getName();
            System.out.println("Thread executed with name: " + threadName);
        }, "maxValue");
        var minValue = new Thread(() -> {
            int min = Arrays.stream(array).min().getAsInt();
            System.out.println("Min value - " + min);
            var threadName = Thread.currentThread().getName();
            System.out.println("Thread executed with name: " + threadName);
        }, "minValue");
        maxValue.start();
        minValue.start();
    }
}
