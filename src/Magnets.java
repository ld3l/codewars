
/* ###TASK### - https://www.codewars.com/kata/56c04261c3fcf33f2d000534/train/java */

class Magnets {

    public static double doubles(int maxk, int maxn) {
        double result = 0;
        for (int k = 1; k <= maxk; k++) {
            for (int n = 1; n <= maxn; n++) {
                result += 1.0 /  (k * Math.pow(n + 1, 2 * k));
            }
        }
        return result;
    }
}