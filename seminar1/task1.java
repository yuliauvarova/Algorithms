package Algorithms.seminar1;

public class task1 {
    public static void main(String[] args) {
        System.out.println(FindSum(4));
    }

    public static int FindSum(int n){
        int sum=0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        return sum;
    }

}

