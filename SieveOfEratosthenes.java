package Concepts;
// https://www.geeksforgeeks.org/sieve-of-eratosthenes/
public class SieveOfEratosthenes {
/*
    * We create a boolean array
    * Indeces act as the number for which we have to know if it is prime or not.
    *
    * every index initially have default boolean value 'false'  and here false signifies the number is a prime number
    * we start from 2, if the choosen index (here starting from 2) is found to be having 'false' value that means it  is a prime numnber
    * therefore it's multiples can't be prime.
    * So we make another loop and for every index which is found to be the multiple of this number, we put the boolean value 'true' in it.
    *
    * We have to perform this thing only till the sqrt(n)  where n = the maximum number for which we have to check if it is a prime number or not
*/

    static boolean[] primes;
    public static void main(String[] args) {
        // implementing for 10^6 numbers
        primes = new boolean[1000000];

        for (int i = 2; i < 1000; i++) {
            if(!primes[i]) {

                for (int j = 2 * i; j < 1000000; j += i) {
                    primes[j] = true;
                }
            }
        }

        int n = 11;
        isPrime(n);

    }

    static void isPrime(int n) {
        if(!primes[n]) System.out.printf("yep :) \n", n);
        else System.out.printf("nope :( \n", n);
    }
}
