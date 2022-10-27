package Concepts;

public class GCD_LCM {
    public static void main(String[] args) {
        System.out.println(gcd(2,8));
        System.out.println(lcm(8,2));
    }

/*
    gcd : maximum number which divides both a and b.
    => gcd(a,b) <= min(a,b)
*/
    static int gcd(int a, int b) {         // Euclidean Algorithm
        if(a == 0) return b;
        return gcd(b % a, a);
    }


/*
    lcm : smallest number that is divisible by both a and b
    => lcm(a,b) >= max(a,b)
*/
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
