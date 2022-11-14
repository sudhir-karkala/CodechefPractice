package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Chef has an array A of length N and an integer X.
 * <p>
 * In one operation, Chef does the following:
 * <p>
 * Find the smallest element in the current array. Let this be S.
 * Next, pick any one index i such that A_i = S
 * Finally, replace A_i with A_i XOR X
 * <p>
 * For example, if A = [1, 1, 2] and X = 4, then in one move Chef can turn the array into either [5, 1, 2] or [1, 5, 2].
 * <p>
 * Chef performs this operation exactly Y times. Let BB be final array obtained.
 * <p>
 * Output the array BB in sorted order. Note that under this restriction, the output is unique.
 * <p>
 * Input Format
 * The first line of input will contain a single integer T, denoting the number of test cases.
 * Each test case consists of two lines of input.
 * The first line of each test case contains three space-separated integers N, X, and Y.
 * The second line contains N space-separated integers denoting the array A.
 * Output Format
 * For each test case, output array B in sorted order.
 * <p>
 * Constraints
 * 1 <= T <= 10^4
 * 1 <= N <= 10^5
 * 1 <= Y <= 10^9
 * 1 <= A_i, X <= 2^30
 * The sum of N over all test cases won't exceed 10^5
 */
public class SMALLXOR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder builder = new StringBuilder();
        for (int t = 0; t < T; t++) {
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            String[] parts = br.readLine().split(" ");
            int n = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);
            int y = Integer.parseInt(parts[2]);
            parts = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                queue.add(Integer.parseInt(parts[i]));
            }
            int remainingY = 0;
            int ele = queue.peek();
            for (int j = 1; j <= y; j++) {
                // if m^x < m, then m^x^x = m. So it alternates between m and a value < m which is (m^x). Here, m is the smallest value in the array
                ele = queue.peek();
                if ((ele ^ x) < ele) {
                    remainingY = y - j;
                    queue.remove();
                    queue.offer(ele ^ x);
                    break;
                } else {
                    queue.remove();
                    queue.offer(ele ^ x);
                }
            }
            if (remainingY > 0) {
                if (remainingY % 2 == 0) {
                    queue.remove();
                    queue.offer(ele ^ x);
                } else {
                    queue.remove();
                    queue.offer(ele);
                }
            }
            while (!queue.isEmpty()) {
                builder.append(queue.remove()).append(" ");
            }
            builder.append(System.lineSeparator());
        }
        System.out.println(builder);
        br.close();
    }
}
