import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class D {
    
    private static InputReader in;
    private static PrintWriter out;
    
    public D() {
        super();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);
        D a = new D();
        a.solve();
        out.close();
    }
    
    public void solve() {
        int n = in.nextInt();
        double p = Double.parseDouble(in.next());
        double pd = 1-p;
        int t = in.nextInt();
        
        double p1, p2;
        if(n>=t) {
            double N = Math.pow(p, n+1) - Math.pow(pd,n+1);
            double D = p - pd;
            double r = N/D;
            out.println(r);
            return;
        }
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
