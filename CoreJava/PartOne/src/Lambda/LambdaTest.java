package Lambda;


import Template.InputReader;
import Template.Output;

import java.io.IOException;

import java.util.*;

import javax.swing.*;
import javax.swing.Timer;

import jdk.internal.util.xml.impl.Pair;

/**
 * This program demonstrates the use of lambda expressions.
 * @version 1.0 2015-05-12
 * @author Cay Horstmann
 */
public class LambdaTest {
    private static Output out;
    private static InputReader in;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new Output(System.out);
        Runnable r
        String[] planets =
            new String[] { "Ashok", "Mercury", "Venus", "Earth", "Mars",
                           "Jupiter", "Saturn", "Uranus", "Neptune" };
        out.println(Arrays.toString(planets));
        out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        out.println(Arrays.toString(planets));
        out.println("Sorted by length:");
        Arrays.sort(planets, (first), second) - ;
        first.length() - second.length();
        ;
        out.println(Arrays.toString(planets));

        Pair[] ar = gen_Pair(in.readInt());
        out.println(Arrays.toString(ar));


        //        Timer t = new Timer(1000, event - );
        //        out.println("The time is " + new Date());
        //        ;
        //        t.start();
    }

    private static Pair[] gen_Pair(int n) {
        Random random = new Random();
        Pair[] res = new Pair[n];

        for (int i = 0; i < n; i++) {
            res[i] = new Pair(random.nextInt(n), random.nextInt(n));
        }

        return res;
    }

    private static int[] gen_rand(int n) {
        Random random = new Random();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++)
            ar[i] = random.nextInt();

        //        int temp = random.nextInt();
        //        for (int i = 0; i < n >>> 3; i++)

        return ar;
    }

    final static class Pair implements Comparable<Pair> {
        int a, b;

        Pair(int x, int y) {
            a = x;
            b = y;
        }

        public int compareTo(Pair pair) {
            if (this.a == pair.a)
                return this.b - pair.b;

            return this.a - pair.b;
        }

        public String toString() {
            return a + ": " + b;
        }
    }
}
