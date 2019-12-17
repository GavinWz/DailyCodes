public class Prime{

    public static void main(String[] args){
        prime(1000);
    }

    public static void prime(int n){
        boolean isPrime;
        int count = 0;
        int number = 2;
        while(number <= n ){
            isPrime = true;
            for(int i = 2; i <= Math.sqrt(number); i++){
                if(number % i == 0){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                count++;
                System.out.printf("%-7d ", number);
                if(count % 10 == 0)
                    System.out.println();
            }
            
            number++;
        }
    }
}   