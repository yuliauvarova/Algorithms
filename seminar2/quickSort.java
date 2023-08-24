package Algorithms.seminar2;

import java.util.Date;
import java.util.Random;
public class quickSort {
    public static void main(String[] args) {
        int size = 100;
        int min = 0;
        int max = 100;
        int[] array = bubbleSort.getRandomArr(size, min, max);
        bubbleSort.printArr(array);


        long start = new Date().getTime();
        System.out.println(start);

        quickSort(array);
        bubbleSort.printArr(array);
        long end = new Date().getTime();
        //System.out.println(start);
        //System.out.println(end);
        System.out.println(new Date().getTime() - start);
        long start1 = new Date().getTime();
        System.out.println(start1);
        bubbleSort.bubbleSort(array.clone());
        bubbleSort.printArr(array);
        System.out.println(new Date().getTime() - start1);

        //end = new Date().getTime();
        //System.out.println(start);
        //System.out.println(end);
       //System.out.println(end - start);

    }

    /**
     * @param array - исходный массив
     * @apiNote Перегрузка метода быстрой сортировки
     */
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * @param array         - исходный массив
     * @param startPosition - начало массива
     * @param endPosition   - конец массива
     * @apiNote Метод реализующий быструю сортировку, принимающий на вход три  аргумента
     */
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int pivot = array[(startPosition + endPosition) / 2];
        int i = startPosition, j = endPosition;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (i < j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;
            }
        }
        if (i < endPosition) {
            quickSort(array, i, endPosition);
        }
        if (j > startPosition) {
            quickSort(array, startPosition, j);
        }
    }
}
