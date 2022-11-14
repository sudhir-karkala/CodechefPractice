package contests;

import java.util.Scanner;

/**
 * Chef has a rectangular plate of length N cm and width M cm. He wants to make a wireframe around the plate.
 * The wireframe costs X rupees per cm.
 * <p>
 * Determine the cost Chef needs to incur to buy the wireframe.
 * <p>
 * Input Format
 * First line will contain T, the number of test cases. Then the test cases follow.
 * Each test case consists of a single line of input, containing three space-separated integers N,M, and X — the length of the plate,
 * width of the plate, and the cost of frame per cm.
 * Output Format
 * For each test case, output in a single line, the price Chef needs to pay for the wireframe.
 * <p>
 * Constraints
 * 1<=T<=1000
 * 1<=N,M,X<=1000
 */
public class CWIREFRAME {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int x = scan.nextInt();
            System.out.println(2 * (n + m) * x);
        }
        scan.close();
    }
}
