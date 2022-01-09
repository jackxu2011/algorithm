package me.xuling.geek.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray sum
 *
 * @author jack
 * @since 2022/1/9
 **/
public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+2];
        Map<Integer, Integer> preSumMap = new HashMap<>(){{
            put(0, 1);
        }};
        int ans = 0;
        for(int i = 1; i <= nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];

            if(preSumMap.containsKey(preSum[i]-k)) {
                ans+=preSumMap.get(preSum[i]-k);
            }
            if(preSumMap.containsKey(preSum[i])) {
                preSumMap.put(preSum[i], preSumMap.get(preSum[i]) + 1);
            } else {
                preSumMap.put(preSum[i], 1);
            }
        }
        return ans;
    }
}
