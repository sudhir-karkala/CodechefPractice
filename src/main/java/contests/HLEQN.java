package contests;

import java.util.Scanner;

/**
 * You are given a positive integer X. Your task is to tell whether there exist two positive integers a and b
 * such that 2?a+2?b+a?b=X
 * If there exist positive integers a and b satisfying the above condition print YES, otherwise print NO.
 * <p>
 * Input Format
 * The first line of input will contain a single integer T, denoting the number of test cases.
 * Each test case consists of single line containing a positive integer X.
 * Output Format
 * For each test case, output on a new line YES or NO.
 * <p>
 * You may print each character of the string in either uppercase or lowercase (for example, the strings yes, YES, Yes,
 * and yeS will all be treated as identical).
 * <p>
 * Constraints
 * 1<=T<=100
 * 1<=X<=10^9
 */
public class HLEQN {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int x = scan.nextInt();
            // consider the given equation: 2a + 2b + ab = x. we can observe that ab <= x. Then min(a,b) <= sqrt(x).
            // now, let min(a,b) = b. we can assign values from 1 to sqrt(x) to b, then (x-2b) % (b+2) = 0 should hold.
            // Then we can say (a,b) which is considered satisfies the equation.
            int b = (int) Math.sqrt(x);
            boolean exists = false;
            for (int i = b; i > 0; i--) {
                if ((x - 2 * i) > 0 && (x - 2 * i) % (i + 2) == 0) {
                    System.out.println("YES");
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                System.out.println("NO");
            }
        }
        scan.close();
    }
}
