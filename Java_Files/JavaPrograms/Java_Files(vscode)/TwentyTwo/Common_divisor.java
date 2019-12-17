public class Common_divisor{
    public static void main(String[] args){

    }

    public static int gcd(int m, int n){  //m is bigger
        if(m % n == n)
            return n;
        else
            return(gcd(n, m % n));
    }
}