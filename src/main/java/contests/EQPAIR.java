package contests;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You are given an array A of length N.
 * <p>
 * A pair (i, j) is said to be good if gcd(A_i, A_j) = lcm(A_i, A_j)
 * Here gcd denotes the greatest common divisor and lcm denotes least common multiple.
 * <p>
 * Find the total number of good pairs present in the given array.
 * <p>
 * Input Format
 * The first line of input will contain a single integer TT, denoting the number of test cases.
 * The first line of each test case contains an integer NN - the length of the array AA.
 * The second line of each test case contains NN space-separated integers A_1,A_2,...,A_N
 * Output Format
 * For each test case, output on a new line the total number of such good pairs possible in the given array.
 * <p>
 * Constraints
 * 1<=T<=100
 * 1<=N<=10^5
 * 1 <= A_i <= 10^9
 * <p>
 * The sum of N over all test cases won't exceed 3*10^5
 */
public class EQPAIR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scan.nextInt();
            Map<Long, Long> freqMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                long num = scan.nextLong();
                freqMap.put(num, freqMap.getOrDefault(num, 0L) + 1L);
            }
            // gcd = lcm can happen only when two numbers considered are equal, i.e. if (gcd(a,b) = lcm(a,b) then a=b.
            // Hence, we can maintain freqMap of array elements and use nC2 formula i.e. n*(n-1)/2 as count of pairs(n=frequency)
            long count = 0;
            for (Long key : freqMap.keySet()) {
                long value = freqMap.get(key);
                count += value * (value - 1) / 2;
            }
            System.out.println(count);
        }
        scan.close();
    }
}
