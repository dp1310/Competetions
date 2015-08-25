package FEB15;
//package client.FEB15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.StringTokenizer;

public class CHEFEQ {

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
    public void solve (FEB15.InputReader in, PrintWriter out) {
        int t = in.nextInt();
        
        while(t>0) {
            t--;
            int n = in.nextInt();
            int[] a = new int[n];
            
            for(int i=0; i<n; i++)
                a[i] = in.nextInt();

            Merge.sort(a);
            
            int mcount = 1;
            int count = 0;
            
            int i = 0;
            while(i<n) {
                count = 1;
                i++;
                
                if(i==n)
                    break;
                
                while(a[i] == a[i-1]) {
                    count++;
                    i++;
                    if(i==n)
                        break;
                }
                mcount = mcount > count ? mcount : count;
            }
            
            out.println(n-mcount);
        }
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

class Merge {
    
    public static void sort(int[] a) {
        int[] b = new int[a.length];
        sort(a, b, 0, a.length - 1);
    }
    
    private static void sort(int[] a, int[] b, int begin, int end) {
        if (begin == end) {
            return;
        }

        int mid = (begin + end) / 2;
        sort(a, b, begin, mid);
        sort(a, b, mid + 1, end);
        merge(a, b, begin, end);
    }

    private static void merge(int[] a, int[] b, int begin, int end) {
        int mid = (begin + end) / 2;
        int i = begin;
        int j = mid + 1;
        int k = begin;
        while (i <= mid && j <= end) {
            if (a[i] > a[j]) {
                b[k] = a[j];
                j++;
            } else {
                b[k] = a[i];
                i++;
            }
            k++;
        }
        if (j <= end) {
            while (j <= end) {
                b[k] = a[j];
                k++;
                j++;
            }
        }
        if (i <= mid) {
            while (i <= mid) {
                b[k] = a[i];
                i++;
                k++;
            }
        }

        i = begin;
        while (i <= end) {
            a[i] = b[i];
            i++;
        }
    }
}
