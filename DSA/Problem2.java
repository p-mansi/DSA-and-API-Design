package DSA;

public class Problem2 {
    public static char findNonDublicate(String str) {
        char ans = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (j == i) {
                        continue;
                    }
                    count++;
                    break;
                }
            }
            if (count == 0) {
                ans = str.charAt(i);
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabbcdeccccccccccdddddddddddddddeeeeeeeee";
        char ans = findNonDublicate(str);
        if (ans == 0) {
            System.out.println("null");
        } else {
            System.err.println(ans);
        }
    }
}
