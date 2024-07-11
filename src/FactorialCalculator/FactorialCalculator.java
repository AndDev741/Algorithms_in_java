package FactorialCalculator;

public class FactorialCalculator {
    public static void main(String[] args){
        int result = factorialCalculator(-5);
        System.out.println(result);
    }

    public static int factorialCalculator(int number){
        if(number == 1) {
            return 1;
        }else {
            return number * factorialCalculator(number - 1);
        }
    }
}
