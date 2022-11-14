package contests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <p>
 * For her next karate demonstration, Ada will break some bricks.
 * </p>
 * <p>
 * Ada stacked three bricks on top of each other. Initially, their widths (from top to bottom) are W1,W2,W3.
 * </p>
 * <p>
 * Ada's strength is S. Whenever she hits a stack of bricks, consider the largest k?0 such that
 * the sum of widths of the topmost k bricks does not exceed S; the topmost k bricks break and are removed from the stack.
 * Before each hit, Ada may also decide to reverse the current stack of bricks, with no cost.
 * Find the minimum number of hits Ada needs in order to break all bricks if she performs the reversals optimally.
 * You are not required to minimise the number of reversals.
 * </p>
 *
 * @author sudhir on 05-Jan-2020
 */
public class BRKBKS {
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

    static int minimumHits(int s, int[] w) {
        int hits = 0;
        int i = 0;
        int sum = 0;
        while (i < 3) {
            while (i < 3 && (sum + w[i]) <= s) {
                sum += w[i];
                i++;
            }
            if (sum <= s) {
                hits++;
                sum = 0;
            }
        }
        return hits;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int T = fr.nextInt();
        for (int t = 0; t < T; t++) {
            int s = fr.nextInt();
            int[] w = new int[3];
            w[0] = fr.nextInt();
            w[1] = fr.nextInt();
            w[2] = fr.nextInt();
            int hits = minimumHits(s, w);
            System.out.println(hits);
        }
        fr.close();
    }
}
