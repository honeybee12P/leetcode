import java.util.*;

class Solution {

    public int helper(LinkedList<Character> arr) {
        Stack<Integer> s = new Stack<>();
        int num = 0;
        char sign = '+';

        while (arr.size() > 0) {
            char c = arr.removeFirst();

            if(Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c) ;
            }

            if (c == '(') {
                num = helper(arr);
            }

            if (c == '+' || c == '-' || c == ')' || arr.size() == 0) {
                if (sign == '+') {
                    s.push(num);
                } else if (sign == '-'){
                    s.push(-num);
                }

                sign = c;
                num = 0;

                if (c == ')') {
                    break;
                }
            }
        }
        int su = 0;
        for (int n : s) {
            su += n;
        }

        return su;

    }
    public int calculate(String s) {
        LinkedList<Character> arr = new LinkedList<>();
        for (int i = 0; i < s.length(); i ++) {
            arr.add(s.charAt(i));
        }

        System.out.println(arr);

        return helper(arr);


    }
}