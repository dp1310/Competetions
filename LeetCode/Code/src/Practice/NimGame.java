package Practice;

import Template.InputReader;
import Template.Output;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Problem Name: Nim Game
 * Link: https://leetcode.com/problems/nim-game/
 *
 * @author: Ashok Rajpurohit (ashok1113@gmail.com)
 */
public class NimGame {
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

        NimGame a = new NimGame();
        a.solve();
        out.close();
    }

    private void solve() throws IOException {
        while (true)
            System.out.println(canWinNim(in.readInt()));
    }

    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }
}
