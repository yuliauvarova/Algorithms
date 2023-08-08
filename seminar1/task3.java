package Algorithms.seminar1;

// Поиск числа Фибоначчи по его позиции

public class task3 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(5));
    }

    public static int Fibonacci(int position){
        if (position==0 || position==1){
            return 1;
        }
        return Fibonacci(position-1) + Fibonacci(position-2);
    }
}
