package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/3/6
 **/
public class LastWord {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int ans = 0;
        int lastIndex = n-1;
        while (lastIndex >= 0 && !isLetter(s.charAt(lastIndex))) {
            lastIndex--;
        }

        while (lastIndex >= 0 && isLetter(s.charAt(lastIndex))) {
            lastIndex--;
            ans++;
        }
        return ans;
    }

    private boolean isLetter(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z';
    }
}
