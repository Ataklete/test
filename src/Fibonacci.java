import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public static long getFibonacciOptimizedIterative(long n) {
        if (n <= 1) {
            return n;
        }
        long x = 0; // Represents F(i-2)
        long y = 1; // Represents F(i-1)
        long ans = 0; // Represents F(i)

        for (int i = 2; i <= n; i++) {
            ans = x + y;
            x = y;
            y = ans;
        }
        return ans;
    }

    private static final Map<Long, Long> memo = new HashMap<>();

    public static long getFibonacciMemoized(long n) {
        if (n <= 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        long result = getFibonacciMemoized(n-1) + getFibonacciMemoized(n-2);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        //optimized way
        System.out.println(getFibonacciOptimizedIterative(9));
        //memorization way
        System.out.println(getFibonacciMemoized(9));
    }
}
