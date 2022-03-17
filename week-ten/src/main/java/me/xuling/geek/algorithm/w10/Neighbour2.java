package me.xuling.geek.algorithm.w10;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author jack
 * @since 2022/2/28
 **/
public class Neighbour2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n+1];
            int[] ans = new int[n+1];
            TreeSet<Data> datas = new TreeSet<>(((o1, o2) -> o1.val == o2.val? o1.idx - o2.idx: o1.val - o2.val));
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
                Data data = new Data(a[i], i);
                datas.add(data);
                if ( i >= 2) {
                    Data floor = datas.lower(data);
                    Data ceiling = datas.higher(data);
                    if(ceiling == null) {
                        ans[i] = floor.idx;
                    } else if (floor == null || ceiling.val - data.val < data.val - floor.val) {
                        ans[i] = ceiling.idx;
                    } else {
                        ans[i] = floor.idx;
                    }
                }
            }

            for (int i = 2; i <= n; i++) {
                System.out.println(Math.abs(a[i] - a[ans[i]]) + " " + ans[i]);
            }
        }

    }

    static class Data {
        public int val;
        public int idx;
        public Data(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
