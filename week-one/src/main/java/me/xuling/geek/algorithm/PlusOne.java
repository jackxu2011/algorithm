package me.xuling.geek.algorithm;

/**
 * 力扣加一解
 *
 * @author jack
 * @since 2022/1/2
 **/
public class PlusOne {

    public int[] plusOne(int[] digits) {
        boolean needCarry = true;
        for (int i = digits.length-1; i >=0; i-- ) {
            if(needCarry) {
                digits[i] = digits[i] + 1;
            }
            if(digits[i] == 10) {
                digits[i] = 0;
                needCarry = true;
            } else {
                needCarry = false;
                break;
            }
        }
        if(needCarry) {
            int[] tmp = new int[digits.length+1];
            tmp[0] = 1;
            for(int i = 0; i < digits.length; i++) {
                tmp[i+1] = digits[i];
            }
            return tmp;
        }
        return digits;
    }
}
