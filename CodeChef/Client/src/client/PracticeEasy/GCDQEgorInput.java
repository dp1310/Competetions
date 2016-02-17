import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class GCDQEgorInput {

    private static InputReader in;
    private static PrintWriter out;

    public GCDQEgorInput() {
        super();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);
        GCDQEgorInput a = new GCDQEgorInput();
        a.solve();
        out.close();
    }

    public void solve() {
        int t = in.readInt();
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            t--;
            int n = in.readInt();
            int q = in.readInt();
            int[] ar = new int[n];
            int[] lg = new int[n];
            int[] rg = new int[n];

            for (int i = 0; i < n; i++)
                ar[i] = in.readInt();

            lg[0] = ar[0];
            for (int i = 1; i < n; i++)
                lg[i] = gcd(lg[i - 1], ar[i]);

            rg[n - 1] = ar[n - 1];
            for (int i = n - 2; i >= 0; i--)
                rg[i] = gcd(rg[i + 1], ar[i]);

            while (q > 0) {
                q--;
                int l = in.readInt();
                int r = in.readInt();
                if (l == 1) {
                    sb.append(rg[r]).append("\n");
                } else if (r == n)
                    sb.append(lg[l - 2]).append("\n");
                else {
                    sb.append(gcd(lg[l - 2], rg[r])).append("\n");
                }
            }
        }
        out.println(sb);
    }

    private static int gcd(int i, int j) {

        if (i == 0)
            return j;

        if (j == 0)
            return i;

        if (i == 1)
            return 1;

        if (j == 1)
            return 1;

        int res = 0;

        while (((i | j) & 1) == 0) {
            res++;
            i = i >> 1;
            j = j >> 1;
        }

        while ((i & 1) == 0)
            i = i >> 1;

        while ((j & 1) == 0)
            j = j >> 1;

        while ((i ^ j) != 0) {
            if (i > j) {
                i = i - j;
                while ((i & 1) == 0)
                    i = i >> 1;
            }
            if (j > i) {
                j = j - i;
                while ((j & 1) == 0)
                    j = j >> 1;
            }
        }

        return i << res;
    }

    final static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public char readCharacter() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char)c;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
