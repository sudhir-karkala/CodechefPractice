package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author sudhir on 25-10-2018
 */
class KOL15A {
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
            String s = fr.nextLine();
            int len = s.length();
            int sum = 0;
            for (int l = 0; l < len; l++) {
                if (s.charAt(l) >= '0' && s.charAt(l) <= '9') {
                    sum += Integer.parseInt(String.valueOf(s.charAt(l)));
                }
            }


            buffer.append(sum);
            buffer.append(System.lineSeparator());
        }
        System.out.println(buffer);
        fr.close();
    }
}

