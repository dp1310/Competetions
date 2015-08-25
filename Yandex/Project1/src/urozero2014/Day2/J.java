import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;
//package urozero2014.Day2;

/***************** Just Random **********************/

public class J {
    
    private static InputReader in;
    private static PrintWriter out;
    
    public J() {
        super();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);
        J j = new J();
        j.solve();
        out.close();
    }
    
    public void solve() {
        int t = in.nextInt();
        
        while(t>0) {
            t--;
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            int p = in.nextInt();
            int m = in.nextInt();
            
            int a1,b1,c1,d1;
            a1 = a;
            b1 = a;
            c1 = 0;
            d1 = 0;
            long count = 0;
            int var = m;
            
            while(var <= b + d) {
                
                var = var + p;
                c1 = var-b;
                d1 = var-a;
                if(c1>d)
                    break;
                
                c1 = c1 < c ? c : c1;
                d1 = d1 > d ? d : d1;
                
                int temp = (d1-c1) > (b-a) ? (d1-c1) : (b-a);
                if(temp > 0)
                    count = count + temp;
            }
            out.println(count);
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
