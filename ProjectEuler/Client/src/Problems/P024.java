package Problems;

public class P024 {
    private P024() {
        super();
    }

    private static int[] fact = new int[11];

    static {
        fact[0] = 1;

        for (int i = 1; i < 11; i++)
            fact[i] = fact[i - 1] * i;
    }

    public static String solve(int n) {
        boolean[] digits = new boolean[10];
        for (int i = 0; i < 10; i++)
            digits[i] = true;

        StringBuilder sb = new StringBuilder(10);
        permutation(sb, digits, n - 1);
        return sb.toString();
    }

    private static void permutation(StringBuilder sb, boolean[] digits,
                                    int n) {
        char[] ar = new char[10];
        for (int i = 0; i < 10; i++)
            ar[i] = (char)i;

        for (int i = 0; i < 10; i++) {
            //            if (n == fact[9 - i]) {
            //                for (int j = i, k = 9; j < k; j++, k--) {
            //                    char temp = ar[j];
            //                    ar[j] = ar[k];
            //                    ar[k] = temp;
            //                }
            //                for (int k = 0; k < 10; k++)
            //                    sb.append(ar[k]);
            //                return;
            //            }

            if (n > fact[9 - i]) {
                int shift = n / fact[9 - i];
                char temp = ar[i];
                ar[i] = ar[i + shift - 1];
                for (int j = i + shift - 1; j > i; j--)
                    ar[j] = ar[j - 1];

                ar[i + 1] = temp;
                n = n % fact[10 - i];
                if (n == 0)
                    n = fact[9 - i];
            }
        }

        for (int i = 0; i < 10; i++)
            sb.append(ar[i]);
    }

    private static void process(StringBuilder sb, boolean[] digits, int n) {
        System.out.println(n + "\t" + sb);
        if (n == 0)
            return;

        //        if (n == 1) {
        //            for (int i = 0; i < 10; i++)
        //                if (digits[i])
        //                    sb.append(i);
        //            return;
        //        }
        //
        //        if (n == 0) {
        //            for (int i = 9; i >= 0; i--)
        //                if (digits[i])
        //                    sb.append(i);
        //            return;
        //        }

        int i = 10;
        while (i > 0 && fact[i] >= n)
            i--;

        int dig = (n - 1) / fact[i];
        n = n % fact[i];
        n++;

        //        if (n == 0) {
        //            for (int j = 9; j >= 0; j--)
        //                if (digits[j])
        //                    sb.append(j);
        //            return;
        //        }
        //        n++;
        int j = 9, count = 1;
        while (count <= i && j >= 0) {
            if (digits[j])
                count++;
            j--;
        }

        System.out.println(j + " :");

        while (j >= 0 && !digits[j])
            j--;

        System.out.println(i + "\t le \t" + j);

        for (i = 0; i < j; i++)
            if (digits[i]) {
                sb.append(i);
                digits[i] = false;
            }

        count = 0;
        while (count < dig && j <= 9) {
            if (digits[j])
                count++;
            j++;
        }

        if (j >= 0 && j < 10 && digits[j]) {
            digits[j] = false;
            sb.append(j);
        }

        process(sb, digits, n);
    }
}
