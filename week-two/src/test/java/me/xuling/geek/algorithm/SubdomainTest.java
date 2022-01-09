package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jack
 * @since 2022/1/9
 **/
class SubdomainTest {

    @Test
    void subdomainVisits() {
        Subdomain subdomain = new Subdomain();
        String[] subdomains = new String[] {"9001 discuss.leetcode.com"};
        List<String> repected = new ArrayList<>(){{
            add("9001 com");
            add("9001 leetcode.com");
            add("9001 discuss.leetcode.com");
        }};
        List<String> result = subdomain.subdomainVisits(subdomains);
        assertThat(result).containsAll(repected);
    }
}