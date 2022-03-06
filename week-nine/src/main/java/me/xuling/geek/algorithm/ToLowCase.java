package me.xuling.geek.algorithm;

/**
 * @author jack
 * @since 2022/3/6
 **/
public class ToLowCase {

    public String toLowerCase(String s) {
        char[] sl = s.toCharArray();
        for (int i = 0; i < sl.length; i++) {
            if(sl[i] >= 'A' && sl[i] <= 'Z') {
                sl[i] = (char)(sl[i] - 'A' + 'a');
            }
        }
        return new String(sl);
    }

}
