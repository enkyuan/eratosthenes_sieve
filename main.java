// TODO: check if line 41 is valid according to the grader's specifications
    
/*
 * Name:    Enkang Yuan
 * Sect.:   CS 3345.503
 * Desc.:   This program takes an integer N > 1 and prints all prime numbers from 2 to N.
 *
 */

// import statements
import static java.lang.System.out;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        // scanner object to read input
        Scanner io = new Scanner(System.in);
        
        // prompts user to enter a positive integer greater than 1
        out.print("Enter a positive integer greater than 1: ");
        int N = io.nextInt();
        
        // checks if input is correct (greater than 1); if not, user is prompted until it is valid
        while (!(N >= 1)) {
            out.print("Enter a positive integer greater 1: ");
            N = io.nextInt();
        }

        // creates a boolean array of size N + 1 & fills it with true
        boolean[] A = new boolean[N + 1];
        Arrays.fill(A, true);
        
        // checks if numbers are prime or not using the sieve algorithm
        for(int i = 2; i <= Math.sqrt(N); i++) {
           if (A[i] == true) {
               for(int j = i * i; j <= N; j += i) {
                   A[j] = false;
               }
           }
        }
        
        // output of the prime numbers from 2 to N using java intstream
        out.println();
        out.println("From 2 to " + N + " the prime numbers are " + String.join(", ", IntStream.range(2, A.length).filter(i -> A[i]).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}

