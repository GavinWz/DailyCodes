public class Gcd{
    public static void main(String[] args){
        System.out.println(gcd(14, 35));    
    }

    public static int gcd(int x, int y){
        if(x % y == 0)
            return y;
        else
            return gcd(y, x % y);
    }
}