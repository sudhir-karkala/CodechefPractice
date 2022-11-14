package contests;

import java.util.Scanner;

/**
 * You are given four integers a, b, c and d. Determine if there's a rectangle such that the lengths of its sides are a, b, c and d (in any order).
 * <p>
 * Input
 * The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
 * The first and only line of each test case contains four space-separated integers a, b, c and d.
 * Output
 * For each test case, print a single line containing one string "YES" or "NO".
 * <p>
 * Constraints
 * 1 <= T <= 1,000
 * 1 <= a, b, c, d <= 10,000
 */
public class RECTANGL {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = scan.nextInt();
            if ((a == b && c == d) || (a == c && b == d) || (a == d && b == c)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scan.close();
    }
}
