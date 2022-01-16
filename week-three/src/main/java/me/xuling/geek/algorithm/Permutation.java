package me.xuling.geek.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 * @since 2022/1/16
 **/
public class Permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        this.selected = new ArrayList<>();
        permute();
        return ans;
    }

    private void permute() {
        if(selected.size() == nums.length) {
            ans.add(new ArrayList<>(selected));
        }
        for(int j = 0; j< nums.length; j++) {
            if(used[j]) continue;
            if(j>0 && nums[j] == nums[j-1] && !used[j-1]) continue;
            used[j] = true;
            selected.add(nums[j]);
            permute();
            used[j] = false;
            selected.remove(selected.size()-1);
        }
    }

    private boolean[] used;
    private List<Integer> selected;
    private int[] nums;
    private List<List<Integer>> ans = new ArrayList<>();
}
