package me.xuling.geek.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 * @since 2022/3/17
 **/
public class Squares {
    public int numSquares(int n) {
        if (isSquares(n)) {
            return 1;
        }

        int[] opt = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (isSquares(i)) {
                opt[i] = 1;
            } else {
                opt[i] = n + 1;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isSquares(i-j)) {
                    opt[i] = Math.min(opt[j] + 1, opt[i]);
                }
            }
            System.out.println(i + " " + opt[i]);
        }
        return opt[n];
    }

    private boolean isSquares(int n) {
        if (squares.containsKey(n)) {
            return squares.get(n);
        }
        int l = 1;
        int r = n/2 + 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (mid * mid == n) {
                squares.put(n, true);
                return true;
            }
            if (mid * mid < n) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        squares.put(n, false);
        return false;
    }

    private Map<Integer, Boolean> squares = new HashMap<>() {{put(1, true);}};
}
