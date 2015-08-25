import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author: Ashok Rajpurohit
 * problem: GCDQ
 * http://www.codechef.com/problems/GCDQ
 */

public class GCDQ {

    private static PrintWriter out;
    private static InputStream in;

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        in = System.in;
        out = new PrintWriter(outputStream);
        GCDQ a = new GCDQ();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        InputReader in = new InputReader();
        int t = in.readInt();

        while (t > 0) {
            t--;
            int n = in.readInt();
            int q = in.readInt();
            StringBuilder sb = new StringBuilder(q << 3);
            int[] ar = in.readIntArray(n);
            int[] lg = new int[n];
            int[] rg = new int[n];

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
                } else if (r == n) {
                    sb.append(lg[l - 2]).append("\n");
                } else {
                    sb.append(gcd(lg[l - 2], rg[r])).append("\n");
                }
            }
            out.print(sb);
        }
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
            i = i >>> 1;
            j = j >>> 1;
        }

        while ((i & 1) == 0)
            i = i >>> 1;

        while ((j & 1) == 0)
            j = j >>> 1;

        while (i != j) {
            if (i > j) {
                i = i - j;
                while ((i & 1) == 0)
                    i = i >>> 1;
            }
            if (j > i) {
                j = j - i;
                while ((j & 1) == 0)
                    j = j >>> 1;
            }
        }

        return i << res;
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
