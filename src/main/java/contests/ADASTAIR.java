package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author sudhir on 25-10-2018
 */
class ADASTAIR {
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

        public Integer nextInt() {
            return Integer.parseInt(next());
        }

        public Long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public void close() {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int t = fr.nextInt();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < t; i++) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = fr.nextInt();
            }
            int steps = 0;
            for (int j = 1; j < n; j++) {
                if ((a[j] - a[j - 1]) > k) {
                    int s = (a[j] - a[j - 1]) / k;
                    if ((a[j] - a[j - 1]) % k == 0) {
                        steps += s - 1;
                    } else {
                        steps += s;
                    }
                }
            }
            if (a[0] > k) {
                if (a[0] % k == 0) {
                    steps += (a[0] / k) - 1;
                } else {
                    steps += a[0] / k;
                }
            }
            buffer.append(steps);
            buffer.append(System.lineSeparator());
        }
        System.out.println(buffer);
    }
}
