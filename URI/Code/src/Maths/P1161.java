import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author: Ashok Rajpurohit (ashok1113@gmail.com)
 *  problem Name: Factorial Sum
 *  Link:   https://www.urionlinejudge.com.br/judge/en/problems/view/1161
 */

public class P1161 {

    private static PrintWriter out;
    private static InputStream in;
    private static long[] fact;

    static {
        fact = new long[21];
        fact[0] = 1;
        for (int i = 1; i < 21; i++)
            fact[i] = fact[i - 1] * i;
    }

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        in = System.in;
        out = new PrintWriter(outputStream);

        P1161 a = new P1161();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        InputReader in = new InputReader();

        try {
            while (true) {
                out.println(fact[in.readInt()] + fact[in.readInt()]);
            }
        } catch (IOException ioe) {
            return;
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
    }
}
