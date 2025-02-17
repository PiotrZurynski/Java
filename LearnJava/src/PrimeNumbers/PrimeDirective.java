package PrimeNumbers;

import java.util.ArrayList;
class PrimeDirective {

    // Add your methods here:
    public static boolean isPrime(int number){
        if(number==2){
            return true;
        }
        if(number<2){
            return false;
        }
        for(int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        PrimeDirective pd = new PrimeDirective();
        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
        System.out.println(isPrime(4));
        for(int i=0;i<numbers.length;i++){
            if(isPrime(numbers[i])==true){
                System.out.println(numbers[i]);
            }
        }

    }

}

