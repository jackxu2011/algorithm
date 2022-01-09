package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jack
 * @since 2022/1/9
 **/
class SubArraySumTest {

    @Test
    void subarraySum() {
        SubArraySum subArraySum = new SubArraySum();
        int[] array = new int[]{ 1, 2, 3};
        assertThat(subArraySum.subarraySum(array, 3)).isEqualTo(2);
    }
}