package FEB15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;
//package model;

public class DEVLOCK {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FEB15.InputReader in = new FEB15.InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FEB15.TaskA solver = new FEB15.TaskA();
        solver.solve(in, out);
        out.close();
    }
}

class TaskA {
    public static int mod = 998244353;
    public void solve(FEB15.InputReader in, PrintWriter out) {
        int n = in.nextInt();

        while (n > 0) {
            n--;
            //            out.println(s);
        }
    }
    
    private static int div2 (int n, int s) {
        if(s%3 != 0)
            return 0;
        if(n*9 < s)
            return 0;
        if(n*9 == s)
            return 1;
        return 0;
    }
    
    private static int div3(int n, int s) {
        return 0;
    }
    
    private static int div5(int n, int s) {
        return 0;
    }
    
    private static int div7(int n, int s) {
        return 0;
    }
    
    private static int div9(int n, int s) {
        if(s%9 != 0)
            return 0;
    }
    
    private static int div11(int n, int s) {
        return 0;
    }
}

class InputReader {
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
