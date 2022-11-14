package contests;

import java.util.Scanner;

/**
 * Alice is driving from her home to her office which is A kilometers away and will take her X hours to reach.
 * Bob is driving from his home to his office which is B kilometers away and will take him Y hours to reach.
 * <p>
 * Determine who is driving faster, else, if they are both driving at the same speed print EQUAL.
 * <p>
 * Input Format
 * The first line will contain T, the number of test cases. Then the test cases follow.
 * Each test case consists of a single line of input, containing four integers A,X,B, and Y, the distances
 * and the times taken by Alice and Bob respectively.
 * Output Format
 * For each test case, if Alice is faster, print ALICE. Else if Bob is faster, print BOB. If both are equal, print EQUAL.
 * <p>
 * You may print each character of the string in uppercase or lowercase (for example, the strings equal, equAL, EquAl, and EQUAL will all be treated as identical).
 * <p>
 * Constraints
 * 1<=T<=1000
 * 1<=A,X,B,Y<=1000
 */
public class SPEEDTEST {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int a = scan.nextInt();
            int x = scan.nextInt();
            int b = scan.nextInt();
            int y = scan.nextInt();
            double speedOfA = (double) a / x;
            double speedOfB = (double) b / y;
            int result = Double.compare(speedOfA, speedOfB);
            if (result == 0) {
                System.out.println("EQUAL");
            } else if (result < 0) {
                System.out.println("BOB");
            } else {
                System.out.println("ALICE");
            }
        }
        scan.close();
    }
}
