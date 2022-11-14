package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author sudhir on 25-10-2018
 */
class QUALPREL {
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
            Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            Integer[] a = new Integer[n];
            for (int c = 0; c < n; c++) {
                int num = fr.nextInt();
                if (map.containsKey(num)) {
                    map.put(num, map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
                a[c] = num;
            }
            Arrays.sort(a, Collections.reverseOrder());
            int prev = -1;
            for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                if (prev == -1) {
                    prev = m.getValue();
                } else {
                    m.setValue(m.getValue() + prev);
                    prev = m.getValue();
                }
            }


            buffer.append(map.get(a[k - 1]));
            buffer.append(System.lineSeparator());
        }
        System.out.println(buffer);
        fr.close();
    }

}
