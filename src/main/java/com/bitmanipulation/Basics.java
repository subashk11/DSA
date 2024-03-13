package com.bitmanipulation;

public class Basics {
    public static void main(String[] args) {

        int a = 18, i = 2;

        //1. check if the i-th bit is set or not
        boolean isSet = checkIthBit(a, i);
        System.out.println("Is " + i + "th bit set in " + a + " : " + isSet);

        //2. set the i-th bit
        int num = setIthBit(a, i);
        System.out.println("After setting " + i + "th bit in " + a + " : " + num);

        //3. clear the i-th bit
        int clear = clearIthBit(a, i);
        System.out.println("After clearing " + i + "th bit in " + a + " : " + clear);

        //4. toggle the i-th bit
        int toggle = toggleIthBit(a, i);
        System.out.println("After toggling " + i + "th bit in " + a + " : " + toggle);

        //5. remove the last set bit
        int lastSetBit = removeLastSetBit(a);
        System.out.println("After removing last set bit in " + a + " : " + lastSetBit);

    }

    private static int removeLastSetBit(int a) {
        int num = a-1;
        int result = a & num;
        return result;
    }

    private static int toggleIthBit(int a, int i) {
        int num = 2 << i;
        int result = a ^ num;
        return result;
    }

    private static int clearIthBit(int a, int i) {
        int num = 2 << i;
        num = ~num;
        int result = a & num;
        return result;
    }

    private static int setIthBit(int a, int i) {
        int num = 2 << i;
        int result = a | num;
        return result;
    }

    private static boolean checkIthBit(int a, int i) {

        int num = 2 << i;
        int res = a & num;
        return res > 0;
    }
}
