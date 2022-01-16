package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jack
 * @since 2022/1/16
 **/
class PermutationTest {

    @Test
    void permuteUnique() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> result = new ArrayList<>(){{
            add(new ArrayList<>(){{add(1); add(1); add(2);}});
            add(new ArrayList<>(){{add(1); add(2); add(1);}});
            add(new ArrayList<>(){{add(2); add(1); add(1);}});
        }};
        Permutation permutation = new Permutation();
        assertThat(permutation.permuteUnique(nums)).containsAll(result);

    }
}