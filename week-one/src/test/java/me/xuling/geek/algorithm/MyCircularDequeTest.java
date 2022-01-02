package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jack
 * @since 2022/1/2
 **/
class MyCircularDequeTest {

    @Test
    void CircularDequeTest() {
        MyCircularDeque obj = new MyCircularDeque(3);
        assertThat(obj.insertFront(1)).isTrue();
        assertThat(obj.insertLast(2)).isTrue();
        assertThat(obj.deleteLast()).isTrue();
        assertThat(obj.deleteLast()).isTrue();
        assertThat(obj.getFront()).isEqualTo(-1);
        assertThat(obj.getRear()).isEqualTo(-1);
        assertThat(obj.isEmpty()).isTrue();
        assertThat(obj.isFull()).isFalse();
    }

}