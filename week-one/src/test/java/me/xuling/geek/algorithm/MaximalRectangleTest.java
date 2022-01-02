package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jack
 * @since 2022/1/2
 **/
class MaximalRectangleTest {

    @Test
    void maximalRectangle() {
        char[][] a = {{'0', '0', '1'},{'1', '1', '1'}};
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        assertThat( maximalRectangle.maximalRectangle(a)).isEqualTo(3);
    }
}