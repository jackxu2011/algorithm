package me.xuling.geek.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * @since 2022/2/13
 **/
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> min = new ArrayList<>();
        min.add(triangle.get(triangle.size()-1));
        for (int i = triangle.size()-2; i >=0; i--) {
            List<Integer> layer = triangle.get(i);
            List<Integer> nextLayer = min.get(triangle.size() -i -2);
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j< layer.size() ; j++)
                cur.add(layer.get(j) + Math.min(nextLayer.get(j), nextLayer.get(j+1)));
            min.add(cur);
        }
        return min.get(triangle.size()-1).get(0);
    }
}
