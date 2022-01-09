package me.xuling.geek.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 * @since 2022/1/9
 **/
public class SubmatrixSum {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        for(int i = 0; i < matrix.length; i++) {
            int[] array = new int[matrix[0].length];
            for(int j = i; j < matrix.length; j++) {
                for(int k = 0; k < matrix[0].length; k++) {
                    array[k] +=matrix[j][k];
                }
                ans += subarraySum(array, target);
            }
        }
        return ans;
    }

    private int subarraySum(int[] nums, int k) {
        int pre = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>(){{
            put(0, 1);
        }};
        int ans = 0;
        for(int i = 1; i <= nums.length; i++) {
            pre += nums[i-1];

            if(preSumMap.containsKey(pre-k)) {
                ans+=preSumMap.get(pre-k);
            }
            if(preSumMap.containsKey(pre)) {
                preSumMap.put(pre, preSumMap.get(pre) + 1);
            } else {
                preSumMap.put(pre, 1);
            }
        }
        return ans;
    }
}
