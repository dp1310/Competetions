package Template;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Problem Name:
 * Link:
 *
 * @author: Ashok Rajpurohit (ashok1113@gmail.com)
 */
public class Template {
    private static Output out;
    private static InputReader in;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new Output(System.out);

        //        String path =
        //            "D:\\GitHub\\Competetions\\ProjectEuler\\Client\\src\\Problems\\", input =
        //            "input_file.in", output = "output_file.out";
        //        in = new InputReader(path + input);
        //        out = new Output(path + output);

        Template a = new Template();
        try {
            a.solve();
        } catch (IOException ioe) {
            out.close();
        }
        out.close();
    }

    private void solve() throws IOException {
        while (true) {
            out.println(in.read());
        }
    }
}
