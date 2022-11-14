package contests;

import java.util.Scanner;

/**
 * Bob has an account in the Bobby Bank. His current account balance is W rupees.
 * <p>
 * Each month, the office in which Bob works deposits a fixed amount of X rupees to his account.
 * Y rupees is deducted from Bob's account each month as bank charges.
 * <p>
 * Find his final account balance after Z months. Note that the account balance can be negative as well.
 * <p>
 * Input Format
 * The first line will contain T, the number of test cases. Then the test cases follow.
 * Each test case consists of a single line of input, containing four integers W,X,Y, and Z — the initial amount,
 * the amount deposited per month, the amount deducted per month, and the number of months.
 * Output Format
 * For each test case, output in a single line the final balance in Bob's account after Z months.
 * <p>
 * Constraints
 * 1<=T<=1000
 * 1<=W,X,Y,Z<=10^4
 */
public class BOBBANK {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int w = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            int total = w + x * z - y * z;
            System.out.println(total);
        }
        scan.close();
    }
}
