//package Contest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.TreeSet;

/**
 * Problem:  Babaei and Birthday Cake
 * problem Link: http://codeforces.com/contest/629/problem/D
 *
 * @author: Ashok Rajpurohit (ashok1113@gmail.com)
 */

public class C629D {

    private static PrintWriter out;
    private static InputStream in;
    private static int mod = 1000000009;

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        in = System.in;
        out = new PrintWriter(outputStream);
        C629D a = new C629D();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        InputReader in = new InputReader();
        int n = in.readInt();
        long[] r2h = new long[n];
        long[] sum = new long[n], last = new long[n];

        for (int i = 0; i < n; i++) {
            int r = in.readInt(), h = in.readInt();
            r2h[i] = 1L * r * r * h;
        }

        TreeSet<Cake> ts = new TreeSet<Cake>();
        ts.add(new Cake(r2h[0]));

        for (int i = 1; i < n; i++) {
            Cake cake = new Cake(r2h[i]);
            boolean yes = false;
            for (Cake c : ts) {
                if (c.max <= cake.max)
                    break;
                yes |= c.add(cake);
            }

            if (!yes)
                ts.add(cake);
        }

        out.println(Math.PI * ts.last().vol);
    }

    final static class Cake implements Comparable<Cake> {
        long vol, max;

        Cake(int r, int h) {
            vol = 1L * r * r * h;
            max = vol;
        }

        Cake(long r2h) {
            vol = r2h;
            max = r2h;
        }

        boolean add(Cake cake) {
            if (cake.max > this.max) {
                vol += cake.vol;
                max = cake.max;
                return true;
            }

            return false;
        }

        public int compareTo(Cake cake) {
            if (this.max == cake.max)
                return 0;

            if (this.max > cake.max)
                return 1;

            return -1;
        }
    }

    final static class InputReader {
        byte[] buffer = new byte[8192];
        int offset = 0;
        int bufferSize = 0;

        public int readInt() throws IOException {
            int number = 0;
            int s = 1;
            if (offset == bufferSize) {
                offset = 0;
                bufferSize = in.read(buffer);
            }
            if (bufferSize == -1)
                throw new IOException("No new bytes");
            for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
                if (buffer[offset] == '-')
                    s = -1;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            for (; offset < bufferSize && buffer[offset] > 0x2f; ++offset) {
                number = (number << 3) + (number << 1) + buffer[offset] - 0x30;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            ++offset;
            return number * s;
        }

        public int[] readIntArray(int n) throws IOException {
            int[] ar = new int[n];
            for (int i = 0; i < n; i++)
                ar[i] = readInt();

            return ar;
        }
    }
}
