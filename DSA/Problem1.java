package DSA;

public class Problem1 {

    public int findUnique(int[] arr) {

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem1 obj = new Problem1();
        int[] arr = {};
        System.err.println(obj.findUnique(arr));
    }
}