import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        int[] sortArr = {12, 6, 4, 1, 15, 10};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие: 1-Сортировка вставками; 2-Сортировка пузырьком; 3-Сортировка выбором;");
        int c = scanner.nextInt();
        if (c == 1) {
            var insertionSort = new Thread(() -> {
                insertionSort(sortArr);
                var threadName = Thread.currentThread().getName();
                System.out.println("Thread executed with name: " + threadName);
            }, "insertionSort");
            insertionSort.start();
        }
        if (c == 2) {
            var bubbleSort = new Thread(() -> {
                bubbleSort(sortArr);
                var threadName = Thread.currentThread().getName();
                System.out.println("Thread executed with name: " + threadName);
            }, "bubbleSort");
            bubbleSort.start();
        }
        if (c == 3) {
            var selectionSort = new Thread(() -> {
                selectionSort(sortArr);
                var threadName = Thread.currentThread().getName();
                System.out.println("Thread executed with name: " + threadName);
            }, "selectionSort");
            selectionSort.start();
        }
        for (int i = 0; i < sortArr.length; i++) {
            System.out.print(sortArr[i] + "\n");
        }
    }

    public static void bubbleSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }

    public static void insertionSort(int[] sortArr) {
        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < sortArr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }

    public static void selectionSort(int[] sortArr) {
        for (int i = 0; i < sortArr.length; i++) {
            int pos = i;
            int min = sortArr[i];
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sortArr[j] < min) {
                    //pos - индекс наименьшего элемента
                    pos = j;
                    min = sortArr[j];
                }
            }
            sortArr[pos] = sortArr[i];
            //меняем местами наименьший с sortArr[i]
            sortArr[i] = min;
        }
    }
}
