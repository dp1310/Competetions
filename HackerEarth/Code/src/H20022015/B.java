package H20022015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;

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
        
        while(t>0) {
            t--;
            int[] ar = new int[26];
            String s = in.next();
            
            for(int i=0; i<s.length(); i++) {
                ar[s.charAt(i)-'a']++;
            }
            boolean ev = true;
            
            for(int i=0; i<26; i++) {
                if((ar[i]&1) == 1) {
                    ev = false;
                    break;
                }
            }
            if(ev)
                out.println(1);
            else
                out.println(-1);
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
