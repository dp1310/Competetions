import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author  Ashok Rajpurohit
 * ********************** Restore Calculation ***********************
 */
public class B {

    private static PrintWriter out;
    private static InputStream in;
    private static String a, b, c;
    private static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        in = System.in;
        out = new PrintWriter(outputStream);
        B a = new B();
        a.solve();
        out.close();
    }

    public void solve() throws IOException {
        InputReader in = new InputReader();
        StringBuilder sb = new StringBuilder();
        a = in.read();
        b = in.read();
        c = in.read();

        sb.append(solve(0, 0));

        out.print(sb);
    }

    private static long solve(int index, int carry) {
        if (index == a.length()) {
            if (carry == 0)
                return 1;
            return 0;
        }
        char x, y, z;
        int ix, iy, iz;
        long res0, res1;
        x = a.charAt(index);
        y = b.charAt(index);
        z = c.charAt(index);

        if (z == '?') {
            if (index == 0) {
                if (x == '?' && y == '?') {
                    res0 = 36 * solve(1, 0);
                    res1 = 28 * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else if (x == '?') {
                    iy = y - '0';
                    res0 = (9 - iy) * solve(1, 0);
                    res1 = (8 - iy) * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else if (y == '?') {
                    ix = x - '0';
                    res0 = (9 - ix) * solve(1, 0);
                    res1 = (8 - ix) * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else {
                    ix = x - '0';
                    iy = y - '0';
                    if (ix + iy == 9)
                        return solve(1, 0);
                    else {
                        res0 = solve(1, 0);
                        res1 = solve(1, 1);
                        res0 = res0 + res1;
                        res0 = res0 % mod;
                        return res0;
                    }
                }
            } else if (carry == 0) {
                if (x == '?' && y == '?') {
                    res0 = 45 * solve(1, 0);
                    res1 = 36 * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else if (x == '?') {
                    iy = y - '0';
                    res0 = (9 - iy) * solve(1, 0);
                    res1 = (8 - iy) * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else if (y == '?') {
                    ix = x - '0';
                    res0 = (9 - ix) * solve(1, 0);
                    res1 = (8 - ix) * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else {
                    ix = x - '0';
                    iy = y - '0';
                    if (ix + iy > 9)
                        return 0;
                    else if (ix + iy == 9)
                        return solve(1, 0);
                    else {
                        res0 = solve(1, 0);
                        res1 = solve(1, 1);
                        res0 = res0 + res1;
                        res0 = res0 % mod;
                        return res0;
                    }
                }
            } else {
                if (x == '?' && y == '?') {
                    res0 = 45 * solve(1, 0);
                    res1 = 55 * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else if (x == '?') {
                    iy = y - '0';
                    res0 = iy * solve(1, 0);
                    res1 = (1 + iy) * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else if (y == '?') {
                    ix = x - '0';
                    res0 = ix * solve(1, 0);
                    res1 = (1 + ix) * solve(1, 1);
                    res0 = res0 + res1;
                    res0 = res0 % mod;
                    return res0;
                } else {
                    ix = x - '0';
                    iy = y - '0';
                    if (ix + iy < 9)
                        return 0;
                    else if (ix + iy == 9)
                        return solve(1, 1);
                    else {
                        res0 = solve(1, 0);
                        res1 = solve(1, 1);
                        res0 = res0 + res1;
                        res0 = res0 % mod;
                        return res0;
                    }
                }
            }
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

        public long readLong() throws IOException {
            long res = 0;
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
                res = (res << 3) + (res << 1) + buffer[offset] - 0x30;
                if (offset == bufferSize - 1) {
                    offset = -1;
                    bufferSize = in.read(buffer);
                }
            }
            ++offset;
            if (s == -1)
                res = -res;
            return res;
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
