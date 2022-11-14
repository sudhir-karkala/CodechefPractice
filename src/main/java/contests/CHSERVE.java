package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author sudhir on 25-10-2018
 */
class CHSERVE {
    static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            // TODO Auto-generated constructor stub
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
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

        public void close() {
            try {
                reader.close();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int cases = fr.nextInt();

        StringBuffer buffer = new StringBuffer();
        for (int c = 0; c < cases; c++) {
            int p1 = fr.nextInt();
            int p2 = fr.nextInt();
            int k = fr.nextInt();
            int sum = p1 + p2;
            if ((sum / k) % 2 == 0) {
                buffer.append("CHEF");
            } else {
                buffer.append("COOK");
            }
            buffer.append(System.lineSeparator());
        }
        System.out.println(buffer);
        fr.close();
    }
}
