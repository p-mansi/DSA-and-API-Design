package DSA;

public class Problem3 {

    public static boolean balancedParentheses(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
                default:
                    continue;
            }
            if (count < 0) {
                return false;
            }

        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(balancedParentheses(""));
        System.out.println(balancedParentheses("abc124"));
        System.out.println(balancedParentheses(")("));
        System.out.println(balancedParentheses("((("));
        System.out.println(balancedParentheses("())))"));
        System.out.println(balancedParentheses("()()"));
        System.out.println(balancedParentheses("(a+b)(d-2)))"));

    }
}
