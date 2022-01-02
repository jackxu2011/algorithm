package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * @author jack
 * @since 2022/1/2
 **/
class PlusOneTest {

    @Test
    void plusOne() {
        int[] test1 = {1, 2, 3};
        int[] expect1 = {1, 2, 4};
        int[] test2 = {9, 9};
        int[] expect2 = {1, 0, 0};
        PlusOne plusOne = new PlusOne();
        assertThat(plusOne.plusOne(test1)).containsExactly(expect1);
        assertThat(plusOne.plusOne(test2)).containsExactly(expect2);
    }
}