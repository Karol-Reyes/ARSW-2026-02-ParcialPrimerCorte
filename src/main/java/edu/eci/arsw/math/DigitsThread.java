package edu.eci.arsw.math;
import java.lang.Thread;
public class DigitsThread extends Thread {

    private final int start;
    private final int nums;
    private static int DigitsPerSum = 8;
    private static double Epsilon = 1e-17;
    private byte[] result;
    private int n;

    public DigitsThread(int start, int nums){
        this.start = start;
        this.nums = nums;
    }

    @Override 
    public void run() {
        operation(start, nums);
    }

    public static byte[] operation(int start, int nums) {
        if (start < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        if (nums < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        byte[] digits = new byte[nums];
        double sum = 0;

        for (int i = 0; i < nums; i++) {
            if (i % DigitsPerSum == 0) {
                sum = 4 * sum(1, start)
                        - 2 * sum(4, start)
                        - sum(5, start)
                        - sum(6, start);

                start += DigitsPerSum;
            }

            sum = 16 * (sum - Math.floor(sum));
            digits[i] = (byte) sum;
        }

        return digits;
    }

    private static double sum(int m, int n) {
        double sum = 0;
        int d = m;
        int power = n;

        while (true) {
            double term;

            if (power > 0) {
                term = (double) hexExponentModulo(power, d) / d;
            } else {
                term = Math.pow(16, power) / d;
                if (term < Epsilon) {
                    break;
                }
            }

            sum += term;
            power--;
            d += 8;
        }

        return sum;
    }

    /// <summary>
    /// Return 16^p mod m.
    /// </summary>
    /// <param name="p"></param>
    /// <param name="m"></param>
    /// <returns></returns>
    private static int hexExponentModulo(int p, int m) {
        int power = 1;
        while (power * 2 <= p) {
            power *= 2;
        }

        int result = 1;

        while (power > 0) {
            if (p >= power) {
                result *= 16;
                result %= m;
                p -= power;
            }

            power /= 2;

            if (power > 0) {
                result *= result;
                result %= m;
            }
        }

        return result;
    }

    public byte[] getResult() {
        return result;
    }
}