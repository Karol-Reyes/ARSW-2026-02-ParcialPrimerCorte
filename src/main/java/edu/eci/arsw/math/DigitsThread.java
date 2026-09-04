package edu.eci.arsw.math;

public class DigitsThread extends Thread {

    private final int start;
    private final int nums;
    private byte[] result;
    private int n;

    public DigitsThread(int start, int nums){
        this.start = start;
        this.nums = nums;
    }

    public void run() {
       result = PiDigits.getDigits(start, nums, n);
    }

    public byte[] getResult() {
        return result;
    }
}