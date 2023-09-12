package HomeWork;

public class homeWork_1 {
    public static void main(String[] args) {
        int[] array = new int[]{
                3, 5, 8, 6, 4, 55, 6, 544, 565, 5, 9, 7, 5, 98
        };
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

    public static void heapSort(int[] array) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, i, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, 0, i);
        }
    }

    public static void heapify(int[] array, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int largest = i;
        if (l < n && array[l] > array[largest]) {
            largest = l;
            if (r < n && array[r] > array[largest]) {
                largest = r;
            }

            if (i != largest) {
                int temp = array[i];
                array[i] = array[largest];
                array[largest] = temp;

                heapify(array, largest, n);
            }
        }
    }

}
