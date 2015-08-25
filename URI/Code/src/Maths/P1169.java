import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.math.BigInteger;

/**
 * @author: Ashok Rajpurohit (ashok1113@gmail.com)
 * problem: Grains in a Chess Board
 * Link:    https://www.urionlinejudge.com.br/judge/en/problems/view/1169
 */

public class P1169 {

    private static PrintWriter out;
    private static InputStream in;
    //    private static BigInteger n12 = new BigInteger("12000");
    //    private static String[] ar = new String[65];
    //
    //    static {
    //        StringBuilder sb = new StringBuilder(64);
    //        for (int i = 1; i < 65; i++) {
    //            sb.append('1');
    //            ar[i] = sb.toString();
    //        }
    //    }

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        in = System.in;
        out = new PrintWriter(outputStream);

        P1169 a = new P1169();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        InputReader in = new InputReader();
        int t = in.readInt();

        while (t > 0) {
            t--;
            getkg(in.readInt());
            //            solve(in.readInt());
        }
    }

    private static void getkg(int n) {
        n = n > 5 ? n - 5 : 0;
        if (n == 0) {
            out.println("0 kg");
            return;
        }

        long res = ((1L) << n) - 1;
        out.println((res / 375) + " kg");
    }

    //    private static void solve(int n) {
    //        BigInteger b = new BigInteger(ar[n], 2);
    //        out.println(b.divide(n12) + " kg");
    //    }

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

        public String read() throws IOException {
            StringBuilder sb = new StringBuilder();
            if (offset == bufferSize) {
                offset = 0;
                bufferSize = in.read(buffer);
            }

            if (bufferSize == -1 || bufferSize == 0)
                throw new IOException("No new bytes");

            for (;
                 buffer[offset] == ' ' || buffer[offset] == '\t' || buffer[offset] ==
                 '\n' || buffer[offset] == '\r'; ++offset) {
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            for (; offset < bufferSize; ++offset) {
                if (buffer[offset] == ' ' || buffer[offset] == '\t' ||
                    buffer[offset] == '\n' || buffer[offset] == '\r')
                    break;
                if (Character.isValidCodePoint(buffer[offset])) {
                    sb.appendCodePoint(buffer[offset]);
                }
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            return sb.toString();
        }
    }
}
