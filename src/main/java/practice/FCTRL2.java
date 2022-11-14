package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author sudhir on 25-10-2018
 */
class FCTRL2 {
    static int MAX_SIZE = 10000;

    static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return str;
        }
    }

    static int multiply(int[] res, int x, int resSize) {
        int carry = 0;
        int i = 0;
        for (i = 0; i < resSize; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }
        while (carry > 0) {
            res[i++] = carry % 10;
            ;
            carry = carry / 10;
            resSize = i;
        }
        return resSize;
    }

    static String fact(int n) {
        int[] res = new int[MAX_SIZE];
        int resSize = 1;
        res[0] = 1;
        for (int x = 2; x <= n; x++) {
            resSize = multiply(res, x, resSize);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = resSize - 1; i >= 0; i--) {
            builder.append(res[i]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        StringBuilder result = new StringBuilder();
        for (int c = 0; c < t; c++) {
            int n = fr.nextInt();
            result.append(fact(n));
            result.append(System.lineSeparator());
        }
        System.out.println(result);
    }
}
