import java.util.*;
public class Solution {
    
    static boolean isSquare(long x) {
        long sqrtX = (long)Math.sqrt(x);
        return sqrtX*sqrtX == x;
    }
    
    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        for (int t=0; t<T; t++) {
            long N = input.nextLong();
            int all = 1;
            int square = 0;
            for (long i=2; i*i<=N; i++) {
                if (N%i == 0) {
                    long j = N/i;
                    if (i%2 == 0 && isSquare(i)) {
                        square++;
                    }
                    all++;
                    if (i != j) {
                        all++;
                        if (j%2 == 0 && isSquare(j)) {
                            square++;
                        }
                    }
                }
            }
            long gcd = gcd(all, square);
            all /= gcd;
            square /= gcd;
            System.out.println(square == 0 ? 0 : square+"/"+all);
        }
    }

}
