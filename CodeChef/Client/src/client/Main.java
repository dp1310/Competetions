import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        System.out.println(String.valueOf(Integer.MAX_VALUE).length());
        System.out.println(String.valueOf(Long.MAX_VALUE).length());
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
    public void solve(FEB15.InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Object b = n;
//        out.println(b instanceof int);
        out.println(b instanceof Integer);
        
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
