public class Fibinacci {
    public static void main(String[] args){
        System.out.println(Fib(6));
    }

    public static long Fib(long index){  //arithmetic1
        long number = 0;
        long number0 = 0;
        long number1 = 1;
        for(long i = 2; i <= index; i++){
            number = number0 + number1;
            number0 = number1;
            number1 = number;
        }
        return number;
    }
}
