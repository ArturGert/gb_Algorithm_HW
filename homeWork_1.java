package HomeWork;

public class homeWork_1 {
    public static void main(String[] args) {
        // Создаем массив
        int[] array = new int[]{
                3, 5, 8, 6, 4, 55, 6, 544, 565, 5, 9, 7, 5, 98
        };
        // Метод heapSort
        heapSort(array);
        // Метод, который выводит массив в консоль
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void heapSort(int[] array) {
        // Построение кучи (перегруппировка массива)
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, i, n);
        }
        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            heapify(array, 0, i);
        }
    }

    //
    public static void heapify(int[] array, int i, int n) {
        int l = 2 * i + 1; // инициализация левого элемента
        int r = 2 * i + 2; // инициализация правого элемента
        int largest = i; // инициализация наибольшего элемента, как корня
        // сравнение правого и левого элемента с корнем и замена если первые большне корня
        if (l < n && array[l] > array[largest]) {
            largest = l;
        }
        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        if (i != largest) { // Если самый большой элемент не корень, то свапаем (заменяем)
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            // Рекурсивно проходим по куче и преобразуем ее
            heapify(array, largest, n);
        }
    }
}

