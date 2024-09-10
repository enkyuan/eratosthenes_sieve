// TODO: reformat the output to display the prime numbers in a single line 
// TODO: document the code (almost every line)
// TODO: modify the README to include description, Java version, and sample output

/*
 *
 *
 *
 */

import static java.lang.System.out;
import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.IntStream;

public class main {
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        
        out.print("Enter a positive integer greater than 1: ");
        int N = io.nextInt();

        while (!(N >= 1)) {
            out.print("Enter a positive integer greater 1: ");
            N = io.nextInt();
        }

        boolean[] A = new boolean[N + 1];
        Arrays.fill(A, true);

        for(int i = 2; i <= Math.sqrt(N); i++) {
           if (A[i] == true) {
               for(int j = i * i; j <= N; j += i) {
                   A[j] = false;
               }
           }
        }
        
        out.println();
        out.println("From 2 to " + N + " the prime numbers are " + String.join(", ", IntStream.range(2, A.length).filter(i -> A[i]).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}

