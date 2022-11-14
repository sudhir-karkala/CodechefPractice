package contests;

import java.util.*;

/**
 * You are given two N×M integer matrices A and B. You are allowed to perform the following operation on A as many times as you like (possibly, zero):
 * <p>
 * Pick any square submatrix of A and flip it about either its main diagonal or its antidiagonal.
 * For example, suppose you choose the submatrix
 * [
 * 123
 * 456
 * 789
 * ]
 * <p>
 * It can be converted into either
 * [
 * 147
 * 258
 * 369
 * ]
 * by flipping about the main diagonal, or
 * [
 * 963
 * 852
 * 741
 * ]
 * by flipping about the antidiagonal.
 * <p>
 * Is it possible to convert A to B by performing this operation several (possibly, zero) times?
 * <p>
 * A square submatrix is a submatrix with the same number of rows and columns.
 * <p>
 * Input Format
 * The first line of input will contain a single integer T, denoting the number of test cases.
 * Each test case consists of multiple lines of input.
 * The first line of each test case contains two space-separated integers NN and MM — the number of rows and columns of the matrices, respectively.
 * The next N lines describe the matrix A. The i-th of these lines contains M space-separated integers
 * The next N lines describe the matrix B. The i-th of these lines contains M space-separated integers
 * <p>
 * Output Format
 * For each test case, print YES if its possible to convert A to B, else print NO.
 * <p>
 * Each character of the output may be printed in either uppercase or lowercase. For example, the strings YES, yes, yeS, YeS will all be treated as identical.
 * <p>
 * Constraints
 * 1 <= T <= 10^4
 * 1 <= N,M <= 3 * 10^5
 * 1 <= A_ij, B_ij <= 10^9
 * The sum of N*M over all test cases won't exceed 3 * 10^5
 */
public class AFLIP {
    private static int[][] a;

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        StringBuilder builder = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[][] a = new int[n][m];
            int[][] b = new int[n][m];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    a[r][c] = scan.nextInt();
                }
            }
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    b[r][c] = scan.nextInt();
                }
            }

            if (n == 1 || m == 1) {
                if (a == b) {
                    builder.append("YES");
                } else {
                    builder.append("NO");
                }
                builder.append(System.lineSeparator());
                continue;
            }

            Map<Integer, Integer> whiteMap = new HashMap<>();
            Map<Integer, Integer> blackMap = new HashMap<>();

            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    // simulate chessboard where we have white and black boxes
                    // For matrix A, we keep incrementing counts of occurrence of a[r][c] in whiteMap and blackMap
                    if ((r + c) % 2 == 0) {
                        whiteMap.put(a[r][c], whiteMap.getOrDefault(a[r][c], 0) + 1);
                    } else {
                        blackMap.put(a[r][c], blackMap.getOrDefault(a[r][c], 0) + 1);
                    }
                }
            }
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    // simulate chessboard where we have white and black boxes
                    // For matrix B, we keep decrementing counts of occurrence of a[r][c] in whiteMap and blackMap
                    if ((r + c) % 2 == 0) {
                        whiteMap.put(b[r][c], whiteMap.getOrDefault(b[r][c], 0) - 1);
                    } else {
                        blackMap.put(b[r][c], blackMap.getOrDefault(b[r][c], 0) - 1);
                    }
                }
            }
            builder.append(isPossible(whiteMap) && isPossible(blackMap) ? "YES" : "NO");
            builder.append(System.lineSeparator());
        }
        System.out.println(builder);
        scan.close();
    }
    static boolean isPossible(Map<Integer, Integer> map) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                // means it is not possible to convert
                return false;
            }
        }
        return true;
    }
}
