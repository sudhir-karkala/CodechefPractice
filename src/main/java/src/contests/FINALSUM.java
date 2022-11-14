package contests;

import java.util.Scanner;

/**
 * Chef has an array A of length N. In one operation, Chef can:
 * <p>
 * Choose any subarray [L, R][L,R] (1<=L<=R<=N);
 * Add 1 to A_L, subtract 1 from A_{L+1}A, add 1 to A_{L+2} and so on, till A_R.
 * Chef performed Q such operations where the ith operation was performed on the subarray [L_i, R_i].
 * <p>
 * Determine the final sum of the array after these Q operations.
 * <p>
 * Note that a subarray is formed by deleting some (possibly zero) elements from the beginning and some (possibly zero) elements from the end of the array.
 * <p>
 * Input Format
 * The first line of input will contain a single integer T, denoting the number of test cases.
 * Each test case consists of multiple lines of input.
 * The first line of each test case contains two integers N, Q, number of elements and the number of queries.
 * The next line contains N space-separated integers A_1, A_2,...A_N denoting the array A.
 * The next Q lines contains two space-separated integers with ith line containing L_i, R_i.
 * <p>
 * Output Format
 * For each test case, output the final sum of the array after performing all the Q operations.
 * <p>
 * Constraints
 * 1 <= T <= 1000
 * 1 <= N, Q <= 3*10^5
 * 1 <= A_i <= 100
 * The sum of N over all test cases won't exceed 3* 10^5.
 * The sum of Q over all test cases won't exceed 3*10^5.
 */
public class FINALSUM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            // perform for each test case
            int N = scan.nextInt();
            int Q = scan.nextInt();
            int sum = 0;
            for (int i = 0; i < N; i++) {
                // perform summation of the array elements. Note that we don't need to store array elements
                // as we are interested only in the sum and not individual elements.
                sum += scan.nextInt();
            }

            for (int q = 0; q < Q; q++) {
                // read L and R for each query denoting the indices of sub-array
                int L = scan.nextInt();
                int R = scan.nextInt();
                // if number of elements in sub-array is odd, then we have to perform sum = sum + 1, else leave the sum as it is.
                // i.e. if R-L+1 is odd, then sum = sum + 1.
                // The logic is that, if the number of elements is even, then we will perform +1 and -1 equally which doesn't change the sum,
                // but if number of elements is odd, then sum gets incremented by 1.
                if ((R - L + 1) % 2 == 1) {
                    sum++;
                }
            }
            // output the sum after performing Q operations
            System.out.println(sum);
        }
        scan.close();
    }
}
