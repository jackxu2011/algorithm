package me.xuling.geek.algorithm.w10;

import java.util.PriorityQueue;

/**
 * @author jack
 * @since 2022/3/17
 **/
public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = new int[]{1,-9,8,-6,6,4,0,5};
        maxSlidingWindow.maxSlidingWindow(nums, 4);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Data> data = new PriorityQueue<>((o1, o2) -> o2.value == o1.value? o2.index - o1.index:o2.value - o1.value);
        int n = nums.length;
        int[] ans = new int[n-k+1];
        for (int i = 0; i < n; i++) {
            data.offer(new Data(i, nums[i]));
            if (i >= k-1) {
                Data d = data.peek();
                System.out.println(i + " " + (i-k+1) + " " + d.index +" " + d.value);
                while(d.index < i-k+1) {
                    // drop d
                    data.poll();
                    // get next d
                    d = data.peek();
                }
                ans[i-k+1] = d.value;
            }
        }
        return ans;
    }

    static class Data {
        public int index;
        public int value;
        public Data(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
