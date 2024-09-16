package com.new_problems.recursion;

public class StringToInt {

    public static void main(String[] args) {
        int result = myAtoi("+1");
        System.out.println(" FINAL RESULT : "+ result);
    }
    public static int myAtoi(String s) {
        String res = "";

        boolean[] isNegative = {false};

        //1. Remove white spaces by replacing
        String trimmedString = s.trim();
        int n = trimmedString.length();

        String str = recursiveFunctionCall(trimmedString, res, 0, n, isNegative);

        String boundString = isNegative[0] ? String.valueOf(Integer.MIN_VALUE).substring(1) : String.valueOf(Integer.MAX_VALUE);

        if(str.length() > boundString.length()){
            return isNegative[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        if(str.length()> 0 && String.valueOf(str).matches("-?\\d+")) return Integer.valueOf(str);
        return 0;
    }

    public static String recursiveFunctionCall(String s, String res,int idx, int n, boolean[] isNegative){

        // Base condition if idx >= n return
        if(idx >= n) return res;

        // 2. Condition to ignore white space.
        if(s.charAt(idx) == '-' && res.length() > 0) return res;

        // make boolean as negative
        if(s.charAt(idx) == '-' && res.length() == 0){
            isNegative[0] = true;
        }

        // 3. check any non digit is present in the mid of string
        if((s.charAt(idx) != '-' || s.charAt(idx) != '+')) {
            if(!String.valueOf(s.charAt(idx)).matches("//d")) return res;
        }

        // Add idx item to the result
        res += s.charAt(idx);

        return recursiveFunctionCall(s, res, ++idx, n, isNegative);

    }
}
