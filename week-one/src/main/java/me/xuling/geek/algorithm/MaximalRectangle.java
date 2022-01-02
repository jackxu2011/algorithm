package me.xuling.geek.algorithm;

import java.util.Stack;

/**
 * 最大舔弄
 *
 * @author jack
 * @since 2022/1/2
 **/
public class MaximalRectangle {

    public int maximalRectangle(char[][] matrix) {

        int ans = 0;

        int[] row = new int[matrix[0].length + 1];
        for(int i = 0; i < row.length; i++) {
            row[i] = 0;
        }
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == '1') {
                    row[j] += 1;
                } else {
                    row[j] = 0;
                }
            }
            ans = max(ans, matrixRectangle(row));
        }
        return ans;

    }

    private int matrixRectangle(int[] matrix) {
        rects.clear();
        int ans = 0;
        for(int i = 0; i < matrix.length; i++) {
            int accumulativeWidth = 0;
            while(!rects.empty() && rects.peek().height>=matrix[i]) {
                Rect rect = rects.pop();
                accumulativeWidth += rect.width;
                ans = max(ans, rect.height * accumulativeWidth);
            }
            rects.push(new Rect(accumulativeWidth + 1, matrix[i]));
        }
        return ans;
    }

    private int max(int a, int b) {
        return a>b? a: b;
    }

    private Stack<Rect> rects = new Stack<>();

    private class Rect {
        public final int width;
        public final int height;
        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }
}
