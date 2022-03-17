package me.xuling.geek.algorithm.w10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author jack
 * @since 2022/2/28
 **/
public class Neighbour {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            a = new Integer[n + 1];
            Integer[] r = new Integer[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
                r[i] = i;
            }
            Arrays.sort(r, 1, n+1, Comparator.comparingInt(o -> a[o]));
            Node[] pos = new Node[n+1];
            Node head = new Node();
            Node tail = new Node();
            head.next = tail;
            tail.pre = head;
            head.val = a[r[1]] - 1000000000;
            tail.val = a[r[n]] + 1000000000;
            for (int i = 1; i <= n; i++) {
                pos[r[i]] = addNode(tail.pre, r[i]);
            }
            int[] ans = new int[n+1];
            for (int i = n; i > 1; i--) {
                Node curr = pos[i];
                if(a[i] - curr.pre.val <= curr.next.val - a[i]) {
                    ans[i] = curr.pre.idx;
                } else {
                    ans[i] = curr.next.idx;
                }
                deleteNode(curr);
            }
            for (int i = 2; i <= n; i++) {
                System.out.println(Math.abs(a[i] - a[ans[i]]) + " " + ans[i]);
            }
        }

    }

    private static void deleteNode(Node curr) {
        curr.pre.next = curr.next;
        curr.next.pre = curr.pre;
    }

    private static Integer[] a;

    private static Node addNode(Node pre, Integer idx) {
        Node newNode = new Node();
        newNode.val = a[idx];
        newNode.idx = idx;
        newNode.next = pre.next;
        pre.next.pre = newNode;
        newNode.pre = pre;
        pre.next = newNode;
        return newNode;
    }

    static class Node {
        public int val;
        public int idx;
        public Node next;
        public Node pre;
    }
}
