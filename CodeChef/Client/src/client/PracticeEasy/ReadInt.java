import java.io.BufferedReader;

import static java.lang.System.in;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class ReadInt {

    //    private static NewInputReader in;
    private static PrintWriter out;

    public ReadInt() {
        super();
    }

    public static void main(String[] args) throws IOException {
        //        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        //        NewInputReader in = new NewInputReader();
        out = new PrintWriter(outputStream);
        ReadInt a = new ReadInt();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        NewInputReader in = new NewInputReader();
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

    final static class NewInputReader {
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
            for (; buffer[offset] < 0x30 || buffer[offset] == '-'; ++offset) {
                if (buffer[offset] == '-')
                    s = -1;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            for (; offset < bufferSize && buffer[offset] > 0x2f; ++offset) {
                number = number * 0x0a + buffer[offset] - 0x30;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            ++offset;
            return number * s;
        }
    }
}
