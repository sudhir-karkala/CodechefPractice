package contests;

import java.util.Scanner;

/**
 * Chef has N bags and an integer X. The ith bag contains A_i coins such that A_i <= X
 * <p>
 * In one operation, Chef can:
 * <p>
 * Pick any bag and increase its coins to X. Formally, if he choses the ith bag, he can set A_i = X.
 * Given that the cost of performing each operation is C <= X coins and Chef can perform the above operation any (possibly zero) number of times, determine the maximum value of:
 * summation(A_i)-total cost paid by Chef, if Chef performs the operations optimally.
 * <p>
 * Input Format
 * The first line of input will contain a single integer T, denoting the number of test cases.
 * Each test case consists of multiple lines of input.
 * The first line of each test case contains three space-separated integers N, X, and C — the number of bags, maximum limit of coins on each bag and cost of each operation respectively.
 * The next line contains N space-separated integers A_1, A_2, ..., A_N denoting the number of coins in each bag.
 * <p>
 * Output Format
 * For each test case, output the maximum value of summation(A_i)-total cost paid by Chef.
 * <p>
 * Constraints
 * 1 <= T <= 1000
 * 1 <= N <= 100
 * 1 <= C <= X <= 100
 * 1 <= A_i <= X
 */
public class MAKEMONEY {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scan.nextInt();
            int x = scan.nextInt();
            int c = scan.nextInt();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = scan.nextInt();
                if (x - num - c > 0) {
                    // if by increasing coins from num to x using cost of c, we can maximize the overall summation, we will do it,
                    // else we won't increase coins from num to x.
                    sum += x - c;
                } else {
                    sum += num;
                }
            }
            System.out.println(sum);
        }
        scan.close();
    }
}
