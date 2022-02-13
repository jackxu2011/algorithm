package me.xuling.geek.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 * @since 2022/2/13
 **/
public class ClimbStair {
    public int climbStairs(int n) {

        if(map.containsKey(n)) {
            return map.get(n);
        }

        int ans = climbStairs(n-1) + climbStairs(n-2);
        map.put(n, ans);

        return ans;
    }

    private Map<Integer, Integer> map = new HashMap<>(){{put(1, 1); put(2,2);}};
}
