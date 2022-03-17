package me.xuling.geek.algorithm;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jack
 * @since 2022/3/13
 **/
public class MouseCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Map<Long, Mouse> mouse = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Long xy = zip(x, y);
                if (mouse.containsKey(xy)) {
                    mouse.get(xy).repeat +=1;
                } else {
                    mouse.put(xy, new Mouse(x, y, 1));
                }
            }
            for ( int i = 0; i < m; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                Long xy = zip(x, y);
                if (mouse.containsKey(xy)) {
                    mouse.remove(xy);
                }
            }
            if (!mouse.isEmpty()) {
                Collection<Mouse> mouses = mouse.values();
                Mouse mouse1 = mouses.stream().max((o1, o2) -> o1.repeat == o2.repeat? ((o2.x + o2.y) == (o1.x + o2.y)? o2.x - o1.x: (o2.x + o2.y)-(o1.x + o2.y)): o2.repeat - o1.repeat).get();
                System.out.println(mouse1.x + " " + mouse1.y);
            }
        }
    }

    private static Long zip(int x, int y) {
        return x * 100000000L + y;
    }

    static class Mouse {
        public int x;
        public int y;
        public int repeat;
        public Mouse(int x, int y, int repeat) {
            this.x = x;
            this.y = y;
            this.repeat = repeat;
        }
    }
}
