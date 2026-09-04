package edu.eci.arsw.math;

public class DigitsThread extends Thread {

    private final int start;
    private final int nums;
    private byte[] result;

    public DigitsThread(int start, int nums){
        this.start = start;
        this.nums = nums;
    }

    @Override
    public void run() {
        byte[] digit = PiDigits.getDigits(start, nums);
    }

    public byte[] getResult() {
        return result;
    }
}