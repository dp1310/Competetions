//package urozero2014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class A {
    public A() {
        super();
    }

    public static void main(String[] args) {
        A a = new A();
        a.process();
    }
    
    public void process() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        
        int n = in.nextInt();
        int a = -1000000005;
        int b = 1000000005;
        String amb = "ambiguous";
        String none = "none";
        
        int at = 0;
        int bt = 0;
        boolean t = true;
        int[] ar = new int[n];
        
        for(int i=0; i<n; i++) {
            String temp = in.next();
            if(temp.charAt(0)=='x')
                ar[i] = Integer.MAX_VALUE;
            else
                ar[i] = Integer.parseInt(temp);
        }
        
        for(int i=0; i < n-1; i++) {
            if(ar[i]==ar[i+1]) {
                out.println(none);
                out.close();
                return;
            }
            if((i&1) == 0) {
                if(ar[i] != Integer.MAX_VALUE && ar[i+1] != Integer.MAX_VALUE && ar[i]>=ar[i+1]) {
                    out.println(none);
                    out.close();
                }
            } else {
                if(ar[i] != Integer.MAX_VALUE && ar[i+1] != Integer.MAX_VALUE && ar[i]<=ar[i+1]) {
                    out.println(none);
                    out.close();
                }
            }
        }
        
        for(int i=0; i<n-1; i++) {
            if((i&1)==0) {
                if(ar[i]==Integer.MAX_VALUE) {
                    b = b < ar[i+1] ? b : ar[i+1];
                } else if(ar[i+1]==Integer.MAX_VALUE) {
                    a = a > ar[i] ? a : ar[i];
                }
            } else {
                if(ar[i]==Integer.MAX_VALUE) {
                    a = a > ar[i+1] ? a : ar[i+1];
                } else if(ar[i+1]==Integer.MAX_VALUE) {
                    b = b > ar[i] ? ar[i] : b;
                }
            }
        }
        
        if(b==a+2) {
            out.println(a+1);
            out.close();
            return;
        }
        
        if(a+2>b) {
            out.println(none);
            out.close();
            return;
        }
        
        out.println(amb);
        out.close();
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
