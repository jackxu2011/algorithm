package me.xuling.geek.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jack
 * @since 2022/2/24
 **/
public class SuperMarket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int produceCount = sc.nextInt();
            if (produceCount == 0) {
                System.out.println(0);
                continue;
            }
            //mackset
            fa = new int[produceCount + 1];
            for (int i = 0; i <= produceCount; i++) {
                fa[i] = i;
            }
            List<Produce> produces = new ArrayList<>();
            for (int j = 0; j < produceCount; j++) {
                int price = sc.nextInt();
                int expired = sc.nextInt();
                produces.add(new Produce(price, expired));
            }
            produces.sort((o1, o2) -> o2.price - o1.price);
            int ans = 0;
            for (int i = 0; i < produceCount; i++) {
                Produce produce = produces.get(i);
                int sellDay = find(produce.expired);
                if (sellDay != 0) {
                    //UnionSet
                    fa[sellDay] = fa[sellDay - 1];
                    ans += produce.price;
                }
            }
            System.out.println(ans);
        }
    }

    private static int find(int day) {
        if (fa[day] == day) {
            return day;
        }
        return fa[day] = find(fa[day]);
    }

    private static int[] fa;

    static class Produce {
        public int price;
        public int expired;

        public Produce(int price, int expired) {
            this.price = price;
            this.expired = expired;
        }
    }
}
