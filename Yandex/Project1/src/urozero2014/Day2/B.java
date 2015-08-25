import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.text.DecimalFormat;

import java.util.StringTokenizer;
//package urozero2014.Day2;
/***************** Hard Disk Drive *************/

public class B {
    
    private static InputReader in;
    private static PrintWriter out;
    
    public B() {
        super();
    }

    public static void main(String[] args) {
        
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        in = new InputReader(inputStream);
        out = new PrintWriter(outputStream);
        B b = new B();
        b.solve();
        out.close();
    }
    
    public void solve() {
        int t = in.nextInt();
        
        for(int j=1; j<=t; j++) {
            out.print("Case #" + j + ": ");
            String s = in.next();
            int num = 0;
            
            int ind = s.indexOf('[');
            if(ind==0) {
                num = 0;
            } else
                num = Integer.parseInt(s.substring(0, ind));
            
            char c = s.charAt(s.length()-3);
            if(num==0)
                out.println("0.00%");
            else if(c=='[')
                out.println("0.00%");
            else if(c=='K' || c=='k')
                out.println("0.02%");
            else if(c=='M' || c=='m')
                out.println("4.63%");
            else if(c=='G' || c=='g')
                out.println("6.86%");
            else if(c=='T' || c=='t')
                out.println("9.05%");
            else if(c=='P' || c=='p')
                out.println("11.18%");
            else if(c=='E' || c=='e')
                out.println("13.26%");
            else if(c=='Z' || c=='z')
                out.println("15.29%");
            else if(c=='Y' || c=='y')
                out.println("17.28%");
            else if(c=='B' || c=='b')
                out.println("19.22%");
            else
                out.println("21.11%");
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
