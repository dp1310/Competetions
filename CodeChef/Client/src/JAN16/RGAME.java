package JAN16;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * Problem: Rupsa and the Game
 *
 * @author: Ashok Rajpurohit (ashok1113@gmail.com)
 */

class RGAME {

    private static PrintWriter out;
    private static InputStream in;
    private static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        in = System.in;
        out = new PrintWriter(outputStream);

        RGAME a = new RGAME();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        InputReader in = new InputReader();
        int t = in.readInt();

        while (t > 0) {
            t--;
            int n = in.readInt();
            out.println(process(in.readIntArray(n + 1)));
        }
    }

    private static long process(int[] ar) {
        if (ar.length == 2)
            return 2L * ar[0] * ar[1] % mod;

        int n = ar.length;
        long[] right = new long[n];
        long[] left = new long[n];

        left[0] = ar[0] << 1;
        long par = 2L;
        for (int i = 1; i < n; i++) {
            left[i] = (left[i - 1] + par * ar[i]) % mod;
            par = (par << 1);
            if (par > mod)
                par -= mod;
        }

        par = 1L;
        for (int i = n - 1; i >= 0; i--) {
            right[i] = par * ar[i] % mod;
            par = (par << 1);
            if (par > mod)
                par -= mod;
        }

        long res = 0;

        for (int i = 1; i < n; i++)
            res += (left[i - 1] * right[i] % mod);

        return res % mod;
    }

    final static class InputReader {
        byte[] buffer = new byte[8192];
        int offset = 0;
        int bufferSize = 0;

        public int readInt() throws IOException {
            int number = 0;
            if (offset == bufferSize) {
                offset = 0;
                bufferSize = in.read(buffer);
            }
            if (bufferSize == -1)
                throw new IOException("No new bytes");
            for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
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
            return number;
        }

        public int[] readIntArray(int n) throws IOException {
            int[] ar = new int[n];
            for (int i = 0; i < n; i++)
                ar[i] = readInt();

            return ar;
        }
    }
}
