package me.xuling.geek.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * subdomain visit count
 *
 * @author jack
 * @since 2022/1/9
 **/
public class Subdomain {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> reslut = new HashMap<>();
        for(int i = 0; i < cpdomains.length; i++) {
            String[] split = cpdomains[i].split(" ");
            int count = Integer.parseInt(split[0]);
            String[] subdomains = split[1].split("\\.");
            for(int j = 0; j < subdomains.length; j++) {
                String[] slice = Arrays.copyOfRange(subdomains, j,  subdomains.length);
                String subdomain = String.join(".", slice);
                if(reslut.containsKey(subdomain)) {
                    reslut.put(subdomain, reslut.get(subdomain) + count);
                } else {
                    reslut.put(subdomain, count);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : reslut.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
