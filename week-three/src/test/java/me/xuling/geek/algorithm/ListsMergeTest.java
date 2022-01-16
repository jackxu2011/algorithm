package me.xuling.geek.algorithm;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jack
 * @since 2022/1/16
 **/
class ListsMergeTest {

    @Test
    void mergeKLists() {
        ListNode[] first = new ListNode[0];
        ListsMerge listsMerge = new ListsMerge();
        assertThat(listsMerge.mergeKLists(first)).isNull();
    }
}