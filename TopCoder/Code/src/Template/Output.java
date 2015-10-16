package Template;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Output extends PrintWriter {
    //    private PrintWriter out;

    public Output() {
        super(System.out);
    }

    public Output(OutputStream outputStream) {
        super(outputStream);
    }

    public void print(int[] ar) {
        StringBuilder sb = new StringBuilder(ar.length << 1);
        for (int e : ar)
            sb.append(e).append(' ');

        println(sb);
    }
}
