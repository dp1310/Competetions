package SRM;

import Template.InputReader;
import Template.Output;

import java.io.IOException;

/**
 * Contest ID: SRM 681 Round I
 * Link: https://community.topcoder.com/stat?c=round_overview&er=5&rd=16651
 *
 * @author: Ashok Rajpurohit (ashok1113@gmail.com)
 */
public class SRM681R1 {
    private static Output out;
    private static InputReader in;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new Output(System.out);

        SRM681R1 a = new SRM681R1();
        a.solve();
        out.close();
    }

    private void solve() throws IOException {
        int t = in.readInt();
        CoinFlipsDiv2 cf = new CoinFlipsDiv2();
        while (t > 0) {
            out.println(cf.countCoins(in.read()));
            out.flush();
        }
    }

    final static class CoinFlipsDiv2 {
        public int countCoins(String state) {
            if (state.length() == 1)
                return 0;

            int count = 0;
            for (int i = 1; i < state.length() - 1; i++) {
                if (state.charAt(i) != state.charAt(i - 1) ||
                    state.charAt(i + 1) != state.charAt(i))
                    count++;
            }

            if (state.charAt(state.length() - 1) !=
                state.charAt(state.length() - 2))
                count++;

            if (state.charAt(0) != state.charAt(1))
                count++;

            return count;
        }
    }
}
