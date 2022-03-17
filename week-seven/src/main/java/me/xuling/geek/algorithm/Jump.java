package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/3/17
 **/
public class Jump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return true;
        }
        for (int i = 0; i < n;) {
            int farthest = i;
            int nextStep = i;
            for (int j = 1; j <= nums[i]; j++ ) {
                int tmp = i + j + nums[i+j];
                if (tmp >= n - 1) {
                    return true;
                }
                if (tmp > farthest) {
                    farthest = tmp;
                    nextStep = i + j;
                }
            }
            if (nextStep == i) {
                return false;
            }
            i = nextStep;
        }
        return false;
    }
}
