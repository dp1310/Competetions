package Template;

import java.io.IOException;

/**
 * Problem Name:
 * Contest ID:
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

        //        String input = "input_file.in", output = "output_file.out";
        //        FileInputStream fip = new FileInputStream(input);
        //        FileOutputStream fop = new FileOutputStream(output);
        //        in = new InputReader(fip);
        //        out = new Output(fop);

        Template a = new Template();
        a.solve();
        out.close();
    }

    private void solve() throws IOException {
        int t = in.readInt();
        while (t > 0) {
            t--;
        }
    }
}
