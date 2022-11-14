package contests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * You are given an array A of length N.
 * <p>
 * The interesting value of a subarray is defined as the product of the maximum and minimum elements of the subarray.
 * <p>
 * Find the minimum and maximum interesting value over all subarrays for the given array.
 * <p>
 * Note: A subarray is obtained by deletion of several (possibly zero) elements from the beginning of the array and
 * several (possibly zero) elements from the end of the array.
 * <p>
 * Input Format
 * The first line of input will contain a single integer T, denoting the number of test cases.
 * The first line of each test case contains an integer N - the length of the array A.
 * The second line of each test case contains NN space-separated integers A_1,A_2,..,A_N
 * Output Format
 * For each test case, output two space-separated integers on a new line the minimum and maximum interesting value
 * over all subarrays for the given array.
 * <p>
 * Constraints
 * 1 <= T <= 100
 * 1 <= N <= 10^5
 * -10^9 <= A_i <= 10^9
 * <p>
 * The sum of N over all test cases won't exceed 3 * 10^5
 */
public class SUBARRY {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scan.nextInt();
            List<Long> positiveNums = new ArrayList<>();
            List<Long> negativeNums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long num = scan.nextLong();
                if (num >= 0L) {
                    positiveNums.add(num);
                } else {
                    negativeNums.add(num);
                }
            }
            if (negativeNums.isEmpty()) {
                // we have only positive numbers.
                long minVal = Long.MAX_VALUE;
                long maxVal = Long.MIN_VALUE;
                int size = positiveNums.size();
                for (int j = 0; j < size; j++) {
                    if (minVal > positiveNums.get(j)) {
                        minVal = positiveNums.get(j);
                    }
                    if (maxVal < positiveNums.get(j)) {
                        maxVal = positiveNums.get(j);
                    }
                }
                System.out.println(minVal * minVal + " " + maxVal * maxVal);
            } else if (positiveNums.isEmpty()) {
                // we have only negative numbers.
                long minVal = Long.MAX_VALUE;
                long maxVal = Long.MIN_VALUE;
                int size = negativeNums.size();
                for (int j = 0; j < size; j++) {
                    if (minVal > negativeNums.get(j)) {
                        minVal = negativeNums.get(j);
                    }
                    if (maxVal < negativeNums.get(j)) {
                        maxVal = negativeNums.get(j);
                    }
                }
                // maxVal*maxVal becomes minimum positive number and minVal*minVal becomes maximum positive number
                System.out.println(maxVal * maxVal + " " + minVal * minVal);
            } else {
                // we have both positive and negative numbers in the input
                // minimum number will be (min in negative list * max in positive list)
                // maximum number will be max((min in negative list * min in negative list), (max in positive list * max in positive list))
                long minInNegList = Long.MAX_VALUE;
                long maxInPosList = Long.MIN_VALUE;
                int size = negativeNums.size();
                for (int j = 0; j < size; j++) {
                    if (minInNegList > negativeNums.get(j)) {
                        minInNegList = negativeNums.get(j);
                    }
                }
                size = positiveNums.size();
                for (int j = 0; j < size; j++) {
                    if (maxInPosList < positiveNums.get(j)) {
                        maxInPosList = positiveNums.get(j);
                    }
                }
                long resultantMinVal = minInNegList * maxInPosList;
                long resultantMaxVal = Math.max(minInNegList * minInNegList, maxInPosList * maxInPosList);
                System.out.println(resultantMinVal + " " + resultantMaxVal);
            }
        }
        scan.close();
    }
}
