package Algorithms.seminar1;

import java.util.ArrayList;
import java.util.List;

public class task2 {
    public static void main(String[] args) {
        System.out.println(GetPrimeNumbers(17));
    }

    public static List<Integer> GetPrimeNumbers(int n){
        List <Integer> result = new ArrayList<> ();
        for (int i = 1; i <= n; i++) {
            boolean PrimeNumber = isPrimeNumber(i);
            if (PrimeNumber) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isPrimeNumber(int i) {
        boolean PrimeNumber= true;
        for (int j = 2; j < i; j++) {
            if (i %j==0){
                PrimeNumber=false;
                break;
            }
        }
        return PrimeNumber;
    }
}
