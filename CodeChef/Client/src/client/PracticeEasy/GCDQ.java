import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class GCDQ {

    private static InputReader in;
    private static PrintWriter out;

    public GCDQ() {
        super();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);
        GCDQ a = new GCDQ();
        a.solve();
        out.close();
    }

    public void solve() {
        int t = in.nextInt();
        StringBuilder sb = new StringBuilder();

        while (t > 0) {
            t--;
            int n = in.nextInt();
            int q = in.nextInt();
            int[] ar = new int[n];
            int[] lg = new int[n];
            int[] rg = new int[n];
            
            for(int i=0; i < n; i++)
                ar[i] = in.nextInt();
            
            lg[0] = ar[0];
            for(int i=1; i<n; i++)
                lg[i] = gcd(lg[i-1],ar[i]);
            
            rg[n-1] = ar[n-1];
            for(int i=n-2; i>=0; i--)
                rg[i] = gcd(rg[i+1],ar[i]);
            
            while(q>0) {
                q--;
                int l = in.nextInt();
                int r = in.nextInt();
                if(l==1) {
                    sb.append(rg[r]).append("\n");
                } else if(r==n)
                    sb.append(lg[l-2]).append("\n");
                else {
                    sb.append(gcd(lg[l-2],rg[r])).append("\n");
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
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
