package Algorithms.seminar2;

public class binarySearch {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,4,6,9,11,11,345};

        System.out.println(binarySearch(array,34,0,array.length-1));
    }

    public static int binarySearch (int[] array, int value, int min, int max){
        int midpoint;
        if (min>max){
            return -1;
        }
        else{
            midpoint=max-min/2+min;
        }
        if (value>array[midpoint]){
            return binarySearch(array, value, midpoint+1, max);
        }
        if (value<array[midpoint]){
            return binarySearch(array, value, min, midpoint-1);
        }
        else {
            return midpoint;
        }
    }
}
