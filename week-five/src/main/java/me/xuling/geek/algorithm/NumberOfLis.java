package me.xuling.geek.algorithm;

import java.util.Arrays;

/**
 * @author jack
 * @since 2022/2/15
 **/
public class NumberOfLis {

    public int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int[] lisCount = new int[nums.length];
        Arrays.fill(lis, 1);
        Arrays.fill(lisCount, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (lis[j] + 1 == lis[i]) {
                        lisCount[i] = lisCount[i] + lisCount[j];
                    }
                    if (lis[j] + 1 > lis[i]) {
                        lisCount[i] = lisCount[j];
                    }
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        int max = lis[0];
        for (int i = 1; i < lis.length; i++) {
            max = Math.max(max, lis[i]);
        }
        int ans = 0;
        for (int i = 0; i < lis.length; i++) {
            if (max == lis[i]) {
                ans += lisCount[i];
            }
        }

        return ans;
    }
}
