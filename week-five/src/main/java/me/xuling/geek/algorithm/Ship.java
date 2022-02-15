package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/2/13
 **/
public class Ship {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        while (left < right) {
            int mid = (left + right)/2;
            if (valid(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean valid(int[] weights, int days, int load) {
        int needDays = 1;
        int curLoad = 0;
        for (int i = 0; i < weights.length; i++) {
            if (curLoad + weights[i] > load) {
                needDays++;
                curLoad = weights[i];
            } else {
                curLoad += weights[i];
            }
        }
        return needDays <= days;
    }
}
