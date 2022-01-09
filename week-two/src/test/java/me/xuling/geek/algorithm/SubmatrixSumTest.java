package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jack
 * @since 2022/1/9
 **/
class SubmatrixSumTest {

    @Test
    void numSubmatrixSumTarget() {
        SubmatrixSum submatrixSum = new SubmatrixSum();
        int[][] array = new int[][]{{ 0, 1, 0}};
        assertThat(submatrixSum.numSubmatrixSumTarget(array, 0)).isEqualTo(2);
    }
}