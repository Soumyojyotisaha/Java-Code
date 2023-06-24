import java.util.*;

class karatsuba {
    public static int karat(int a, int b) {
        String as = Integer.toString(a);
        String bs = Integer.toString(b);
        int alen = as.length();
        int blen = bs.length();
        if (alen == 1 && blen == 1)
            return a * b;
        else {
            int n = Math.max(alen, blen);
            while (alen != n) {
                as = "0" + as;
                alen = as.length();
            }
            while (blen != n) {
                bs = "0" + bs;
                blen = bs.length();
            }
            int aL = Integer.parseInt(as.substring(0, n / 2));
            int aR = Integer.parseInt(as.substring(n / 2, n));
            int bL = Integer.parseInt(bs.substring(0, n / 2));
            int bR = Integer.parseInt(bs.substring(n / 2, n));
            int x1 = karat(aL, bL);
            int x2 = karat(aL + aR, bL + bR);
            int x3 = karat(aR, bR);
            int m = (int) Math.ceil(n / 2.0);
            return (int) (x1 * Math.pow(10, m * 2) + (x2 - x1 - x3) * Math.pow(10, m) + x3);
        }
    }

    public static void main(String[] args) {
        System.out.println(karat(5678, 1234));
    }
}
