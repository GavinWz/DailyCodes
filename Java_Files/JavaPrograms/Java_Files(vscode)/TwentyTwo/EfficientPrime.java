import java.util.ArrayList;
import java.util.IllegalFormatPrecisionException;
import java.util.Scanner;

public class EfficientPrime{
    public static void main(String[] args){
        ArrayList<Integer> primes = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean isPrime;
        int number = 2;
        int count = 0;
        int n = in.nextInt();
        int squareRoot = 1;
        while(number <= n){
            isPrime = true;
            if(squareRoot * squareRoot < number)
                squareRoot++;
            for(int i = 0; i < primes.size() && primes.get(i) <= squareRoot ; i++){
                if(number % primes.get(i) == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.add(number);
                count++;
                System.out.printf("%-7d ", number);
                if(count % 10 == 0)
                    System.out.println();
            }
            number++;
        }
    }
}