package me.xuling.geek.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author jack
 * @since 2022/3/11
 **/
public class EightFigure {

    private static final int DATA_LENGTH = 9;

    public static void main(String[] args) {
        EightFigure eightFigure = new EightFigure();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String start = "";
            for (int i = 0; i < DATA_LENGTH; i++) {
                start += scanner.next();
            }
            System.out.println(eightFigure.run(start));
        }
    }

    private int run(String s) {
        depth.clear();
        q = new PriorityQueue<>();
        depth.put(s, 0);
        q.offer(new Status(calConst(s), s));
        while (!q.isEmpty()) {
            String st = q.poll().status;
            int pos = findX(st);
            if (pos >= 3) {
                expend(st, pos, pos -3);
            }
            if (pos <=5) {
                expend(st, pos, pos + 3);
            }
            if (pos % 3 >0) {
                expend(st, pos, pos - 1);
            }
            if (pos %3 < 2) {
                expend(st, pos, pos + 1);
            }
            if(depth.containsKey(target)) {
                return depth.get(target);
            }
        }
        return -1;
    }

    private void expend(String s, int pos, int nPos) {
        String ns = swap(s, pos, nPos);
        if (depth.containsKey(ns)) {
            if (depth.get(ns) > depth.get(s) + 1) {
                depth.put(ns, depth.get(s) + 1);
            }
            return;
        }
        depth.put(ns, depth.get(s) + 1);
        q.offer(new Status(depth.get(s) + calConst(ns), ns));
    }

    private String swap(String s, int i, int j) {
        StringBuffer stringBuffer = new StringBuffer(s);
        char x = stringBuffer.charAt(i);
        char y = stringBuffer.charAt(j);
        stringBuffer.setCharAt(i, y);
        stringBuffer.setCharAt(j, x);
        return stringBuffer.toString();
    }

    private int findX(String s) {
        for (int i = 0; i < DATA_LENGTH; i++) {
            if (s.charAt(i) == 'x') {
                return i;
            }
        }
        return -1;
    }

    private PriorityQueue<Status> q;

    private Map<String, Integer> depth = new HashMap<>();

    private String target = "12345678x";

    private int[] targetIndex = new int[] {0, 0, 1, 2, 3, 4, 5, 6, 7};

    private int calConst(String status) {
        int[] statusIndex = getStatusIndex(status);
        int ans = 0;
        for (int i = 1; i < DATA_LENGTH; i++) {
            if (statusIndex[i] == targetIndex[i]) {
                continue;
            }
            int sx = statusIndex[i]/3;
            int sy = statusIndex[i]%3;
            int tx = targetIndex[i]/3;
            int ty = targetIndex[i]%3;
            ans += (Math.abs(sx-tx) + Math.abs(sy - ty));
        }
        return ans;
    }

    private int[] getStatusIndex(String status) {
        int[] statusIndex = new int[9];
        for (int i = 0; i < DATA_LENGTH; i++) {
            char tmp = status.charAt(i);
            if (tmp == 'x') { continue; }
            statusIndex[tmp- '0'] = i;
        }
        return statusIndex;
    }

    static class Status implements Comparable<Status> {

        public int cost;

        public String status;

        public Status(int cost, String status) {
            this.cost = cost;
            this.status = status;
        }

        @Override
        public int compareTo(Status o) {
            return this.cost - o.cost;
        }
    }
}
